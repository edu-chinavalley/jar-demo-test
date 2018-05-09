package com.chinavalley.demo.guava.collections.multimap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiMapTest {

    Map<String, List<StudentScore>> StudentScoreMap = new HashMap<String, List<StudentScore>>();
    public static void main(String ...args){


        //传统实现Map集合中带list
        MultiMapTest test = new MultiMapTest();
        for(int i=10;i<20;i++){
            StudentScore studentScore=new StudentScore();
            studentScore.setCourseId(1001+i);
            studentScore.setScore(100-i);
            test.addStudentScore("peida",studentScore);
        }

        System.out.println("StudentScoreMap:"+test.StudentScoreMap.size());
        System.out.println("StudentScoreMap:"+test.StudentScoreMap.containsKey("peida"));

        System.out.println("StudentScoreMap:"+test.StudentScoreMap.containsKey("jerry"));
        System.out.println("StudentScoreMap:"+test.StudentScoreMap.size());
        System.out.println("StudentScoreMap:"+test.StudentScoreMap.get("peida").size());

        List<StudentScore> StudentScoreList=test.StudentScoreMap.get("peida");
        if(StudentScoreList!=null&&StudentScoreList.size()>0){
            for(StudentScore stuScore:StudentScoreList){
                System.out.println("stuScore one:"+stuScore.CourseId+" score:"+stuScore.score);
            }
        }

        Multimap<String,StudentScore> scoreMultimap = ArrayListMultimap.create();
        for(int i=10;i<20;i++){
            StudentScore studentScore=new StudentScore();
            studentScore.CourseId=1001+i;
            studentScore.score=100-i;
            scoreMultimap.put("peida",studentScore);
        }
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.keys());
        System.out.println("scoreMultimap:"+scoreMultimap.get("peida"));
        List demo = new ArrayList();
        demo.add(scoreMultimap.values());
        System.out.println("scoreMultimap:"+demo);
        System.out.println("scoreMultimap:"+scoreMultimap.values());
        //输出
        for(StudentScore stuScore : scoreMultimap.values()) {
            System.out.println("stuScore one:"+stuScore.CourseId+" score:"+stuScore.score);
        }

        StudentScore studentScore1=new StudentScore();
        studentScore1.CourseId=1034;
        studentScore1.score=67;

        StudentScore studentScore2=new StudentScore();
        studentScore2.CourseId=1045;
        studentScore2.score=56;

        scoreMultimap.put("jerry",studentScore2);
        scoreMultimap.put("jerry",studentScore2);
        scoreMultimap.remove("jerry",studentScore2);
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.get("jerry"));

        scoreMultimap.put("harry",studentScore2);
        scoreMultimap.removeAll("harry");
        System.out.println("scoreMultimap:"+scoreMultimap.size());
        System.out.println("scoreMultimap:"+scoreMultimap.get("harry"));
    }

    public void addStudentScore(final String stuName,final StudentScore studentScore) {
        List<StudentScore> stuScore = StudentScoreMap.get(stuName);
        if (stuScore == null) {
            stuScore = new ArrayList<StudentScore>();
            StudentScoreMap.put(stuName, stuScore);
        }
        stuScore.add(studentScore);
    }


}
