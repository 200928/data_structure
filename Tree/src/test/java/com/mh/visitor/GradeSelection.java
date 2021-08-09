package com.mh.visitor;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/8/9 - 10:15
 * @ Description: com.mh.visitor
 * @ Version: 1.0
 */
public class GradeSelection implements Visitor {
    private String awardWords = "[%s]的分数是%d，荣获了成绩优秀奖。";

    @Override
    public void visit(Student element) {
        // 如果学生考试成绩超过90，则入围成绩优秀奖。
        if (element.getGrade() >= 90) {
            System.out.println(String.format(awardWords,
                    element.getName(), element.getGrade()));
        }
    }

    @Override
    public void visit(Teacher element) {
        // 如果老师反馈得分超过85，则入围成绩优秀奖。
        if (element.getScore() >= 85) {
            System.out.println(String.format(awardWords,
                    element.getName(), element.getScore()));
        }
    }
}
