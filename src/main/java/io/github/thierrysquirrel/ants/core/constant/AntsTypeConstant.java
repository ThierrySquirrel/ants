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
package io.github.thierrysquirrel.ants.core.constant;

/**
 * Classname: AntsTypeConstant
 * Description:
 * Date:2024/8/8
 *
 * @author ThierrySquirrel
 * @since JDK21
 **/
public final class AntsTypeConstant {
    public static final byte BYTE = 0;
    public static final byte SHORT = 1;
    public static final byte INTEGER = 2;
    public static final byte LONG = 3;
    public static final byte FLOAT = 4;
    public static final byte DOUBLE = 5;
    public static final byte BOOLEAN = 6;
    public static final byte CHARACTER = 7;

    public static final byte STRING = 8;
    public static final byte ENUM = 9;
    public static final byte DOMAIN = 10;

    private AntsTypeConstant() {
    }
}
