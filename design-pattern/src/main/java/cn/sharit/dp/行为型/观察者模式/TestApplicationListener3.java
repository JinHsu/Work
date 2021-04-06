package cn.sharit.dp.行为型.观察者模式;

public class TestApplicationListener3 implements ApplicationListener {
    @Override
    public void onApplcaitionEvent(ApplicationEvent event) {
        System.out.println("TestApplicationListener3");
    }
}
