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
package io.github.thierrysquirrel.ants.core.serialize.template;

import io.github.thierrysquirrel.ants.core.serialize.AbstractAntsSerialize;

import java.util.List;
import java.util.Map;

/**
 * Classname: AntsSerializeTemplate
 * Description:
 * Date:2024/8/8
 *
 * @author ThierrySquirrel
 * @since JDK21
 **/
public class AntsSerializeTemplate extends AbstractAntsSerialize {

    public void putByte(Byte data) {
        basePutByte(data, Boolean.FALSE);
    }

    public void putShort(Short data) {
        basePutShort(data, Boolean.FALSE);
    }

    public void putInteger(Integer data) {
        basePutInteger(data, Boolean.FALSE);
    }

    public void putLong(Long data) {
        basePutLong(data, Boolean.FALSE);
    }

    public void putFloat(Float data) {
        basePutFloat(data, Boolean.FALSE);
    }

    public void putDouble(Double data) {
        basePutDouble(data, Boolean.FALSE);
    }

    public void putBoolean(Boolean data) {
        basePutBoolean(data, Boolean.FALSE);
    }

    public void putCharacter(Character data) {
        basePutCharacter(data, Boolean.FALSE);
    }

    public void putString(String data) {
        basePutString(data, Boolean.FALSE);
    }

    public void putEnum(Enum<?> data) {
        basePutEnum(data, Boolean.FALSE, Boolean.FALSE);
    }

    public void putDomain(Object data) {
        basePutDomain(data, Boolean.FALSE, Boolean.FALSE);
    }

    public void putObject(Object data) {
        basePutObject(data, Boolean.TRUE);
    }

    public void putArrays(Object data) {
        List<Object> list = List.of((Object[]) data);
        putList(list);
    }

    public void putList(List<Object> list) {
        for (Object data : list) {
            basePutObject(data, Boolean.FALSE);
        }
    }

    public void putMap(Map<Object, Object> map) {
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            basePutObject(entry.getKey(), Boolean.FALSE);
            basePutObject(entry.getValue(), Boolean.FALSE);
        }
    }
}
