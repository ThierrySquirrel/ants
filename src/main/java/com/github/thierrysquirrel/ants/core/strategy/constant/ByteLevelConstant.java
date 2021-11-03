/**
 * Copyright 2021 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.thierrysquirrel.ants.core.strategy.constant;

/**
 * Classname: ByteLevelConstant
 * Description:
 * Date: 2021/11/3 14:03
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public final class ByteLevelConstant {
    public static final byte POSITIVE_BYTE_LEVEL_ONE = 127;
    public static final short POSITIVE_BYTE_LEVEL_TWO = 32767;
    public static final int POSITIVE_BYTE_LEVEL_THREE = 8388607;
    public static final int POSITIVE_BYTE_LEVEL_FOUR = 2147483647;
    public static final long POSITIVE_BYTE_LEVEL_FIVE = 549755813887L;
    public static final long POSITIVE_BYTE_LEVEL_SIX = 140737488355327L;
    public static final long POSITIVE_BYTE_LEVEL_SEVEN = 36028797018963967L;
    public static final long POSITIVE_BYTE_LEVEL_EIGHT = 9223372036854775807L;

    public static final byte NEGATIVE_BYTE_LEVEL_ONE = -128;
    public static final short NEGATIVE_BYTE_LEVEL_TWO = -32768;
    public static final int NEGATIVE_BYTE_LEVEL_THREE = -8388608;
    public static final int NEGATIVE_BYTE_LEVEL_FOUR = -2147483648;
    public static final long NEGATIVE_BYTE_LEVEL_FIVE = -549755813888L;
    public static final long NEGATIVE_BYTE_LEVEL_SIX = -140737488355328L;
    public static final long NEGATIVE_BYTE_LEVEL_SEVEN = -36028797018963968L;
    public static final long NEGATIVE_BYTE_LEVEL_EIGHT = -9223372036854775808L;

    public static final int BYTE_SIZE_ONE = 1;
    public static final int BYTE_SIZE_TWO = 2;
    public static final int BYTE_SIZE_THREE = 3;
    public static final int BYTE_SIZE_FOUR = 4;
    public static final int BYTE_SIZE_FIVE = 5;
    public static final int BYTE_SIZE_SIX = 6;
    public static final int BYTE_SIZE_SEVEN = 7;
    public static final int BYTE_SIZE_EIGHT = 8;

    private ByteLevelConstant() {
    }
}
