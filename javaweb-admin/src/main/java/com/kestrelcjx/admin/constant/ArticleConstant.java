package com.kestrelcjx.admin.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 文章管理模块常量
 */
public class ArticleConstant {
    /**
     * 是否置顶
     */
    public static Map<Integer, String> ARTICLE_ISTOP_LIST = new HashMap<Integer, String>() {
        {
            put(1, "已置顶");
            put(2, "未置顶");
        }
    };
    /**
     * 状态
     */
    public static Map<Integer, String> ARTICLE_STATUS_LIST = new HashMap<Integer, String>() {
        {
            put(1, "已审核");
            put(2, "待审核");
            put(3, "审核失败");
        }
    };
}