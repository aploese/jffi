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
package jnr.jffi.spi.function;

import jnr.jffi.function.JavaCall_I__I_CharSequence_I;

/**
 *
 * @author aploese
 */
public class NativeCall_I__I_P_I__Impl implements JavaCall_I__I_CharSequence_I {

    @Override
    public native int call_i__i_CharSequence_i(int arg0, CharSequence arg1, int arg2);

}
