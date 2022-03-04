package com.mh.visitor;

/**
 * @ Author: MingHui Fan
 * @ Date: 2021/8/8 - 15:47
 * @ Description: com.mh.visitor
 * @ Version: 1.0
 */
public interface Element {
    void accept(Visitor visitor);
}
