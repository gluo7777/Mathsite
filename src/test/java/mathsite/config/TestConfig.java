package mathsite.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mathproblems.generator.builders.FractionProblemBuilder;
import mathproblems.generator.builders.SimpleProblemBuilder;
import mathproblems.generator.calculator.FractionCalculator;
import mathproblems.generator.calculator.SimpleCalculator;
import mathsite.beans.Session;
import mathsite.services.GeneratorService;

@Configuration
public class TestConfig {
	
	@Bean
	public GeneratorService generatorService() {
		return new GeneratorService();
	}
	
	@Bean
	public SimpleProblemBuilder simpleProblemBuilder() {
		return new SimpleProblemBuilder().setCalculator(new SimpleCalculator());
	}

	@Bean
	public FractionProblemBuilder fractionProblemBuilder() {
		return new FractionProblemBuilder().setCalculator(new FractionCalculator());
	}
	
	@Bean
	public SimpleCalculator simpleCalculator() {
		return new SimpleCalculator();
	}
	
	@Bean
	public FractionCalculator fractionCalculator() {
		return new FractionCalculator();
	}
	
	@Bean
	public Session getSession() {
		return new Session();
	}
}
