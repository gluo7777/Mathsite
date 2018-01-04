package mathsite.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mathproblems.generator.builders.FractionProblemBuilder;
import mathproblems.generator.builders.SimpleProblemBuilder;
import mathproblems.generator.calculator.FractionCalculator;
import mathproblems.generator.calculator.SimpleCalculator;
import mathproblems.generator.randomizer.SimpleRandomizer;
import mathsite.beans.Session;

@Configuration
public class BeansConfiguration {
	
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
	
	public final Session getSession() {
		return new Session();
	}
}
