/**
 * Copyright 2024/8/8 ThierrySquirrel
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
 **/
package com.github.thierrysquirrel.ants.core.deserialize;

import com.github.thierrysquirrel.ants.core.factory.BitOperationFactory;
import com.github.thierrysquirrel.ants.core.factory.ByteBooleanConvertFactory;
import com.github.thierrysquirrel.ants.core.strategy.constant.DataLengthLevelConstant;
import com.github.thierrysquirrel.ants.core.template.ByteBufferTemplate;
import lombok.Data;

/**
 * Classname: AbstractAntsDeSerialize
 * Description:
 * Date:2024/8/8
 *
 * @author ThierrySquirrel
 * @since JDK21
 **/
@Data
public abstract class AbstractAntsDeSerialize {
    private ByteBufferTemplate byteBufferTemplate;


    protected byte[] getDataLengthAndDataBytes() {
        int dataLength = getDataLength();
        return getDataBytes(dataLength);
    }

    protected long getCommonInteger() {
        byte[] dataBytes = getDataLengthAndDataBytes();
        long dataLong = BitOperationFactory.commonDeSerializeInteger(dataBytes);
        boolean isReverse = getIsReverse();
        if (isReverse) {
            dataLong = -dataLong;
        }
        return dataLong;
    }

    private int getDataLength() {
        byte dataLengthByte = byteBufferTemplate.getByte();
        if (dataLengthByte > 0) {
            return dataLengthByte;
        } else if (dataLengthByte == DataLengthLevelConstant.DATA_LENGTH_LEVEL_ONE) {
            return byteBufferTemplate.getShort();
        } else if (dataLengthByte == DataLengthLevelConstant.DATA_LENGTH_LEVEL_TWO) {
            byte[] dataLengthBytes = new byte[DataLengthLevelConstant.DATA_LENGTH_LEVEL_TWO_ARRAY_SIZE];
            byteBufferTemplate.getBytes(dataLengthBytes);
            return (int) BitOperationFactory.commonDeSerializeInteger(dataLengthBytes);
        }
        return byteBufferTemplate.getInt();
    }

    private byte[] getDataBytes(int dataLength) {
        byte[] dataBytes = new byte[dataLength];
        byteBufferTemplate.getBytes(dataBytes);
        return dataBytes;
    }

    private boolean getIsReverse() {
        byte data = byteBufferTemplate.getByte();
        return ByteBooleanConvertFactory.byteConvertBoolean(data);
    }

}
