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
import jnr.jffi.LibToolVersion;
import jnr.jffi.LibraryLoader;
import jnr.jffi.types.Type;

/**
 *
 * @author aploese
 */
public abstract class AbstractLibraryLoader<T extends Type> implements LibraryLoader<T> {

    protected final static Logger LOG = Logger.getLogger("jnr.jffi.spi");

    private volatile static boolean libLoaded;
    private final static Object loadLock = new Object();

    public AbstractLibraryLoader() {
        if (!libLoaded) {
            loadNativeLib();
        }
    }

    public static boolean isLibLoaded() {
        return libLoaded;
    }

    //libLoaded will be set in the native code.
    private static boolean loadNativeLib() {
        synchronized (loadLock) {
            if (libLoaded) {
                LOG.log(Level.FINE, "Lib was Loaded");
                return false;
            }
            System.loadLibrary("jffi");
        }
        return libLoaded;
    }

    @Override
    public String mapLibraryName(String libName, LibToolVersion version) {
        if (version == null) {
            return System.mapLibraryName(libName);
        } else {
            return System.mapLibraryName(libName) + '.' + version;
        }
    }

}
