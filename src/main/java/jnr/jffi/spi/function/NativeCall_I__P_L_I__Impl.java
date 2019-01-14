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

import jnr.jffi.function.JavaCall_I__StructArray_L_I;
import jnr.jffi.memory.Memory;
import jnr.jffi.memory.StructArray;

/**
 *
 * @author aploese
 */
public class NativeCall_I__P_L_I__Impl extends AbstractFunction<NativeCall_I__P_L_I__Impl> implements JavaCall_I__StructArray_L_I {

    public NativeCall_I__P_L_I__Impl(long functionHandle) {
        super(functionHandle);
    }

    
    public native int call_i__p_l_i(long arg0, long arg1, int arg2);

    @Override
    public int call_i__StructArray_l_i(StructArray arg0, long arg1, int arg2) {
        return call_i__p_l_i(((Memory)arg0).getMemoryAddress(), arg1, arg2);
    }

}
