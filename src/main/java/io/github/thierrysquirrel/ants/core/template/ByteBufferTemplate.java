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
package io.github.thierrysquirrel.ants.core.template;

import io.github.thierrysquirrel.ants.core.template.constant.ByteBufferTemplateConstant;
import io.github.thierrysquirrel.ants.core.template.factory.ByteBufferFactory;
import lombok.Data;

import java.nio.ByteBuffer;

/**
 * Classname: ByteBufferTemplate
 * Description:
 * Date:2024/8/8
 *
 * @author ThierrySquirrel
 * @since JDK21
 **/
@Data
public class ByteBufferTemplate {
    private ByteBuffer byteBuffer;
    private int makePosition = -1;

    public void make() {
        setMakePosition(byteBuffer.position());
    }

    public void reset() {
        byteBuffer.position(getMakePosition());
    }

    public void clearMake() {
        setMakePosition(-1);
    }

    public void flip() {
        byteBuffer.flip();
    }

    public int getLength() {
        return ByteBufferFactory.getLength(byteBuffer);
    }


    public void putBytes(byte[] value) {
        cyclicExpansion(value.length);
        byteBuffer.put(value);
    }

    public void putByte(byte value) {
        automaticExpansion();
        byteBuffer.put(value);
    }

    public void putShort(short value) {
        automaticExpansion();
        byteBuffer.putShort(value);
    }

    public void putInt(int value) {
        automaticExpansion();
        byteBuffer.putInt(value);
    }

    public void putLong(long value) {
        automaticExpansion();
        byteBuffer.putLong(value);
    }

    public void putFloat(float value) {
        automaticExpansion();
        byteBuffer.putFloat(value);
    }

    public void putDouble(double value) {
        automaticExpansion();
        byteBuffer.putDouble(value);
    }

    public void putChar(char value) {
        automaticExpansion();
        byteBuffer.putChar(value);
    }

    public byte[] getAllBytes() {
        byteBuffer.flip();
        return ByteBufferFactory.getAllBytes(byteBuffer);
    }

    public byte getByte() {
        return byteBuffer.get();
    }

    public void getBytes(byte[] value) {
        byteBuffer.get(value);
    }

    public short getShort() {
        return byteBuffer.getShort();
    }

    public int getInt() {
        return byteBuffer.getInt();
    }

    public long getLong() {
        return byteBuffer.getLong();
    }

    public float getFloat() {
        return byteBuffer.getFloat();
    }

    public double getDouble() {
        return byteBuffer.getDouble();
    }

    public char getChar() {
        return byteBuffer.getChar();
    }

    private void cyclicExpansion(int valueSize) {
        while (valueSize > getLength()) {
            byteBuffer.flip();
            expansion();
        }
    }

    private void automaticExpansion() {
        if (isExpansion()) {
            byteBuffer.flip();
            expansion();
        }
    }

    private boolean isExpansion() {
        int capacity = byteBuffer.capacity();
        double expansionThreshold = capacity * ByteBufferTemplateConstant.EXPANSION_THRESHOLD;
        int position = byteBuffer.position();
        if (position < expansionThreshold) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    private void expansion() {
        int capacity = byteBuffer.capacity();
        int newSize = capacity * ByteBufferTemplateConstant.EXPANSION_SIZE;
        reallocateCapacity(newSize);
    }

    private void reallocateCapacity(int capacity) {
        ByteBuffer newBytebuffer = ByteBuffer.allocateDirect(capacity);
        newBytebuffer.put(byteBuffer);
        byteBuffer = newBytebuffer;
    }
}
