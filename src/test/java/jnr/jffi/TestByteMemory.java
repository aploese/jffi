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
    final static int benchruns = 100000000;
    final static byte value1 = (byte) 0x55;
    final static byte value2 = (byte) 0xF0;
    protected static sun.misc.Unsafe unsafe = sun.misc.Unsafe.class.cast(getUnsafe());

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
    public void testAllocateBytes() {
        System.out.println("testAllocateBytes");
        ByteMemory mem = libraryLoader.allocateMemory(64);
        assertNotNull(mem);
        mem.byteValue(0, (byte) 0x55);
        Assertions.assertEquals((byte) 0x55, mem.byteValue(0));
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
    public void testBenchmarkBytes() {
        System.out.println("testAllocateBytes");
        ByteMemory mem = libraryLoader.allocateMemory(64);
        for (int i = 0; i < benchruns; i++) {
            if (i % 2 == 0) {
                mem.byteValue(16, value1);
                if (mem.byteValue(16) != value1) {
                    throw new RuntimeException();
                }
            } else {
                mem.byteValue(16, value2);
                if (mem.byteValue(16) != value2) {
                    throw new RuntimeException();
                }
            }
        }
    }

    @Test
    public void testBenchmarkBytesUnsafe() {
        System.out.println("testAllocateBytes");
//        Unsafe unsafe = Unsafe.getUnsafe();
        long address = unsafe.allocateMemory(64);
        for (int i = 0; i < benchruns; i++) {
            if (i % 2 == 0) {
                unsafe.putByte(address + 16, value1);
                if (unsafe.getByte(address + 16) != value1) {
                    throw new RuntimeException();
                }
            } else {
                unsafe.putByte(address + 16, value2);
                if (unsafe.getByte(address + 16) != value2) {
                    throw new RuntimeException();
                }
            }
        }
    }


}
