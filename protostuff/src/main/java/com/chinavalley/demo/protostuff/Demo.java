package com.chinavalley.demo.protostuff;

public class Demo {

    public static void main(String ...args){
        // 创建User对象
        User user = new User();
        user.setName("xpleaf");
        user.setAge(10);
        System.out.println("序列化前：" + user);
        // 使用UserSerializationUtil将user对象序列化
        byte[] userBytes = UserSerializationUtil.serialize(user);
        // 使用UserSerializationUtil反序列化字节数组为user对象
        User user2 = UserSerializationUtil.deserialize(userBytes);
        System.out.println("序列化后再反序列化：" + user2);
        // 判断值是否相等
        System.out.println(user.toString().equals(user2.toString()));
    }
}
