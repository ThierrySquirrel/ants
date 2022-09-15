# ants

Serialization tool

[中文](./README_zh_CN.md)

Support Function:
- [x] Domain object serialization

# Domain object serialization:
Serialize domain objects using a more space efficient algorithm .  
Support data types (8 basic data types of packaging)Byte,Short,Integer,Long,Float,Double,Boolean,Character,  
String,Enum,Domain.  
Object(8 basic data types of packaging,String,Enum,Domain),  
byte[].  
((Arrays,List,Map):'(8 basic data types of packaging+String,Enum,Domain.If Object is used, only 8 basic data types are supported +String)').

## Quick Start

```xml
<!--Adding dependencies to pom. XML-->
        <dependency>
            <groupId>com.github.thierrysquirrel</groupId>
            <artifactId>ants</artifactId>
            <version>1.0.0.5-RELEASE</version>
        </dependency>
```

# Domain object serialization
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

![Russian flag](https://user-images.githubusercontent.com/49895274/190374600-65baa531-61b0-47e8-8862-1038cb1b45bb.png)

