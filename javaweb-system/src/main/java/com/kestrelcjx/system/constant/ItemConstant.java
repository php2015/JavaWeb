package com.kestrelcjx.system.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 站点模块常量
 */
public class ItemConstant {
    /**
     * 站点类型
     */
    public static Map<Integer, String> ITEM_TYPE_LIST = new HashMap<Integer, String>() {
        {
            put(1, "普通站点");
            put(2, "其他");
        }
    };
    /**
     * 是否二级域名
     */
    public static Map<Integer, String> ITEM_ISDOMAIN_LIST = new HashMap<Integer, String>() {
        {
            put(1, "是");
            put(2, "否");
        }
    };
    /**
     * 状态
     */
    public static Map<Integer, String> ITEM_STATUS_LIST = new HashMap<Integer, String>() {
        {
            put(1, "在用");
            put(2, "停用");
        }
    };
}