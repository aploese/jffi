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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author aploese
 */
public class CallIntVariantsBenchmarkTest {

    final static int ROUNDS = 1000000;

    final static IntAddressArgIntArgs INT_ADDRESS_ARG_INT_ARGS = new IntAddressArgIntArgs(ROUNDS);
    final static IntAddressFieldIntArgs INT_ADDRESS_FIELD_INT_ARGS = new IntAddressFieldIntArgs(ROUNDS);
    final static LongAddressArgIntArgs LONG_ADDRESS_ARG_INT_ARGS = new LongAddressArgIntArgs(ROUNDS);
    final static LongAddressFieldIntArgs LONG_ADDRESS_FIELD_INT_ARGS = new LongAddressFieldIntArgs(ROUNDS);

    public static Stream<Arguments> getImpl() {
        return Stream.of(
                Arguments.of(INT_ADDRESS_ARG_INT_ARGS, ROUNDS),
                Arguments.of(INT_ADDRESS_FIELD_INT_ARGS),
                Arguments.of(LONG_ADDRESS_ARG_INT_ARGS),
                Arguments.of(LONG_ADDRESS_FIELD_INT_ARGS));
    }

    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource("getImpl")
    public void testCall_void(final IntBenchmarkTests impl) throws Exception {
        for (int i = 0; i < ROUNDS; i++) {
               impl.call_void();
        }
    }

    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource("getImpl")
    public void testCall_int(final IntBenchmarkTests impl) throws Exception {
        for (int i = 0; i < ROUNDS; i++) {
               impl.call_int();
        }
    }
    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource("getImpl")
    public void testCall_int__1int(final IntBenchmarkTests impl) throws Exception {
        for (int i = 0; i < ROUNDS; i++) {
               impl.call_int__1int(i);
        }
    }
    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource("getImpl")
    public void testCall_int__2int(final IntBenchmarkTests impl) throws Exception {
        for (int i = 0; i < ROUNDS; i++) {
               impl.call_int__2int(i, i);
        }
    }
    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource("getImpl")
    public void testCall_int__3int(final IntBenchmarkTests impl) throws Exception {
        for (int i = 0; i < ROUNDS; i++) {
               impl.call_int__3int(i, i, i);
        }
    }
    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource("getImpl")
    public void testCall_int__4int(final IntBenchmarkTests impl) throws Exception {
        for (int i = 0; i < ROUNDS; i++) {
               impl.call_int__4int(i, i, i, i);
        }
    }
    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource("getImpl")
    public void testCall_int__5int(final IntBenchmarkTests impl) throws Exception {
        for (int i = 0; i < ROUNDS; i++) {
               impl.call_int__5int(i, i, i, i, i);
        }
    }
    
    @BenchmarkTest
    @ParameterizedTest(name = "{0}")
    @MethodSource("getImpl")
    public void testCall_int__6int(final IntBenchmarkTests impl) throws Exception {
        for (int i = 0; i < ROUNDS; i++) {
               impl.call_int__6int(i, i, i, i, i, i);
        }
    }
    

}
