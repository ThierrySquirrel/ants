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
package com.github.thierrysquirrel.ants.core.serialize;

import com.github.thierrysquirrel.ants.core.constant.AntsTypeConstant;
import com.github.thierrysquirrel.ants.core.constant.BaseTypeNameConstant;
import com.github.thierrysquirrel.ants.core.factory.BitOperationFactory;
import com.github.thierrysquirrel.ants.core.factory.ByteBooleanConvertFactory;
import com.github.thierrysquirrel.ants.core.strategy.DataLengthLevelStrategy;
import com.github.thierrysquirrel.ants.core.template.ByteBufferTemplate;
import com.github.thierrysquirrel.ants.utils.AntsUtils;
import lombok.Data;

/**
 * Classname: AbstractAntsSerialize
 * Description:
 * Date: 2021/11/3 13:40
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
@Data
public abstract class AbstractAntsSerialize {
    private int offset = -1;
    private ByteBufferTemplate byteBufferTemplate;

    public void incrementOffset() {
        offset++;
    }

    public void putBytes(byte[] data) {
        putOffset ();
        putDataLengthAndData (data);
    }

    protected void basePutByte(Byte data, boolean isPutType) {
        putOffset ();
        if (isPutType) {
            byteBufferTemplate.putByte (AntsTypeConstant.BYTE);
        }
        putData (data);
    }

    protected void basePutShort(Short data, boolean isPutType) {
        if (isPutType) {
            basePutCommonInteger (data, AntsTypeConstant.SHORT);
        } else {
            basePutCommonInteger (data, null);
        }
    }

    protected void basePutInteger(Integer data, boolean isPutType) {
        if (isPutType) {
            basePutCommonInteger (data, AntsTypeConstant.INTEGER);
        } else {
            basePutCommonInteger (data, null);
        }
    }

    protected void basePutLong(Long data, boolean isPutType) {
        if (isPutType) {
            basePutCommonInteger (data, AntsTypeConstant.LONG);
        } else {
            basePutCommonInteger (data, null);
        }
    }

    protected void basePutFloat(Float data, boolean isPutType) {
        if (isPutType) {
            basePutCommonInteger (Float.floatToRawIntBits (data), AntsTypeConstant.FLOAT);
        } else {
            basePutCommonInteger (Float.floatToRawIntBits (data), null);

        }
    }

    protected void basePutDouble(Double data, boolean isPutType) {
        if (isPutType) {
            basePutCommonInteger (Double.doubleToRawLongBits (data), AntsTypeConstant.DOUBLE);
        } else {
            basePutCommonInteger (Double.doubleToRawLongBits (data), null);
        }
    }

    protected void basePutBoolean(Boolean data, boolean isPutType) {
        putOffset ();
        byte booleanByte = ByteBooleanConvertFactory.booleanConvertByte (data);
        if (isPutType) {
            byteBufferTemplate.putByte (AntsTypeConstant.BOOLEAN);
        }
        byteBufferTemplate.putByte (booleanByte);
    }

    protected void basePutCharacter(Character data, boolean isPutType) {
        if (isPutType) {
            basePutCommonInteger ((int) data, AntsTypeConstant.CHARACTER);
        } else {
            basePutCommonInteger ((int) data, null);
        }
    }

    protected void basePutString(String data, boolean isPutType) {
        putOffset ();
        if (isPutType) {
            byteBufferTemplate.putByte (AntsTypeConstant.STRING);
        }
        byte[] dataBytes = data.getBytes ();
        putDataLengthAndData (dataBytes);
    }

    protected void basePutEnum(Enum<?> data, boolean isPutType, boolean isPutClass) {
        putOffset ();
        if (isPutType) {
            byteBufferTemplate.putByte (AntsTypeConstant.ENUM);
        }
        byte enumByte = (byte) data.ordinal ();

        byteBufferTemplate.putByte (enumByte);

        if (isPutClass) {
            putClass (data);
        }
    }

    protected void basePutDomain(Object data, boolean isPutType, boolean isPutClass) {
        putOffset ();
        if (isPutType) {
            byteBufferTemplate.putByte (AntsTypeConstant.DOMAIN);
        }
        byte[] serialize = AntsUtils.serialize (data);
        putDataLengthAndData (serialize);

        if (isPutClass) {
            putClass (data);
        }
    }

    protected void basePutObject(Object data, boolean isPutClass) {
        Class<?> dataClass = data.getClass ();
        if (dataClass.isEnum ()) {
            basePutEnum ((Enum<?>) data, Boolean.TRUE, isPutClass);
            return;
        }
        String typeName = dataClass.getTypeName ();
        switch (typeName) {
            case BaseTypeNameConstant.BYTE: {
                basePutByte ((Byte) data, Boolean.TRUE);
                break;
            }
            case BaseTypeNameConstant.SHORT: {
                basePutShort ((Short) data, Boolean.TRUE);
                break;
            }
            case BaseTypeNameConstant.INTEGER: {
                basePutInteger ((Integer) data, Boolean.TRUE);
                break;
            }
            case BaseTypeNameConstant.LONG: {
                basePutLong ((Long) data, Boolean.TRUE);
                break;
            }
            case BaseTypeNameConstant.FLOAT: {
                basePutFloat ((Float) data, Boolean.TRUE);
                break;
            }
            case BaseTypeNameConstant.DOUBLE: {
                basePutDouble ((Double) data, Boolean.TRUE);
                break;
            }
            case BaseTypeNameConstant.BOOLEAN: {
                basePutBoolean ((Boolean) data, Boolean.TRUE);
                break;
            }
            case BaseTypeNameConstant.CHARACTER: {
                basePutCharacter ((Character) data, Boolean.TRUE);
                break;
            }
            case BaseTypeNameConstant.STRING: {
                basePutString ((String) data, Boolean.TRUE);
                break;
            }
            default: {
                basePutDomain (data, Boolean.TRUE, isPutClass);
            }
        }
    }


    private void putOffset() {
        byteBufferTemplate.putByte ((byte) offset);
    }

    private void putData(byte data) {
        byteBufferTemplate.putByte (data);
    }

    private void putDataLength(int dataLength) {
        byte length = DataLengthLevelStrategy.getDataLengthLevel (dataLength);
        byteBufferTemplate.putByte (length);
        if (length < 0) {
            byte[] data = BitOperationFactory.commonSerializeInteger (dataLength);
            putData (data);
        }
    }


    private void putData(byte[] data) {
        byteBufferTemplate.putBytes (data);
    }

    private void putDataLengthAndData(byte[] data) {
        putDataLength (data.length);
        putData (data);
    }


    private void putIsReverse(Object data) {
        long dataLong = Long.parseLong (data.toString ());
        boolean isReverse = DataLengthLevelStrategy.isReverse (dataLong);
        if (isReverse) {
            byteBufferTemplate.putByte ((byte) 1);
        } else {
            byteBufferTemplate.putByte ((byte) 0);
        }
    }

    private void putClass(Object data) {
        byte[] bytes = data.getClass ().getTypeName ().getBytes ();
        putDataLengthAndData (bytes);
    }

    private void basePutCommonInteger(Object data, Byte type) {
        putOffset ();
        if (type != null) {
            byteBufferTemplate.putByte (type);
        }
        byte[] dataBytes = BitOperationFactory.commonSerializeInteger (data);
        putDataLengthAndData (dataBytes);
        putIsReverse (data);
    }
}
