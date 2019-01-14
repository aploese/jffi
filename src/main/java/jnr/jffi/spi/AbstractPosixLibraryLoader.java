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

import jnr.jffi.posix.PosixType;

/**
 *
 * @author aploese
 */
public abstract class AbstractPosixLibraryLoader extends AbstractLibraryLoader<PosixType> {

    /**
     * Lazy function call binding.
     */
    public final native int RTLD_LAZY();

    /* Immediate function call binding.  */
    public final native int RTLD_NOW();

    /* Mask of binding time value.  */
    public final native int RTLD_BINDING_MASK();

    /* Do not load the object.  */
    public final native Integer RTLD_NOLOAD();

    /* Use deep binding.  */
    public final native Integer RTLD_DEEPBIND();

    /* If the following bit is set in the MODE argument to `dlopen',
   the symbols of the loaded object and its dependencies are made
   visible as if the object were linked directly into the program.  */
    public final native int RTLD_GLOBAL();

    /* Unix98 demands the following flag which is the inverse to RTLD_GLOBAL.
   The implementation does this by default and so we can define the
   value to zero.  */
    public final native int RTLD_LOCAL();

    /* Do not delete object when closed.  */
    public final native Integer RTLD_NODELETE();

    /**
     * AIX specific flag
     *
     * @return
     */
    public final native Integer RTLD_MEMBER();

    /**
     *
     * @param name
     * @return
     */
    public final native Short RTLD_NOAUTODEFER();

}
