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

/**
 * <a href="https://www.gnu.org/software/libtool/manual/html_node/Libtool-versioning.html" />
 *
 * @author aploese
 */
public class LibToolVersion {

    private final int current;
    private final Integer revision;
    private final Integer age;

    public LibToolVersion(int current) {
        this.current = current;
        revision = null;
        age = null;
    }

    public LibToolVersion(int current, int revision, int age) {
        this.current = current;
        this.revision = revision;
        this.age = age;
    }

    public String toString() {
        if (revision == null) {
            return String.valueOf(current);
        } else {
            return String.format("%d.%d.%d", current, revision, age);
        }
    }

}
