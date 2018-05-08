package com.chinavalley.demo.guava.base.preconditions;

import com.google.common.base.Preconditions;

public class PreconditionsTest {

    public static void main(String ...args){

        //判断条件是否满足 不满足报IllegalArgumentException
        Preconditions.checkArgument(19 < 20, "%s 不小于 %s", 21,290);
        Preconditions.checkArgument(true);

        //判断参数是否为null
        Preconditions.checkNotNull("sssssssssssss");
        //NullPointerException
        Preconditions.checkNotNull("asd");
        Preconditions.checkNotNull("zxc", "参数不能为 null");

        //检查状态 false的话报异常
        Preconditions.checkState(true);
        Preconditions.checkState(true, "状态错了");

        //检查index作为索引值对某个列表、字符串或数组是否有效。index>=0 && index<size *
        String[] temp = new String[3];
        Preconditions.checkElementIndex(2,temp.length,"数组越界");

        //范围判断
        Preconditions.checkPositionIndexes(50,40,80);
    }
}
