package com.chinavalley.demo.commonrng;

import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

public class RandomTest {

    public static void main(String ...args){
        UniformRandomProvider rng = RandomSource.create(RandomSource.MT);
        boolean isOn = rng.nextBoolean();
        int n = rng.nextInt(); // Integer.MIN_VALUE <= n <= Integer.MAX_VALUE。
        int m = rng.nextInt(); // 0 <= m <max。

        byte[] a =new byte[47];
        rng.nextBytes(a,15,3);

        UniformRandomProvider rng1 = RandomSource.create(RandomSource.SPLIT_MIX_64,5776);
        int seed = RandomSource.createInt();
        int [] seed1= RandomSource.createIntArray(128); //返回数组的长度是128。
    }
}
