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

import com.github.thierrysquirrel.ants.core.deserialize.factory.constant.GenericTypeConvertClassFactoryConstant;

/**
 * Classname: GenericTypeConvertClassFactory
 * Description:
 * Date:2024/8/8
 *
 * @author ThierrySquirrel
 * @since JDK21
 **/
public class GenericTypeConvertClassFactory {
    private GenericTypeConvertClassFactory() {
    }

    public static Class<?> getArrayClass(String arrayGenericType) throws ClassNotFoundException {
        int beginIndex = arrayGenericType.indexOf(GenericTypeConvertClassFactoryConstant.ARRAY_MARK);
        String className = arrayGenericType.substring(beginIndex + 1, arrayGenericType.length() - 1);
        return Class.forName(className);
    }

    public static Class<?> getListClass(String arrayGenericType) throws ClassNotFoundException {
        int beginIndex = arrayGenericType.indexOf(GenericTypeConvertClassFactoryConstant.LIST_MARK);
        String className = arrayGenericType.substring(beginIndex + 1, arrayGenericType.length() - 1);
        return Class.forName(className);
    }

    public static Class<?> getMapKeyClass(String arrayGenericType) throws ClassNotFoundException {
        int beginIndex = arrayGenericType.indexOf(GenericTypeConvertClassFactoryConstant.MAP_KEY_MARK_ONE);
        int endIndex = arrayGenericType.indexOf(GenericTypeConvertClassFactoryConstant.MAP_KEY_MARK_TWO);
        String className = arrayGenericType.substring(beginIndex + 1, endIndex);
        return Class.forName(className);
    }

    public static Class<?> getMapValueClass(String arrayGenericType) throws ClassNotFoundException {
        int beginIndex = arrayGenericType.indexOf(GenericTypeConvertClassFactoryConstant.MAP_VALUE_MARK);
        String className = arrayGenericType.substring(beginIndex + 1, arrayGenericType.length() - 1);
        return Class.forName(className);
    }
}
