package com.ming.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/18 - 下午9:49
 * @ Description: com.ming.entity
 * @ Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private int age;
    private Teacher teacher;
}
