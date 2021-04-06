package cn.sharit.dp.行为型.观察者模式;

public class ApplicationEvent {

    private Object source;

    public ApplicationEvent(Object source) {
        this.source = source;
    }

    public Object getSource() {
        return source;
    }
}
