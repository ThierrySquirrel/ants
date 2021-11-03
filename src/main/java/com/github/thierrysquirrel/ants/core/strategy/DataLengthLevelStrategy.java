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
package com.github.thierrysquirrel.ants.core.strategy;

import com.github.thierrysquirrel.ants.core.strategy.constant.ByteLevelConstant;
import com.github.thierrysquirrel.ants.core.strategy.constant.DataLengthLevelConstant;

/**
 * Classname: DataLengthLevelStrategy
 * Description:
 * Date: 2021/11/3 13:58
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class DataLengthLevelStrategy {
    private DataLengthLevelStrategy() {
    }
    public static byte getDataLengthLevel(int dataLength) {
        if (dataLength <= ByteLevelConstant.POSITIVE_BYTE_LEVEL_ONE) {
            return (byte) dataLength;
        } else if (dataLength <= ByteLevelConstant.POSITIVE_BYTE_LEVEL_TWO) {
            return DataLengthLevelConstant.DATA_LENGTH_LEVEL_ONE;
        } else if (dataLength <= ByteLevelConstant.POSITIVE_BYTE_LEVEL_THREE) {
            return DataLengthLevelConstant.DATA_LENGTH_LEVEL_TWO;
        }
        return DataLengthLevelConstant.DATA_LENGTH_LEVEL_THREE;
    }

    public static int getDataByteSize(Long data) {

        if (data <= ByteLevelConstant.POSITIVE_BYTE_LEVEL_ONE && data >= ByteLevelConstant.NEGATIVE_BYTE_LEVEL_ONE) {
            return ByteLevelConstant.BYTE_SIZE_ONE;
        }
        if (data <= ByteLevelConstant.POSITIVE_BYTE_LEVEL_TWO && data >= ByteLevelConstant.NEGATIVE_BYTE_LEVEL_TWO) {
            return ByteLevelConstant.BYTE_SIZE_TWO;
        }
        if (data <= ByteLevelConstant.POSITIVE_BYTE_LEVEL_THREE && data >= ByteLevelConstant.NEGATIVE_BYTE_LEVEL_THREE) {
            return ByteLevelConstant.BYTE_SIZE_THREE;
        }
        if (data <= ByteLevelConstant.POSITIVE_BYTE_LEVEL_FOUR && data >= ByteLevelConstant.NEGATIVE_BYTE_LEVEL_FOUR) {
            return ByteLevelConstant.BYTE_SIZE_FOUR;
        }
        if (data <= ByteLevelConstant.POSITIVE_BYTE_LEVEL_FIVE && data >= ByteLevelConstant.NEGATIVE_BYTE_LEVEL_FIVE) {
            return ByteLevelConstant.BYTE_SIZE_FIVE;
        }
        if (data <= ByteLevelConstant.POSITIVE_BYTE_LEVEL_SIX && data >= ByteLevelConstant.NEGATIVE_BYTE_LEVEL_SIX) {
            return ByteLevelConstant.BYTE_SIZE_SIX;
        }
        if (data <= ByteLevelConstant.POSITIVE_BYTE_LEVEL_SEVEN && data >= ByteLevelConstant.NEGATIVE_BYTE_LEVEL_SEVEN) {
            return ByteLevelConstant.BYTE_SIZE_SEVEN;
        }
        return ByteLevelConstant.BYTE_SIZE_EIGHT;
    }

    public static boolean isReverse(long dataLong) {
        if (dataLong == ByteLevelConstant.NEGATIVE_BYTE_LEVEL_ONE) {
            return Boolean.FALSE;
        }
        if (dataLong == ByteLevelConstant.NEGATIVE_BYTE_LEVEL_TWO) {
            return Boolean.FALSE;
        }
        if (dataLong == ByteLevelConstant.NEGATIVE_BYTE_LEVEL_THREE) {
            return Boolean.FALSE;
        }
        if (dataLong == ByteLevelConstant.NEGATIVE_BYTE_LEVEL_FOUR) {
            return Boolean.FALSE;
        }
        if (dataLong == ByteLevelConstant.NEGATIVE_BYTE_LEVEL_FIVE) {
            return Boolean.FALSE;
        }
        if (dataLong == ByteLevelConstant.NEGATIVE_BYTE_LEVEL_SIX) {
            return Boolean.FALSE;
        }
        if (dataLong == ByteLevelConstant.NEGATIVE_BYTE_LEVEL_SEVEN) {
            return Boolean.FALSE;
        }
        if (dataLong == ByteLevelConstant.NEGATIVE_BYTE_LEVEL_EIGHT) {
            return Boolean.FALSE;
        }
        if (dataLong > 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
