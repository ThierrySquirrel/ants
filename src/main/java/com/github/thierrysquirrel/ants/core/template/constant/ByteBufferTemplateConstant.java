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
package com.github.thierrysquirrel.ants.core.template.constant;

/**
 * Classname: ByteBufferTemplateConstant
 * Description:
 * Date: 2021/11/3 13:37
 *
 * @author ThierrySquirrel
 * @since JDK 11
 */
public final class ByteBufferTemplateConstant {
    private ByteBufferTemplateConstant() {
    }

    public static final int INIT_SIZE = 1024;
    public static final double EXPANSION_THRESHOLD = 0.8;
    public static final int EXPANSION_SIZE = 2;
}
