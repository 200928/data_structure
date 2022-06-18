package com.ming.ioc;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/4/18 - 下午10:38
 * @ Description: com.ming.ioc
 * @ Version: 1.0
 */
public interface ApplicationContext {
    Object getBean(String id);
}
