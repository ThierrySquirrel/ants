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
package com.github.thierrysquirrel.ants.core.deserialize.template;

import com.github.thierrysquirrel.ants.core.constant.AntsTypeConstant;
import com.github.thierrysquirrel.ants.core.deserialize.AbstractAntsDeSerialize;
import com.github.thierrysquirrel.ants.core.deserialize.template.constant.MapConstant;
import com.github.thierrysquirrel.ants.core.factory.ByteBooleanConvertFactory;
import com.github.thierrysquirrel.ants.utils.AntsUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Classname: AntsDeSerializeTemplate
 * Description:
 * Date: 2021/11/3 15:40
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class AntsDeSerializeTemplate extends AbstractAntsDeSerialize {
    public byte getOffset() {
        return getByteBufferTemplate ().getByte ();
    }

    public byte[] getBytes() {
        return getDataLengthAndDataBytes ();
    }

    public byte getByte() {
        return getByteBufferTemplate ().getByte ();
    }

    public short getShort() {
        return (short) getCommonInteger ();
    }

    public int getInteger() {
        return (int) getCommonInteger ();
    }

    public long getLong() {
        return getCommonInteger ();
    }

    public float getFloat() {
        long commonInteger = getCommonInteger ();
        return Float.intBitsToFloat ((int) commonInteger);
    }

    public double getDouble() {
        long commonInteger = getCommonInteger ();
        return Double.longBitsToDouble (commonInteger);
    }

    public boolean getBoolean() {
        byte data = getByte ();
        return ByteBooleanConvertFactory.byteConvertBoolean (data);
    }

    public char getChar() {
        return (char) getCommonInteger ();
    }

    public String getString() {
        byte[] dataBytes = getDataLengthAndDataBytes ();
        return new String (dataBytes);
    }

    public Object getEnum(Class<?> dataClass) throws ClassNotFoundException {
        byte offset = getByte ();
        if (dataClass == null) {
            dataClass = getObjectClass ();
        }
        Object[] enumConstants = dataClass.getEnumConstants ();
        return enumConstants[offset];
    }

    @SuppressWarnings("unchecked")
    public <T> T getDomain(Class<T> domainClazz) throws ClassNotFoundException {
        byte[] dataBytes = getDataLengthAndDataBytes ();
        if (domainClazz == null) {
            domainClazz = (Class<T>) getObjectClass ();
        }
        return AntsUtils.deSerialize (dataBytes, domainClazz);
    }

    public Object getObject() throws ClassNotFoundException {
        return baseGetObject (null);
    }

    public Object[] getArrays(byte offset, Class<?> listClass, Class<?> componentType) throws ClassNotFoundException {
        List<Object> list = getList (offset, listClass);
        Object[] newObjects = (Object[]) Array.newInstance (componentType, list.size ());
        return list.toArray (newObjects);
    }

    public List<Object> getList(byte offset, Class<?> listClass) throws ClassNotFoundException {
        List<Object> list = new ArrayList<> ();
        while (true) {
            Object data = baseGetObject (listClass);
            list.add (data);
            if (isStop (offset)) {
                return list;
            }
        }

    }

    public Map<Object, Object> getMap(byte offset, Class<?> keyClass, Class<?> valueClass) throws ClassNotFoundException {
        Map<Object, Object> map = new ConcurrentHashMap<> (MapConstant.MAP_INIT);
        while (true) {
            Object key = baseGetObject (keyClass);
            getOffset ();
            Object value = baseGetObject (valueClass);
            map.put (key, value);
            if (isStop (offset)) {
                return map;
            }
        }
    }


    private byte getType() {
        return getByteBufferTemplate ().getByte ();
    }

    private Class<?> getObjectClass() throws ClassNotFoundException {
        byte[] dataBytes = getDataLengthAndDataBytes ();
        String className = new String (dataBytes);
        return Class.forName (className);
    }

    private Object baseGetObject(Class<?> objectClass) throws ClassNotFoundException {
        byte type = getType ();
        switch (type) {
            case AntsTypeConstant.BYTE: {
                return getByte ();
            }
            case AntsTypeConstant.SHORT: {
                return getShort ();
            }
            case AntsTypeConstant.INTEGER: {
                return getInteger ();
            }
            case AntsTypeConstant.LONG: {
                return getLong ();
            }
            case AntsTypeConstant.FLOAT: {
                return getFloat ();
            }
            case AntsTypeConstant.DOUBLE: {
                return getDouble ();
            }
            case AntsTypeConstant.BOOLEAN: {
                return getBoolean ();
            }
            case AntsTypeConstant.CHARACTER: {
                return getChar ();
            }
            case AntsTypeConstant.STRING: {
                return getString ();
            }
            case AntsTypeConstant.ENUM: {
                return getEnum (objectClass);
            }
            default: {
                return getDomain (objectClass);
            }
        }
    }

    private boolean isStop(byte offset) {
        int length = getByteBufferTemplate ().getLength ();
        if (length <= 0) {
            return Boolean.TRUE;
        }
        getByteBufferTemplate ().make ();
        byte nextOffset = getByte ();
        if (offset != nextOffset) {
            getByteBufferTemplate ().reset ();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
