package cn.sharit.springboot.listeners;

import org.springframework.boot.autoconfigure.AutoConfigurationImportEvent;
import org.springframework.boot.autoconfigure.AutoConfigurationImportListener;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.List;
import java.util.Set;

public class TestAutoConfigurationImportListener implements AutoConfigurationImportListener {
    @Override
    public void onAutoConfigurationImportEvent(AutoConfigurationImportEvent event) {
        System.out.println("===TestAutoConfigurationImportListener===");

        List<String> loadFactoryNames = SpringFactoriesLoader.loadFactoryNames(EnableAutoConfiguration.class,
                event.getClass().getClassLoader());
        System.out.println("loadFactoryNames=" + loadFactoryNames.size());

        List<String> candidateConfigurations = event.getCandidateConfigurations();
        System.out.println("candidateConfigurations=" + candidateConfigurations.size());
        candidateConfigurations.forEach(System.out::println);

        Set<String> exclusions = event.getExclusions();
        System.out.println("exclusions=" + exclusions.size());

    }
}
