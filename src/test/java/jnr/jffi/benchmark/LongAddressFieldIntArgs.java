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
package jnr.jffi.benchmark;

/**
 *
 * @author aploese
 */
public class LongAddressFieldIntArgs extends LongAddress implements IntBenchmarkTests {

    public LongAddressFieldIntArgs(long address) {
        super(address);
    }

    @Override
    public native void call_void();

    @Override
    public native int call_int();

    @Override
    public native int call_int__1int(int arg0);

    @Override
    public native int call_int__2int(int arg0, int arg1);

    @Override
    public native int call_int__3int(int arg0, int arg1, int arg2);

    @Override
    public native int call_int__4int(int arg0, int arg1, int arg2, int arg3);

    @Override
    public native int call_int__5int(int arg0, int arg1, int arg2, int arg3, int arg4);

    @Override
    public native int call_int__6int(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5);

}
