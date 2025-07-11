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
package io.github.thierrysquirrel.ants.core.template.constant;

/**
 * Classname: ByteBufferTemplateConstant
 * Description:
 * Date:2024/8/8
 *
 * @author ThierrySquirrel
 * @since JDK21
 **/
public final class ByteBufferTemplateConstant {
    private ByteBufferTemplateConstant() {
    }

    public static final int INIT_SIZE = 1024;
    public static final double EXPANSION_THRESHOLD = 0.8;
    public static final int EXPANSION_SIZE = 2;
}
