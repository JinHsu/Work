package cn.sharit.dp.行为型.观察者模式;

public class TestApplicationListener1 implements ApplicationListener {
    @Override
    public void onApplcaitionEvent(ApplicationEvent event) {
        event.getSource();
        System.out.println("TestApplicationListener1");
    }
}
