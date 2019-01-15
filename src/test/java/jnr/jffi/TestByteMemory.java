/*
 * Copyright 2019 aploese.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jnr.jffi;

import java.lang.reflect.Field;
import jnr.jffi.memory.ByteMemory;
import jnr.jffi.spi.PosixLibraryLoaderImpl;
import jnr.jffi.tags.BenchmarkTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class TestByteMemory {

    private static LibraryLoader libraryLoader;
    final static int BENCHMARK_ROUNDS = 100000000;
    final static byte VALUE_1 = (byte) 0x55;
    final static byte VALUE_2 = (byte) 0xF0;
    protected final static sun.misc.Unsafe unsafe = sun.misc.Unsafe.class.cast(getUnsafe());

    @BeforeAll
    public static void setUpClass() {
        libraryLoader = new PosixLibraryLoaderImpl();
    }

    @AfterAll
    public static void tearDownClass() {
        libraryLoader = null;
    }

    private static Object getUnsafe() {
        try {
            Class sunUnsafe = Class.forName("sun.misc.Unsafe");
            Field f = sunUnsafe.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            return f.get(sunUnsafe);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testBytes() {
        System.out.println("testAllocateBytes");
        ByteMemory mem = libraryLoader.allocateMemory(64);
        assertNotNull(mem);

        mem.setByte(VALUE_2);
        Assertions.assertEquals(VALUE_2, mem.getByte());
        Assertions.assertEquals(Byte.valueOf(VALUE_2), mem.getValue());

        mem.byteValue(16, VALUE_1);
        Assertions.assertEquals(VALUE_1, mem.byteValue(16));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            mem.byteValue(-1);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            mem.byteValue(64);
        });
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            mem.byteValue(128);
        });
    }

    @Test
    public void testBenchmarkGet() {
        System.out.println("testBenchmarkGet");
        final ByteMemory mem = libraryLoader.allocateMemory(1);
        for (int i = 0; i < BENCHMARK_ROUNDS; i++) {
            mem.getByte();
        }
    }

    @Test
    public void testBenchmarkSet() {
        System.out.println("testBenchmarkGet");
        final ByteMemory mem = libraryLoader.allocateMemory(1);
        for (int i = 0; i < BENCHMARK_ROUNDS; i++) {
            mem.setByte((byte) 16);
        }
    }

    @BenchmarkTest
    @Test
    public void testBenchmarkUnsafeGet() {
        System.out.println("testBenchmarkBytesUnsafeGet");
        final long address = unsafe.allocateMemory(1);
        for (int i = 0; i < BENCHMARK_ROUNDS; i++) {
            unsafe.getByte(address);
        }
    }

    @BenchmarkTest
    @Test
    public void testBenchmarkUnsafePut() {
        System.out.println("testBenchmarkUnsafePut");
        final long address = unsafe.allocateMemory(1);
        for (int i = 0; i < BENCHMARK_ROUNDS; i++) {
            unsafe.putByte(address, (byte) 16);
        }
    }
}
