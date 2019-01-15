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
public class IntAddressArgLongArgs extends IntAddress implements LongBenchmarkTests {

    public static native void call_void0(int address);

    public static native long call_long0(int address);

    public static native long call_long__1long0(int address, long arg0);

    public static native long call_long__2long0(int address, long arg0, long arg1);

    public static native long call_long__3long0(int address, long arg0, long arg1, long arg2);

    public static native long call_long__4long0(int address, long arg0, long arg1, long arg2, long arg3);

    public static native long call_long__5long0(int address, long arg0, long arg1, long arg2, long arg3, long arg4);

    public static native long call_long__6long0(int address, long arg0, long arg1, long arg2, long arg3, long arg4, long arg5);

    public IntAddressArgLongArgs(int address) {
        super(address);
    }

    @Override
    public void call_void() {
        call_void0(address);
    }

    @Override
    public long call_long() {
        return call_long0(address);
    }

    @Override
    public long call_long__1long(long arg0) {
        return call_long__1long0(address, arg0);
    }

    @Override
    public long call_long__2long(long arg0, long arg1) {
        return call_long__2long0(address, arg0, arg1);
    }

    @Override
    public long call_long__3long(long arg0, long arg1, long arg2) {
        return call_long__3long0(address, arg0, arg1, arg2);
    }

    @Override
    public long call_long__4long(long arg0, long arg1, long arg2, long arg3) {
        return call_long__4long0(address, arg0, arg1, arg2, arg3);
    }

    @Override
    public long call_long__5long(long arg0, long arg1, long arg2, long arg3, long arg4) {
        return call_long__5long0(address, arg0, arg1, arg2, arg3, arg4);
    }

    @Override
    public long call_long__6long(long arg0, long arg1, long arg2, long arg3, long arg4, long arg5) {
        return call_long__6long0(address, arg0, arg1, arg2, arg3, arg4, arg5);
    }

}
