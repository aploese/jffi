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

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import jnr.jffi.LibraryBundle;
import jnr.jffi.function.Function;
import jnr.jffi.posix.PosixType;
import jnr.jffi.spi.function.NativeCall_I__I__Impl;
import jnr.jffi.function.JavaCall_I__I;

/**
 *
 * @author aploese
 */
public class PosixLibraryLoaderImpl extends AbstractPosixLibraryLoader {

    @Override
    public ByteMemory allocateMemory(long size) {
        long address = malloc(size);
        if (address == 0) {
            LOG.log(Level.SEVERE, "Could not get native memory of size: " + size);
            throw new OutOfMemoryError("Could not get native memory of size: " + size);
        }
        return new jnr.jffi.spi.ByteMemory(address, size);
    }

    public class LibraryBundleImpl implements LibraryBundle<PosixType> {

        private class Lib {

            private final long handle;
            private final String name;

            private Lib(long handle, String name) {
                this.handle = handle;
                this.name = name;
            }
        }

        private List<Lib> libs = new LinkedList<>();

        private String getLibNames() {
            StringBuilder sb = new StringBuilder();
            boolean first = true;
            for (Lib lib : libs) {
                if (first) {
                    first = false;
                } else {
                    sb.append(", ");
                }
                sb.append(lib.name);
            }
            return sb.toString();
        }

        private long dlsym(String name) {
            for (Lib lib : libs) {
                long result = PosixLibraryLoaderImpl.this.dlsym(lib.handle, name);
                if (result != 0) {
                    return result;
                }
            }
            throw new UnsatisfiedLinkError("Can't find in " + getLibNames());
        }

        private LibraryBundleImpl(String name) {
            final long handle = dlopen(name, RTLD_LAZY() | RTLD_LOCAL());
            try {
                libs.add(new Lib(handle, name));
            } catch (Throwable t) {
                LOG.log(Level.SEVERE, "In intit", t);
                dlclose(handle);
                throw t;
            }
        }

        @Override
        protected void finalize() throws Throwable {
            LOG.log(Level.INFO, "Finalize");
            try {
                for (Lib lib : libs) {
                    try {
                        int result = dlclose(lib.handle);
                    } catch (Throwable t) {
                        LOG.log(Level.SEVERE, "Can't dlclose lib " + lib.name + " ", t);
                    }
                }
            } finally {
                super.finalize();
            }
        }

        @Override
        public <T extends Function> T getFunction(Class<T> clazz, String name, PosixType returntype) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <T extends Function> T getFunction(Class<T> clazz, String name, PosixType returntype, PosixType arg1) {
            if (clazz.isAssignableFrom(JavaCall_I__I.class)) {
                return (T) new NativeCall_I__I__Impl(dlsym(name));
            }
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <T extends Function> T getFunction(Class<T> clazz, String name, PosixType returntype, PosixType arg1, PosixType arg2) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <T extends Function> T getFunction(Class<T> clazz, String name, PosixType returntype, PosixType arg1, PosixType arg2, PosixType arg3) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <T extends Function> T getFunction(Class<T> clazz, String name, PosixType returntype, PosixType arg1, PosixType arg2, PosixType arg3, PosixType arg4) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <T extends Function> T getFunction(Class<T> clazz, String name, PosixType returntype, PosixType arg1, PosixType arg2, PosixType arg3, PosixType arg4, PosixType arg5) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public <T extends Function> T getFunction(Class<T> clazz, String name, PosixType returntype, PosixType... args) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public long getSymbolAddress64(String name) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    public native long dlopen(String filename, int flags);

    public native long dlsym(long handle, String name);

    public native int dlclose(long handle);

    public native long malloc(long size);

    @Override
    public LibraryBundle loadLibrary(String name) {
        return new LibraryBundleImpl(name);
    }

    @Override
    public LibraryBundle loadLibrary(String first, String second) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
