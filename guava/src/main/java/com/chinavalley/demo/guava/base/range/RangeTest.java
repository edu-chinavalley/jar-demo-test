package com.chinavalley.demo.guava.base.range;

import com.google.common.collect.BoundType;
import com.google.common.collect.Range;

import static com.google.common.collect.BoundType.CLOSED;
import static com.google.common.collect.BoundType.OPEN;

public class RangeTest {

    public static void main(String ...args){

        //懒得解释
        System.out.println("open:"+Range.open(1, 10));
        System.out.println("closed:"+ Range.closed(1, 10));
        System.out.println("closedOpen:"+ Range.closedOpen(1, 10));
        System.out.println("openClosed:"+ Range.openClosed(1, 10));
        System.out.println("greaterThan:"+ Range.greaterThan(10));
        System.out.println("atLeast:"+ Range.atLeast(10));
        System.out.println("lessThan:"+ Range.lessThan(10));
        System.out.println("atMost:"+ Range.atMost(10));
        System.out.println("all:"+ Range.all());
        System.out.println("closed:"+Range.closed(10, 10));
        System.out.println("closedOpen:"+Range.closedOpen(10, 10));

        //两者相同
        System.out.println(Range.downTo(4, BoundType.OPEN));
        System.out.println(Range.range(1, CLOSED, 4, OPEN));


        System.out.println(Range.closed(1, 3).contains(2));
        System.out.println(Range.closed(1, 3).contains(4));
        System.out.println(Range.lessThan(5).contains(5));


        //判断区间是否有特定边界，或是无限的
        Range.closedOpen(4, 4).hasLowerBound();
        Range.closedOpen(4, 4).hasUpperBound();

        //返回区间边界类型，CLOSED或OPEN；如果区间没有对应的边界，抛出IllegalStateException；
        Range.closed(1, 3).lowerBoundType();
        Range.closed(1, 3).upperBoundType();

        //返回区间的端点值；如果区间没有对应的边界，抛出IllegalStateException；
        Range.closed(3, 10).lowerEndpoint();
        Range.open(3, 10).lowerEndpoint();
        //判断是否为空区间
        Range.closedOpen(4, 4).isEmpty();

        //相同的range是否有包含关系
        Range.closedOpen(1, 4).encloses(Range.open(2, 3));

        //判断区间是否是相连的
        Range.closed(3, 5).isConnected(Range.open(5, 10)); // returns true
        Range.closed(0, 9).isConnected(Range.closed(3, 4)); // returns true
        Range.closed(0, 5).isConnected(Range.closed(3, 9)); // returns true
        Range.open(3, 5).isConnected(Range.open(5, 10)); // returns false
        Range.closed(1, 5).isConnected(Range.closed(6, 10)); // returns false

        //返回两个区间的交集
        Range.closed(3, 5).intersection(Range.open(5, 10)); // returns (5, 5]
        Range.closed(0, 9).intersection(Range.closed(3, 4)); // returns [3, 4]
        Range.closed(0, 5).intersection(Range.closed(3, 9)); // returns [3, 5]
        Range.open(3, 5).intersection(Range.open(5, 10)); // throws IAE
        Range.closed(1, 5).intersection(Range.closed(6, 10)); // throws IAE

        //返回”同时包括两个区间的最小区间”，如果两个区间相连，那就是它们的并集。
        Range.closed(3, 5).span(Range.open(5, 10)); // returns [3, 10)
        Range.closed(0, 9).span(Range.closed(3, 4)); // returns [0, 9]
        Range.closed(0, 5).span(Range.closed(3, 9)); // returns [0, 9]
        Range.open(3, 5).span(Range.open(5, 10)); // returns (3, 10)
        Range.closed(1, 5).span(Range.closed(6, 10)); // returns [1, 10]

        // TODO: 2018/5/8 离散域 

    }
}
