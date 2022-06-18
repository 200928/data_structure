package com.ming.enums;

/**
 * @ Author: MingHui Fan
 * @ Date: 2022/6/8 - 上午9:41
 * @ Description: com.mh.enums
 * @ Version: 1.0
 */
public enum MenuEnum {

    ERROR(0,"输入错误"),
    ORDER(1, "我要订餐"),
    VIEW_ORDER(2, "查看餐袋"),
    SIGN_THE_ORDER(3, "签收订单"),
    DELETE_ORDER(4, "删除订单"),
    LIKE(5, "我要点赞"),
    EXIT(6, "退出系统");

    private final int code;
    private final String menuName;

    MenuEnum(int code, String menuName) {
        this.code = code;
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getCode() {
        return code;
    }

    public static MenuEnum getCodeType(int e) {
        for (MenuEnum item : MenuEnum.values()) {
            if (item.getCode() == e) {
                return item;
            }
        }
        return ERROR;
    }

    @Override
    public String toString() {
        return code + "." + menuName;
    }
}
