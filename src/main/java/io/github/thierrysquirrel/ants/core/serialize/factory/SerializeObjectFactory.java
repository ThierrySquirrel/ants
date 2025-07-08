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
package io.github.thierrysquirrel.ants.core.serialize.factory;

import io.github.thierrysquirrel.ants.core.serialize.template.AntsSerializeTemplate;
import io.github.thierrysquirrel.ants.core.serialize.template.builder.AntsSerializeTemplateBuilder;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * Classname: SerializeObjectFactory
 * Description:
 * Date:2024/8/8
 *
 * @author ThierrySquirrel
 * @since JDK21
 **/
@Slf4j
public class SerializeObjectFactory {
    private SerializeObjectFactory() {
    }

    public static byte[] serializeObject(Object domain) {
        Class<?> domainClass = domain.getClass();
        Field[] declaredFields = domainClass.getDeclaredFields();
        AntsSerializeTemplate antsSerializeTemplate = AntsSerializeTemplateBuilder.builderAntsSerializeTemplate();
        for (Field declaredField : declaredFields) {
            try {
                SerializeFieldFactory.serializeField(antsSerializeTemplate, domain, declaredField);
            } catch (IllegalAccessException e) {
                log.error("serializeObject Error", e);
            }
        }
        return antsSerializeTemplate.getByteBufferTemplate().getAllBytes();
    }
}
