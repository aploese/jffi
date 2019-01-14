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
package jnr.jffi.spi;

/**
 *
 * @author aploese
 */
public final class ByteMemory extends Memory<Byte> implements jnr.jffi.memory.ByteMemory {

    ByteMemory(long address, long size) {
        super(address, size);
    }

    @Override
    public final Byte getValue() {
        return byteValue(0);
    }

    private native byte getByteValue0(long offset);

    private native void setByteValue0(long offset, byte value);

    @Override
    public final byte byteValue(long offset) {
        checkOffset(offset, 1);
        return getByteValue0(pointerValue + offset);
    }

    @Override
    public void byteValue(int offset, byte value) {
        checkOffset(offset, 1);
        setByteValue0(pointerValue + offset, value);
    }

}
