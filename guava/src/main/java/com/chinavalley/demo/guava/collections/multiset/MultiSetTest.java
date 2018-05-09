package com.chinavalley.demo.guava.collections.multiset;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Multiset的特性：允许重复，但是不保证顺序。以及进行各种集合操作
public class MultiSetTest {

    public static void main(String... args) {


        //传统用来实现出现次数
        String strWorld = "wer|dffd|ddsa|dfd|dreg|de|dr|ce|ghrt|cf|gt|ser|tg|ghrt|cf|gt|" +
                "ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr|wer|dffd|ddsa|dfd|dreg|de|dr|" +
                "ce|ghrt|cf|gt|ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr";
        String[] words = strWorld.split("\\|");
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        for (String word : words) {
            Integer count = countMap.get(word);
            if (count == null) {
                countMap.put(word, 1);
            } else {
                countMap.put(word, count + 1);
            }
        }
        System.out.println("countMap：");
        for (String key : countMap.keySet()) {
            System.out.println(key + " count：" + countMap.get(key));
        }

        //用Multiset来实现
        String[] words1 = strWorld.split("\\|");
        List<String> wordList = new ArrayList<String>();
        for (String word : words1) {
            wordList.add(word);
        }

        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);

        for (String key : wordsMultiset.elementSet()) {
            System.out.println(key + "  Multiset count：" + wordsMultiset.count(key));

        }



        //添加个数
        wordsMultiset.add("wer",30);
        System.out.println(wordsMultiset);
        //删除个数
        wordsMultiset.remove("wer",3);
        System.out.println(wordsMultiset);
        //必须准确估计到元素的个数才能生效
        wordsMultiset.setCount("wer", 29,45);
        System.out.println(wordsMultiset);

        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }


    }
}
