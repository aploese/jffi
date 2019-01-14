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
import jnr.jffi.spi.AbstractPosixLibraryLoader;
import jnr.jffi.spi.PosixLibraryLoaderImpl;

/**
 *
 * @author aploese
 */
public class JffiTestsImpl implements JffiTestsInterface {
    
    private final AbstractPosixLibraryLoader posixLibraryLoader;
    private final LibraryBundle<PosixType> jffiTests;
    private final JavaCall_I__I jnr_jffi_test_NativeCall_SI__SI_negate;
    private final JavaCall_I__I jnr_jffi_test_NativeCall_UI__UI_negate;
    private final JavaCall_I__I jnr_jffi_test_NativeCall_SI__SI_read_write_error;

    public JffiTestsImpl() {
        posixLibraryLoader = new PosixLibraryLoaderImpl();
        String libname = posixLibraryLoader.mapLibraryName("jffitests", null);
        jffiTests = posixLibraryLoader.loadLibrary(libname);
        jnr_jffi_test_NativeCall_SI__SI_negate = jffiTests.getFunction(JavaCall_I__I.class, "jnr_jffi_test_NativeCall_SI__SI_negate", PosixType._int_, PosixType._int_);
        jnr_jffi_test_NativeCall_UI__UI_negate = jffiTests.getFunction(JavaCall_I__I.class, "jnr_jffi_test_NativeCall_UI__UI_negate", PosixType._int_, PosixType._int_);
        jnr_jffi_test_NativeCall_SI__SI_read_write_error = jffiTests.getFunction(JavaCall_I__I.class, "jnr_jffi_test_NativeCall_SI__SI_read_write_error", PosixType._int_, PosixType._int_);
    }
    
    

    @Override
    public int jnr_jffi_test_NativeCall_SI__SI_negate(int arg0) {
        return jnr_jffi_test_NativeCall_SI__SI_negate.call_i__i(arg0);
    }

    @Override
    public int jnr_jffi_test_NativeCall_UI__UI_negate(int arg0) {
        return jnr_jffi_test_NativeCall_UI__UI_negate.call_i__i(arg0);
    }

    @Override
    public int jnr_jffi_test_NativeCall_SI__SI_read_write_error(int error) {
        return jnr_jffi_test_NativeCall_SI__SI_read_write_error.call_i__i(error);
    }
    
}
