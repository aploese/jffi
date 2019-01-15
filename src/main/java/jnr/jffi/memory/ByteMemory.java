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
package jnr.jffi.memory;

/**
 *
 * @author aploese
 */
public interface ByteMemory extends Memory<Byte> {

    /**
     * Get the byte value at the memory address.
     *
     * @param offset the offset
     * @return the value at offset
     *
     */
    byte byteValue(long offset);

    /**
     * Set the byte value at the memory address.
     *
     * @param offset the offset
     * @param value the new value
     */
    void byteValue(int offset, byte value);

    byte getByte();

    void setByte(byte value);

}
