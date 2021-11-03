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
package com.github.thierrysquirrel.ants.core.serialize.factory;

import com.github.thierrysquirrel.ants.core.constant.BaseTypeNameConstant;
import com.github.thierrysquirrel.ants.core.serialize.strategy.SerializeFieldStrategy;
import com.github.thierrysquirrel.ants.core.serialize.template.AntsSerializeTemplate;

import java.lang.reflect.Field;

/**
 * Classname: SerializeFieldFactory
 * Description:
 * Date: 2021/11/3 15:18
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public class SerializeFieldFactory {
    private SerializeFieldFactory() {
    }

    public static void serializeField(AntsSerializeTemplate antsSerializeTemplate, Object domain, Field field) throws IllegalAccessException {
        antsSerializeTemplate.incrementOffset ();
        field.setAccessible (Boolean.TRUE);
        Object fieldData = field.get (domain);
        if (fieldData == null) {
            return;
        }
        Class<?> fieldType = field.getType ();
        if (fieldType.isEnum ()) {
            antsSerializeTemplate.putEnum ((Enum<?>) fieldData);
            return;
        }
        if (fieldType.isArray ()) {
            String typeName = fieldType.getTypeName ();
            if (typeName.equals (BaseTypeNameConstant.BYTE_ARRAY)) {
                antsSerializeTemplate.putBytes ((byte[]) fieldData);
                return;
            }
            antsSerializeTemplate.putArrays (fieldData);
            return;
        }
        SerializeFieldStrategy.serializeFieldStrategy (antsSerializeTemplate, fieldData, fieldType.getTypeName ());
    }
}
