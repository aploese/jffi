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

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aploese
 * @param <T>
 */
public abstract class Memory<T> extends OpaquePointer<T> implements jnr.jffi.memory.Memory<T> {

    protected final static Logger LOG = Logger.getLogger("jnr.jffi.spi");

    protected final long size;

    public Memory(long memAddress, long size) {
        super(memAddress);
        this.size = size;
    }

    @Override
    public long getSize() {
        return size;
    }

    protected final void checkOffset(long offset, int datasize) {
        if (offset + datasize >= size) {
            throw new IndexOutOfBoundsException(String.format("Offset (%d) + datasize (%d) to high for size (%d)", offset, datasize, size));
        } else if (offset < 0) {
            throw new IndexOutOfBoundsException(String.format("Offset (%d) must not be negative", offset));
        }
    }

    private final native void freeMemory();

    @Override
    protected void finalize() throws Throwable {
        LOG.log(Level.INFO, String.format("Finalize try free memory @0x%016x size: %d", pointerValue, size));
        try {
            freeMemory();
            LOG.log(Level.INFO, String.format("Finalize memory @0x%016x freed", pointerValue));
        } catch (Throwable t) {
            LOG.log(Level.SEVERE, String.format("Finalize: Memory Leak freeing memory @0x%016x size: %d failed", pointerValue, size), t);
        } finally {
            super.finalize();
        }
    }

    @Override
    public final long getMemoryAddress() {
        return pointerValue;
    }

}
