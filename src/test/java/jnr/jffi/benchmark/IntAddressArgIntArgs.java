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
public class IntAddressArgIntArgs extends IntAddress implements IntBenchmarkTests {

    public IntAddressArgIntArgs(int address) {
        super(address);
    }

     public static native void call_void0(int address);

    public static native int call_int0(int address);

    public static native int call_int__1int0(int address, int arg0);

    public static native int call_int__2int0(int address, int arg0, int arg1);

    public static native int call_int__3int0(int address, int arg0, int arg1, int arg2);

    public static native int call_int__4int0(int address, int arg0, int arg1, int arg2, int arg3);

    public static native int call_int__5int0(int address, int arg0, int arg1, int arg2, int arg3, int arg4);

    public static native int call_int__6int0(int address, int arg0, int arg1, int arg2, int arg3, int arg4, int arg5);

    @Override
    public void call_void() {
        call_void0(address);
    }

    @Override
    public int call_int() {
        return call_int0(address);
    }

    @Override
    public int call_int__1int(int arg0) {
        return call_int__1int0(address, arg0);
    }

    @Override
    public int call_int__2int(int arg0, int arg1) {
        return call_int__2int0(address, arg0, arg1);
    }

    @Override
    public int call_int__3int(int arg0, int arg1, int arg2) {
        return call_int__3int0(address, arg0, arg1, arg2);
    }

    @Override
    public int call_int__4int(int arg0, int arg1, int arg2, int arg3) {
        return call_int__4int0(address, arg0, arg1, arg2, arg3);
    }

    @Override
    public int call_int__5int(int arg0, int arg1, int arg2, int arg3, int arg4) {
        return call_int__5int0(address, arg0, arg1, arg2, arg3, arg4);
    }

    @Override
    public int call_int__6int(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
        return call_int__6int0(address, arg0, arg1, arg2, arg3, arg4, arg5);
    }

   
}
