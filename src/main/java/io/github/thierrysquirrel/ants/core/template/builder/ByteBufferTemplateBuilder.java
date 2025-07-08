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
package io.github.thierrysquirrel.ants.core.template.builder;

import io.github.thierrysquirrel.ants.core.template.ByteBufferTemplate;
import io.github.thierrysquirrel.ants.core.template.constant.ByteBufferTemplateConstant;

import java.nio.ByteBuffer;

/**
 * Classname: ByteBufferTemplateBuilder
 * Description:
 * Date:2024/8/8
 *
 * @author ThierrySquirrel
 * @since JDK21
 **/
public class ByteBufferTemplateBuilder {
    private ByteBufferTemplateBuilder() {
    }

    public static ByteBufferTemplate builderSerializeByteBufferTemplate() {
        ByteBufferTemplate byteBufferTemplate = new ByteBufferTemplate();
        ByteBuffer byteBuff = ByteBuffer.allocate(ByteBufferTemplateConstant.INIT_SIZE);
        byteBufferTemplate.setByteBuffer(byteBuff);
        return byteBufferTemplate;
    }

    public static ByteBufferTemplate builderDeSerializeByteBufferTemplate(byte[] domainBytes) {
        ByteBufferTemplate byteBufferTemplate = new ByteBufferTemplate();
        ByteBuffer byteBuff = ByteBuffer.allocate(domainBytes.length);

        byteBufferTemplate.setByteBuffer(byteBuff);
        byteBufferTemplate.putBytes(domainBytes);
        byteBufferTemplate.flip();
        return byteBufferTemplate;
    }
}
