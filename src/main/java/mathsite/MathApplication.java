package mathsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

/**
 * {@link WebApplicationInitializer} is intended as an alternative or supplement
 * to configuring the servlet using web.xml {@link SpringBootApplication}
 * configuration and start application all in one
 * 
 * @author wums
 *
 */
@SpringBootApplication
public class MathApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MathApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(MathApplication.class);
		app.run(args);
	}

}
