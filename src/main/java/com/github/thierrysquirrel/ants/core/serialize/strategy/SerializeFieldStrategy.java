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
package com.github.thierrysquirrel.ants.core.serialize.strategy;

import com.github.thierrysquirrel.ants.core.constant.BaseTypeNameConstant;
import com.github.thierrysquirrel.ants.core.serialize.template.AntsSerializeTemplate;

import java.util.List;
import java.util.Map;

/**
 * Classname: SerializeFieldStrategy
 * Description:
 * Date:2024/8/8
 *
 * @author ThierrySquirrel
 * @since JDK21
 **/
public class SerializeFieldStrategy {
    private SerializeFieldStrategy() {
    }

    @SuppressWarnings("unchecked")
    public static void serializeFieldStrategy(AntsSerializeTemplate antsSerializeTemplate, Object fieldData, String typeName) {
        switch (typeName) {
            case BaseTypeNameConstant.BYTE: {
                antsSerializeTemplate.putByte((Byte) fieldData);
                break;
            }
            case BaseTypeNameConstant.SHORT: {
                antsSerializeTemplate.putShort((Short) fieldData);
                break;
            }
            case BaseTypeNameConstant.INTEGER: {
                antsSerializeTemplate.putInteger((Integer) fieldData);
                break;
            }
            case BaseTypeNameConstant.LONG: {
                antsSerializeTemplate.putLong((Long) fieldData);
                break;
            }
            case BaseTypeNameConstant.FLOAT: {
                antsSerializeTemplate.putFloat((Float) fieldData);
                break;
            }
            case BaseTypeNameConstant.DOUBLE:
                antsSerializeTemplate.putDouble((Double) fieldData);
                break;
            case BaseTypeNameConstant.BOOLEAN: {
                antsSerializeTemplate.putBoolean((Boolean) fieldData);
                break;
            }
            case BaseTypeNameConstant.CHARACTER: {
                antsSerializeTemplate.putCharacter((Character) fieldData);
                break;
            }
            case BaseTypeNameConstant.STRING: {
                antsSerializeTemplate.putString((String) fieldData);
                break;
            }
            case BaseTypeNameConstant.OBJECT: {
                antsSerializeTemplate.putObject(fieldData);
                break;
            }
            case BaseTypeNameConstant.LIST: {
                antsSerializeTemplate.putList((List<Object>) fieldData);
                break;
            }
            case BaseTypeNameConstant.MAP: {
                antsSerializeTemplate.putMap((Map<Object, Object>) fieldData);
                break;
            }
            default: {
                antsSerializeTemplate.putDomain(fieldData);
                break;
            }
        }
    }
}
