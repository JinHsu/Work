package cn.sharit.order.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class OrderConfiguration {

    @Bean
    @LoadBalanced // IRule
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 1.RoundRobinRule 轮询策略
     * <p>
     * 2.RandomRule 随机策略
     * <p>
     * 3.WeightedResponseTimeRule 响应时间权重策略
     * 根据响应时间，分配一个权重weight，响应时间越长，weight越小，被选中的可能性越低
     * <p>
     * 4.ZoneAvoidanceRule
     * 复合判断server所在区域的性能和server的可用性，来选择server返回。
     * <p>
     * 5.RetryRule 轮询失败重试策略
     * 首先使用轮询策略进行负载均衡，如果轮询失败，则再使用轮询策略进行一次重试，相当于重试下一个节点，看下一个节点是否可用，如果再失败，则直接返回失败。
     * <p>
     * 6.BestAvailableRule 并发量最小可用策略
     * 选择一个并发量最小的server返回。如何判断并发量最小呢？ServerStats有个属性activeRequestCount，这个属性记录的就是server的并发量。轮询所有的server，选择其中activeRequestCount最小的那个server，就是并发量最小的服务节点。
     * <p>
     * 7.AvailabilityFilteringRule 可用过滤策略
     * 过滤掉连接失败的服务节点，并且过滤掉高并发的服务节点，然后从健康的服务节点中，使用轮询策略选出一个节点返回。
     * 8.
     */
    @Bean
    public IRule myRule() {
        return new RoundRobinRule();
    }

    // hystrix监控的bean
    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> hystrixMetricsStreamServlet() {
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}
