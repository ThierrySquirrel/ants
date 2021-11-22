# ants

序列化工具

[English](./README.md)

支持功能:
- [x] Domain对象序列化

# Domain对象序列化:
使用更加节省空间的算法序列化Domain对象.  
支持数据类型(包装的8种基本数据类型)Byte,Short,Integer,Long,Float,Double,Boolean,Character.  
String,Enum,Domain.  
Object(支持封装的8种基本数据类型,String,Enum,Domain),  
byte[].  
(Arrays,List,Map):(8种基本数据类型+String,Enum,Domain.如果使用Object,则只支持8种基本数据类型+String).

## Quick Start

```xml
<!--在pom.xml中添加依赖-->
        <dependency>
            <groupId>com.github.thierrysquirrel</groupId>
            <artifactId>ants</artifactId>
            <version>1.0.0.1-RELEASE</version>
        </dependency>
```

# Domain对象序列化
```java
@Data
public class User {
    private Byte aByte;
    private Short aShort;
    private Integer aInteger;
    private Long aLong;
    private Float aFloat;
    private Double aDouble;
    private Boolean aBoolean;
    private Character character;
    
    public static void main(String[] args) {
        User user = getUser ();
        byte[] serialize = AntsUtils.serialize (user);
        User user1 = AntsUtils.deSerialize (serialize, User.class);
        System.out.println (user);
        System.out.println (user1);
        System.out.println (user==user1);
    }
    public static User getUser(){
        User user=new User ();
        user.setAByte ((byte) 1);
        user.setAShort ((short) 2);
        user.setAInteger (3);
        user.setALong (4L);
        user.setAFloat (5.5F);
        user.setADouble (6.6);
        user.setABoolean (Boolean.TRUE);
        user.setCharacter ('A');
        return user;
    }
}
```
