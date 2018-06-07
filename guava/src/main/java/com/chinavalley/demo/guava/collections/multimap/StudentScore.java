package com.chinavalley.demo.guava.collections.multimap;

import lombok.Data;

@Data
public class StudentScore {
    int CourseId;
    int score;

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseId) {
        CourseId = courseId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
