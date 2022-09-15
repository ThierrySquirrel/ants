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
package com.github.thierrysquirrel.ants.core.deserialize.factory;

import com.github.thierrysquirrel.ants.core.constant.BaseTypeNameConstant;
import com.github.thierrysquirrel.ants.core.deserialize.strategy.DeSerializeFieldStrategy;
import com.github.thierrysquirrel.ants.core.deserialize.template.AntsDeSerializeTemplate;

import java.lang.reflect.Field;

/**
 * Classname: DeSerializeFieldFactory
 * Description:
 * Date:2024/8/8
 *
 * @author ThierrySquirrel
 * @since JDK21
 **/
public class DeSerializeFieldFactory {
    private DeSerializeFieldFactory() {
    }

    public static void deSerializeField(AntsDeSerializeTemplate antsDeSerializeTemplate, byte offset, Object domain, Field field) throws ClassNotFoundException, IllegalAccessException {
        field.setAccessible(Boolean.TRUE);
        Class<?> fieldType = field.getType();
        if (fieldType.isEnum()) {
            Object data = antsDeSerializeTemplate.getEnum(fieldType);
            field.set(domain, data);
            return;
        }
        if (fieldType.isArray()) {
            String typeName = fieldType.getTypeName();
            if (typeName.equals(BaseTypeNameConstant.BYTE_ARRAY)) {
                byte[] data = antsDeSerializeTemplate.getBytes();
                field.set(domain, data);
                return;
            }
            Class<?> arrayClass = GenericTypeConvertClassFactory.getArrayClass(field.getGenericType().toString());
            Object[] data = antsDeSerializeTemplate.getArrays(offset, arrayClass, field.getType().getComponentType());
            field.set(domain, data);
            return;
        }
        DeSerializeFieldStrategy.deSerializeField(antsDeSerializeTemplate, offset, domain, field);
    }
}
