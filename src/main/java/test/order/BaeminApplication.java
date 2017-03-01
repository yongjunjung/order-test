package test.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import spring.trace.configuration.EnableTrace;

@SpringBootApplication
@EnableTransactionManagement
@EnableTrace(basePackages = {"test.order.service"}, proxyTargetClass = true)
public class BaeminApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BaeminApplication.class, args);
	}
}



