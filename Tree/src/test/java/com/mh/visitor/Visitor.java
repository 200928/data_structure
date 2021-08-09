package com.mh.visitor;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/8/8 - 15:49
 * @ Description: com.mh.visitor
 * @ Version: 1.0
 */
public interface Visitor {

    void visit(Student element);

    void visit(Teacher element);

}
