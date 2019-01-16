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

import java.util.stream.Stream;
import jnr.jffi.tags.BenchmarkTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author aploese
 */
public class CallLongVariantsBenchmarkTest {
    
    final static int ROUNDS = 10000000;

    final static IntAddressArgLongArgs INT_ADDRESS_ARG_LONG_ARGS = new IntAddressArgLongArgs(ROUNDS);
    final static IntAddressFieldLongArgs INT_ADDRESS_FIELD_LONG_ARGS = new IntAddressFieldLongArgs(ROUNDS);
    final static LongAddressArgLongArgs LONG_ADDRESS_ARG_LONG_ARGS = new LongAddressArgLongArgs(ROUNDS);
    final static LongAddressFieldLongArgs LONG_ADDRESS_FIELD_LONG_ARGS = new LongAddressFieldLongArgs(ROUNDS);

    public static Stream<Arguments> getImpl() {
        return Stream.of(
                Arguments.of(INT_ADDRESS_ARG_LONG_ARGS, ROUNDS),
                Arguments.of(INT_ADDRESS_FIELD_LONG_ARGS),
                Arguments.of(LONG_ADDRESS_ARG_LONG_ARGS),
                Arguments.of(LONG_ADDRESS_FIELD_LONG_ARGS));
    }

    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource({ "getImpl" })
    public void testCall_void(final LongBenchmarkTests impl) {
        for (int i = 0; i < ROUNDS; i++) {
            impl.call_void();
        }
    }
    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource({ "getImpl" })
    public void testCall_long(final LongBenchmarkTests impl) {
        for (int i = 0; i < ROUNDS; i++) {
            impl.call_long();
        }
    }
    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource({ "getImpl" })
    public void testCall_long__1long(final LongBenchmarkTests impl) {
        for (int i = 0; i < ROUNDS; i++) {
            impl.call_long__1long(i);
        }
    }
    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource({ "getImpl" })
    public void testCall_long__2long(final LongBenchmarkTests impl) {
        for (int i = 0; i < ROUNDS; i++) {
            impl.call_long__2long(i, i);
        }
    }
    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource({ "getImpl" })
    public void testCall_long__3long(final LongBenchmarkTests impl) {
        for (int i = 0; i < ROUNDS; i++) {
            impl.call_long__3long(i, i, i);
        }
    }
    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource({ "getImpl" })
    public void testCall_long__4long(final LongBenchmarkTests impl) {
        for (int i = 0; i < ROUNDS; i++) {
            impl.call_long__4long(i, i, i, i);
        }
    }
    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource({ "getImpl" })
    public void testCall_long__5long(final LongBenchmarkTests impl) {
        for (int i = 0; i < ROUNDS; i++) {
            impl.call_long__5long(i, i, i, i, i);
        }
    }
    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource({ "getImpl" })
    public void testCall_long__6long(final LongBenchmarkTests impl) {
        for (int i = 0; i < ROUNDS; i++) {
            impl.call_long__6long(i, i, i, i, i, i);
        }
    }
    
    
}