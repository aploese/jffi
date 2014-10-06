/*
 * Copyright (C) 2014 Timur Duehr
 *
 * This file is part of jffi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 * Alternatively, you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this work.  If not, see <http://www.gnu.org/licenses/>.
 */

#ifndef JFFI_RTLD_H

#include "jffi.h"
#include <dlfcn.h>

/* if these aren't defined (eg. windows), we need sensible defaults */
#ifndef RTLD_LAZY
#define RTLD_LAZY 1
#endif

#ifndef RTLD_LAZY
#define RTLD_NOW 2
#endif

#ifndef RTLD_LOCAL
#define RTLD_LOCAL 4
#endif

#ifndef RTLD_GLOBAL
#define RTLD_GLOBAL 8
#endif

/* If these aren't defined, they're not supported so define as 0 */
#ifndef RTLD_NOLOAD
#define RTLD_NOLOAD 0
#endif

#ifndef RTLD_NODELETE
#define RTLD_NODELETE 0
#endif

#ifndef RTLD_FIRST
#define RTLD_FIRST 0
#endif

#ifndef RTLD_DEEPBIND
#define RTLD_DEEPBIND 0
#endif

#ifndef RTLD_MEMBER
#define RTLD_MEMBER 0
#endif

/* convenience */
#ifndef RTLD_BINDING_MASK
#define RTLD_BINDING_MASK (RTLD_LAZY | RTLD_NOW)
#endif

#ifndef RTLD_LOCATION_MASK
#define RTLD_LOCATION_MASK (RTLD_LOCAL | RTLD_GLOBAL)
#endif

#ifndef RTLD_ALL_MASK
#define RTLD_ALL_MASK (RTLD_BINDING_MASK | RTLD_LOCATION_MASK | RTLD_NOLOAD | RTLD_NODELETE | RTLD_FIRST | RTLD_DEEPBIND | RTLD_MEMBER)
#endif


#endif /* JFFI_RTLD_H */
