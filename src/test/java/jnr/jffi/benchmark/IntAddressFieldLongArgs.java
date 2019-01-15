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
public class IntAddressFieldLongArgs extends IntAddress implements LongBenchmarkTests {

    public IntAddressFieldLongArgs(int address) {
        super(address);
    }

    @Override
    public native void call_void();

    @Override
    public native long call_long();

    @Override
    public native long call_long__1long(long arg0);

    @Override
    public native long call_long__2long(long arg0, long arg1);

    @Override
    public native long call_long__3long(long arg0, long arg1, long arg2);

    @Override
    public native long call_long__4long(long arg0, long arg1, long arg2, long arg3);

    @Override
    public native long call_long__5long(long arg0, long arg1, long arg2, long arg3, long arg4);

    @Override
    public native long call_long__6long(long arg0, long arg1, long arg2, long arg3, long arg4, long arg5);
    
}
