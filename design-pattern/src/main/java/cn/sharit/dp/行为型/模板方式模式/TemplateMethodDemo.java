package cn.sharit.dp.行为型.模板方式模式;

/**
 * 模板方法模式：钩子函数
 */
public class TemplateMethodDemo {

    public static void main(String[] args) {
        AddAction addAction = new ExtAddAction();
        addAction.doAction();
    }
}
