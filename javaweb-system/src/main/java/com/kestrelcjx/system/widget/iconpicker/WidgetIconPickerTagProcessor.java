package com.kestrelcjx.system.widget.iconpicker;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class WidgetIconPickerTagProcessor extends AbstractElementTagProcessor {
    /**
     * 标签名
     */
    private static final String TAG_NAME = "iconPicker";
    /**
     * 优先级
     */
    private static final int PRECEDENCE = 10000;

    /**
     * 构造函数
     *
     * @param dialectPrefix 前缀
     */
    public WidgetIconPickerTagProcessor(String dialectPrefix) {
        super(// 此处理器将仅应用于HTML模式
                TemplateMode.HTML,
                // 要应用于名称的匹配前缀
                dialectPrefix,
                // 标签名称：匹配此名称的特定标签
                TAG_NAME,
                // 将标签前缀应用于标签名称
                true,
                // 无属性名称：将通过标签名称匹配
                null,
                // 没有要应用于属性名称的前缀
                false,
                // 优先(内部方言自己的优先)
                PRECEDENCE);
    }

    @Override
    protected void doProcess(ITemplateContext iTemplateContext, IProcessableElementTag iProcessableElementTag,
                             IElementTagStructureHandler iElementTagStructureHandler) {
        // 组件名称
        String tagName = iProcessableElementTag.getAttributeValue("name");
        // 组件值
        String tagValue = iProcessableElementTag.getAttributeValue("value");
        // 组件数据源
        String tagType = iProcessableElementTag.getAttributeValue("type");
        // 创建将替换自定义标签的DOM结构
        IModelFactory modelFactory = iTemplateContext.getModelFactory();
        IModel model = modelFactory.createModel();
        model.add(modelFactory.createOpenElementTag(String.format("input type=\"hidden\" id=\"%s\" name=\"%s\"" +
                " lay-filter=\"%s\" value=\"%s\"", tagName, tagName, tagName, tagValue)));
        // 创建CSS
        model.add(modelFactory.createOpenElementTag("style type=\"text/css\""));
        model.add(modelFactory.createText(".layui-iconpicker .layui-anim {\n" +
                "    display: none;\n" +
                "    position: absolute;\n" +
                "    left: 0;\n" +
                "    top: 42px;\n" +
                "    padding: 5px 0;\n" +
                "    z-index: 899;\n" +
                "    min-width: 150% !important;\n" +
                "    border: 1px solid #d2d2d2;\n" +
                "    max-height: 300px;\n" +
                "    overflow-y: auto;\n" +
                "    background-color: #fff;\n" +
                "    border-radius: 2px;\n" +
                "    box-shadow: 0 2px 4px rgba(0,0,0,.12);\n" +
                "    box-sizing: border-box;\n" +
                "}"));
        model.add(modelFactory.createCloseElementTag("style"));
        // 添加JS
        model.add(modelFactory.createOpenElementTag("script th:inline=\"javascript\" type=\"text/javascript\""));
        model.add(modelFactory.createText("" +
                "layui.use(['iconPicker'], function () {\n" +
                "            var iconPicker = layui.iconPicker;\n" +
                "            \n" +
                "            iconPicker.render({\n" +
                "                // 选择器，推荐使用input\n" +
                String.format("                elem: '#%s',\n", tagName) +
                "                // 数据类型：fontClass/unicode，推荐使用fontClass\n" +
                "                type: 'fontClass',\n" +
                "                // 是否开启搜索：true/false，默认true\n" +
                "                search: true,\n" +
                "                // 是否开启分页：true/false，默认true\n" +
                "                page: true,\n" +
                "                // 每页显示数量，默认12\n" +
                "                limit: 12,\n" +
                "                // 点击回调\n" +
                "                click: function (data) {\n" +
                "                    console.log(data);\n" +
                "                },\n" +
                "                // 渲染成功后的回调\n" +
                "                success: function(d) {\n" +
                "                    console.log(d);\n" +
                "                }\n" +
                "            });\n" +
                "/**\n" +
                " * 选中图标 （常用于更新时默认选中图标）\n" +
                " * @param filter lay-filter\n" +
                " * @param iconName 图标名称，自动识别fontClass/unicode\n" +
                " */\n" +
                String.format("iconPicker.checkIcon('%s', '%s')", tagName, tagValue) +
                "});"));
        model.add(modelFactory.createCloseElementTag("script"));
        // 利用引擎替换整合标签
        iElementTagStructureHandler.replaceWith(model, false);
    }
}
