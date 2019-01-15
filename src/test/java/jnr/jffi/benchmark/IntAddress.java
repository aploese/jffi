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
package jnr.jffi.benchmark;

/**
 *
 * @author aploese
 */
public class IntAddress {

    static {
        try {
            if (!JffiJniTestsLibrary.isLibLoaded()) {
                JffiJniTestsLibrary.loadNativeLib();
            }
        } catch (UnsatisfiedLinkError e) {
            throw new RuntimeException("Please make sure the test jni lib is already loaded", e);
        }
    }

    final int address;

    public IntAddress(int address) {
        this.address = address;
    }

}
