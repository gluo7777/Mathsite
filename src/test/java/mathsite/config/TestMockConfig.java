package mathsite.config;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mathproblems.generator.builders.FractionProblemBuilder;
import mathproblems.generator.builders.SimpleProblemBuilder;
import mathproblems.generator.calculator.FractionCalculator;
import mathproblems.generator.calculator.SimpleCalculator;
import mathsite.beans.Session;

@Configuration
public class TestMockConfig {
	@Bean
	public SimpleProblemBuilder simpleProblemBuilder() {
		return Mockito.mock(SimpleProblemBuilder.class);
	}

	@Bean
	public FractionProblemBuilder fractionProblemBuilder() {
		return Mockito.mock(FractionProblemBuilder.class);
	}
	
	@Bean
	public SimpleCalculator simpleCalculator() {
		return Mockito.mock(SimpleCalculator.class);
	}
	
	@Bean
	public FractionCalculator fractionCalculator() {
		return Mockito.mock(FractionCalculator.class);
	}
	
	@Bean
	public Session getSession() {
		return Mockito.mock(Session.class);
	}
}
