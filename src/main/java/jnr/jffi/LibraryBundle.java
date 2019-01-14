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
package jnr.jffi;

import jnr.jffi.function.Function;
import jnr.jffi.types.Type;

/**
 *
 * TODO Do we need to handele varags special - Yes varars are aligned on the
 * long boundary. so chars wont be packt see c macros
 * <br>void va_start(va_list ap, last_arg);
 * <br>type va_arg(va_list ap, type)
 * <br>void va_end(va_list ap)
 * <br>for details.
 *
 * @author aploese
 */
public interface LibraryBundle<T extends Type> {

    <F extends Function> F getFunction(Class<F> clazz, String name, T returntype);

    <F extends Function> F getFunction(Class<F> clazz, String name, T returntype, T arg1);

    <F extends Function> F getFunction(Class<F> clazz, String name, T returntype, T arg1, T arg2);

    <F extends Function> F getFunction(Class<F> clazz, String name, T returntype, T arg1, T arg2, T arg3);

    <F extends Function> F getFunction(Class<F> clazz, String name, T returntype, T arg1, T arg2, T arg3, T arg4);

    <F extends Function> F getFunction(Class<F> clazz, String name, T returntype, T arg1, T arg2, T arg3, T arg4, T arg5);

    <F extends Function> F getFunction(Class<F> clazz, String name, T returntype, T... args);

}
