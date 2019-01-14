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
 * <a href="https://en.wikipedia.org/wiki/Data_structure_alignment#Computing_padding"></a>
 * @author aploese
 */
public interface Structure {
    /*
    use gcc -fstack-protection-off ?? 
    
    -fstack-protector-strong -Wformat -fno-stack-protector 
            
    final int size;
    Given this, the rules for layout of a C struct are as follows.

    The initial offset is zero
    Given a current offset, O, and a field F whose alignment is A, the offset of F is O + P, where P is the padding needed to be added to make sure that F is aligned to A. P is defined as

    (O % A == 0)?0:(A - (O % A)).      

    After adding field F, the offset is then O = O + P + A.
    One more rule is needed to complete the description. It appears that the alignment of a nested structure is the alignment of the most stringent field in the nested structure. "Stringent" effectively means the largest alignment.
    The size of a struct is the offset after the last field is added rounded up to a multiple of the most stringent field alignment. 

More simply put, when adding a field, bump the offset until the offset is at the alignment required by the field.
    
    
    static ffi_status initialize_aggregate(ffi_type *arg, size_t *offsets)
{
  ffi_type **ptr;

  if (__builtin_expect((arg == 
# 41 "prep_cif.c" 3 4
     ((void *)0) 
# 41 "prep_cif.c"
     || arg->elements == 
# 41 "prep_cif.c" 3 4
     ((void *)0)
# 41 "prep_cif.c"
     )!=0,0))
    return FFI_BAD_TYPEDEF;

  arg->size = 0;
  arg->alignment = 0;

  ptr = &(arg->elements[0]);

  if (__builtin_expect((ptr == 0)!=0,0))
    return FFI_BAD_TYPEDEF;

  while ((*ptr) != 
# 52 "prep_cif.c" 3 4
                  ((void *)0)
# 52 "prep_cif.c"
                      )
    {
      if (__builtin_expect((((*ptr)->size == 0) && (initialize_aggregate((*ptr), 
# 54 "prep_cif.c" 3 4
         ((void *)0)
# 54 "prep_cif.c"
         ) != FFI_OK))!=0,0)
                                                        )
 return FFI_BAD_TYPEDEF;


      ;

      arg->size = (((((size_t) (arg->size))-1) | (((*ptr)->alignment)-1))+1);
      if (offsets)
 *offsets++ = arg->size;
      arg->size += (*ptr)->size;

      arg->alignment = (arg->alignment > (*ptr)->alignment) ?
 arg->alignment : (*ptr)->alignment;

      ptr++;
    }
# 79 "prep_cif.c"
  arg->size = (((((size_t) (arg->size))-1) | ((arg->alignment)-1))+1);
# 88 "prep_cif.c"
  if (arg->size == 0)
    return FFI_BAD_TYPEDEF;
  else
    return FFI_OK;
}
     */
}
