package cn.sharit.dp.行为型.观察者模式;

import java.util.ArrayList;
import java.util.List;

public class ApplicationEventMultiCaster {

    private List<ApplicationListener> listeners = new ArrayList<>();

    //
    public void multicastEvent(ApplicationEvent event) {
        List<ApplicationListener> listeners = getListeners();
        if (!listeners.isEmpty()) {
            for (ApplicationListener listener : listeners) {
                listener.onApplcaitionEvent(event);
            }
        }
    }

    //
    public void addListeners(ApplicationListener listener) {
        listeners.add(listener);
    }

    public List<ApplicationListener> getListeners() {
        return listeners;
    }
}
