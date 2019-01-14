/*
 * Copyright 2018 aploese.
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
package jnr.jffi.spi.function;

import jnr.jffi.function.Function;
import jnr.jffi.spi.OpaquePointer;

/**
 *
 * @author aploese
 * @param <T>
 */
public abstract class AbstractFunction<T extends AbstractFunction> extends OpaquePointer<T> implements Function {

    public AbstractFunction(long functionHandle) {
        super(functionHandle);
    }

    /**
     *
     * @return
     */
    @Override
    public T getValue() {
        return (T) this;
    }

}
