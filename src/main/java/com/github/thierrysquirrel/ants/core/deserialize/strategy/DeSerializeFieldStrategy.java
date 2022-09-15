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
package com.github.thierrysquirrel.ants.core.deserialize.strategy;

import com.github.thierrysquirrel.ants.core.constant.BaseTypeNameConstant;
import com.github.thierrysquirrel.ants.core.deserialize.factory.GenericTypeConvertClassFactory;
import com.github.thierrysquirrel.ants.core.deserialize.template.AntsDeSerializeTemplate;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * Classname: DeSerializeFieldStrategy
 * Description:
 * Date:2024/8/8
 *
 * @author ThierrySquirrel
 * @since JDK21
 **/
public class DeSerializeFieldStrategy {
    private DeSerializeFieldStrategy() {
    }

    public static void deSerializeField(AntsDeSerializeTemplate antsDeSerializeTemplate, byte offset, Object domain, Field field) throws IllegalAccessException, ClassNotFoundException {
        String typeName = field.getType().getTypeName();
        switch (typeName) {
            case BaseTypeNameConstant.BYTE: {
                byte data = antsDeSerializeTemplate.getByte();
                field.set(domain, data);
                break;
            }
            case BaseTypeNameConstant.SHORT: {
                short data = antsDeSerializeTemplate.getShort();
                field.set(domain, data);
                break;
            }
            case BaseTypeNameConstant.INTEGER: {
                int data = antsDeSerializeTemplate.getInteger();
                field.set(domain, data);
                break;
            }
            case BaseTypeNameConstant.LONG: {
                long data = antsDeSerializeTemplate.getLong();
                field.set(domain, data);
                break;
            }
            case BaseTypeNameConstant.FLOAT: {
                float data = antsDeSerializeTemplate.getFloat();
                field.set(domain, data);
                break;
            }
            case BaseTypeNameConstant.DOUBLE: {
                double data = antsDeSerializeTemplate.getDouble();
                field.set(domain, data);
                break;
            }
            case BaseTypeNameConstant.BOOLEAN: {
                boolean data = antsDeSerializeTemplate.getBoolean();
                field.set(domain, data);
                break;
            }
            case BaseTypeNameConstant.CHARACTER: {
                char data = antsDeSerializeTemplate.getChar();
                field.set(domain, data);
                break;
            }
            case BaseTypeNameConstant.STRING: {
                String data = antsDeSerializeTemplate.getString();
                field.set(domain, data);
                break;
            }
            case BaseTypeNameConstant.OBJECT: {
                Object data = antsDeSerializeTemplate.getObject();
                field.set(domain, data);
                break;
            }
            case BaseTypeNameConstant.LIST: {
                Class<?> listClass = GenericTypeConvertClassFactory.getListClass(field.getGenericType().toString());
                List<Object> data = antsDeSerializeTemplate.getList(offset, listClass);
                field.set(domain, data);
                break;
            }
            case BaseTypeNameConstant.MAP: {
                String genericType = field.getGenericType().toString();
                Class<?> mapKeyClass = GenericTypeConvertClassFactory.getMapKeyClass(genericType);
                Class<?> mapValueClass = GenericTypeConvertClassFactory.getMapValueClass(genericType);
                Map<Object, Object> data = antsDeSerializeTemplate.getMap(offset, mapKeyClass, mapValueClass);
                field.set(domain, data);
                break;
            }
            default: {
                Object data = antsDeSerializeTemplate.getDomain(field.getType());
                field.set(domain, data);
                break;
            }
        }
    }
}
