package com.kestrelcjx.system.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息模板模块常量
 */
public class MessageTemplateConstant {
    /**
     * 模板类型
     */
    public static Map<Integer, String> MESSAGETEMPLATE_TYPE_LIST = new HashMap<Integer, String>() {
        {
            put(1, "系统模板");
            put(2, "短信模板");
            put(3, "邮件模板");
            put(4, "微信模板");
            put(5, "推送模板");
        }
    };
    /**
     * 状态
     */
    public static Map<Integer, String> MESSAGETEMPLATE_STATUS_LIST = new HashMap<Integer, String>() {
        {
            put(1, "在用");
            put(2, "停用");
        }
    };
}