package cn.sharit.dp.行为型.模板方式模式;

public abstract class AddAction {

    // 模板方法
    public void doAction() {
        beforeAction();
        //
        setName();
        setAccessKey();
        // ...
        afterAction();
    }

    private void beforeAction() {

    }

    protected void afterAction() {

    }

    // 钩子函数
    protected abstract void setName();

    protected abstract void setAccessKey();

}
