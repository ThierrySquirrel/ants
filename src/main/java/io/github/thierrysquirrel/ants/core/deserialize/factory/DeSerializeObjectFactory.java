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
package io.github.thierrysquirrel.ants.core.deserialize.factory;

import io.github.thierrysquirrel.ants.core.deserialize.template.AntsDeSerializeTemplate;
import io.github.thierrysquirrel.ants.core.deserialize.template.builder.AntsDeSerializeTemplateBuilder;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * Classname: DeSerializeObjectFactory
 * Description:
 * Date:2024/8/8
 *
 * @author ThierrySquirrel
 * @since JDK21
 **/
@Slf4j
public class DeSerializeObjectFactory {
    private DeSerializeObjectFactory() {
    }

    public static <T> T deSerializeObject(byte[] domainBytes, Class<T> domainClass) {
        T domain = null;
        try {
            domain = domainClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error("newInstance", e);
        }

        Field[] declaredFields = domainClass.getDeclaredFields();
        AntsDeSerializeTemplate antsDeSerializeTemplate = AntsDeSerializeTemplateBuilder.builderAntsDeSerializeTemplate(domainBytes);
        while (true) {
            int length = antsDeSerializeTemplate.getByteBufferTemplate().getLength();
            if (length == 0) {
                break;
            }
            byte offset = antsDeSerializeTemplate.getOffset();
            Field field = declaredFields[offset];
            try {
                DeSerializeFieldFactory.deSerializeField(antsDeSerializeTemplate, offset, domain, field);
            } catch (Exception e) {
                log.error("deSerializeObject", e);
            }
        }

        return domain;
    }
}
