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
public class NativeCall_I__I__Test {

    public NativeCall_I__I__Test() {
    }

    private static JffiTestsInterface jffiTests;

    @BeforeAll
    public static void setUpClass() {
        jffiTests = new JffiTestsImpl();
    }

    @AfterAll
    public static void tearDownClass() {
        jffiTests = null;
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void jnr_jffi_test_NativeCall_SI__SI_negate() {
        int value = 0x05050055;
        int result = jffiTests.jnr_jffi_test_NativeCall_SI__SI_negate(value);
        assertEquals(~value, result);
    }

    @Test()
    public void jnr_jffi_test_NativeCall_UI__UI_negate() {
        int value = 0x05050055;
        int result = jffiTests.jnr_jffi_test_NativeCall_UI__UI_negate(value);
        assertEquals(~value, result);
    }

    @Test
    public void jnr_jffi_test_NativeCall_SI__SI_read_write_error() {
        int result;
        jffiTests.jnr_jffi_test_NativeCall_SI__SI_read_write_error(1);
        result = jffiTests.jnr_jffi_test_NativeCall_SI__SI_read_write_error(2);
        assertEquals(1, result);
        result = jffiTests.jnr_jffi_test_NativeCall_SI__SI_read_write_error(0);
        assertEquals(2, result);
        result = jffiTests.jnr_jffi_test_NativeCall_SI__SI_read_write_error(0);
        assertEquals(0, result);
    }


}
