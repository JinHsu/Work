package cn.sharit.dp.行为型.观察者模式;

public class ObserverDemo {

    public static void main(String[] args) {
        ApplicationEventMultiCaster multiCaster = new ApplicationEventMultiCaster();
        multiCaster.addListeners(new TestApplicationListener1());
        multiCaster.addListeners(new TestApplicationListener2());
        multiCaster.addListeners(new TestApplicationListener3());

        multiCaster.multicastEvent(new ApplicationEvent(null));


    }
}
