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

import jnr.jffi.function.JavaCall_I__I;
import jnr.jffi.posix.PosixType;
import jnr.jffi.spi.PosixLibraryLoaderImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author aploese
 */
public class PosixLibraryLoaderTest {

    public PosixLibraryLoaderTest() {
    }

    private static LibraryLoader libraryLoader;

    @BeforeAll
    public static void setUpClass() {
        libraryLoader = new PosixLibraryLoaderImpl();
    }

    @AfterAll
    public static void tearDownClass() {
        libraryLoader = null;
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of loadLibrary method, of class LibraryLoader.
     */
    @Test
    public void testLoadLibrary_String() {
        //TODO how to test this???        assertEquals(4, ((PosixLibraryLoaderImpl)libraryLoader).RTLD_NOLOAD().intValue());
        System.out.println("loadLibrary");
        String name = libraryLoader.mapLibraryName("c", new LibToolVersion(6));
        LibraryBundle result = libraryLoader.loadLibrary(name);
        assertNotNull(result);
    }

    @Test()
    public void testLoadLibrary_String_Non_Existant() {
        System.out.println("loadLibrary Error");
        String name = "Jnr_Test_Non_Existant_Lib_Name";
        assertThrows(UnsatisfiedLinkError.class, () -> {
            LibraryBundle result = libraryLoader.loadLibrary(name);
        });
    }

    @Test
    public void testGetLibC_Close() {
        System.out.println("GetLibC_Close");
        String name = libraryLoader.mapLibraryName("c", new LibToolVersion(6));
        LibraryBundle<PosixType> result = libraryLoader.loadLibrary(name);
        JavaCall_I__I close = result.getFunction(JavaCall_I__I.class, "close", PosixType._int_, PosixType._int_);
        //close.call_i__i(0);
        assertNotNull(result);
    }

}
