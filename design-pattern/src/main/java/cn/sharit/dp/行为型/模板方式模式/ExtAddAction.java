package cn.sharit.dp.行为型.模板方式模式;

public class ExtAddAction extends AddAction {
    @Override
    protected void setName() {
        System.out.println("setName: 新增");
    }

    @Override
    protected void setAccessKey() {
        System.out.println("setAccessKey: Ctrl+N");
    }
}
