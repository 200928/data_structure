package com.ming;

/*
 * @ Author: MingHui Fan
 * @ Date: 2022/6/09 - 下午11:35
 * @ Description: com.ming
 * @ Version: 1.0
 */

import com.ming.controller.MenuController;

public class App {

    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.userSystem();
    }
}
