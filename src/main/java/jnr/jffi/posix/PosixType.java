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
package jnr.jffi.posix;

import jnr.jffi.types.NativeType;
import jnr.jffi.types.Type;

/**
 *
 * @author aploese
 */
public enum PosixType implements Type {

    _void_(NativeType.VOID),
    _prt_(NativeType.POINTER),
    _short_(NativeType.SHORT),
    _int_(NativeType.INT),
    _long_(NativeType.LONG),
    _long_long_(NativeType.LONGLONG);

    private final NativeType nativeType;

    private PosixType(NativeType nativeType) {
        this.nativeType = nativeType;
    }

    @Override
    public NativeType getNativeType() {
        return nativeType;
    }
}
