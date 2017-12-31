package mathsite.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mathproblems.generator.builders.FractionProblemBuilder;
import mathproblems.generator.builders.SimpleProblemBuilder;

@Configuration
public class BeansConfiguration {
	
	@Bean
	public SimpleProblemBuilder simpleProblemBuilder() {
		return new SimpleProblemBuilder();
	}

	@Bean
	public FractionProblemBuilder fractionProblemBuilder() {
		return new FractionProblemBuilder();
	}
}
