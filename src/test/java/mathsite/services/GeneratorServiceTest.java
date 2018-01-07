package mathsite.services;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import mathproblems.generator.builders.FractionProblemBuilder;
import mathproblems.generator.builders.SimpleProblemBuilder;
import mathproblems.generator.problem.Problem;
import mathsite.beans.Setting;
import mathsite.config.TestConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class GeneratorServiceTest {

	@Autowired
	@InjectMocks
	GeneratorService generatorService;
	
	@Mock
	SimpleProblemBuilder simpleProblemBuilder;
	
	@Mock
	FractionProblemBuilder fractionProblemBuilder; 

	Setting setting;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		setting = new Setting();
		setting.setProblemCount(10);
		List testList = Mockito.mock(List.class);
		when(testList.size()).thenReturn(setting.getProblemCount());
		when(simpleProblemBuilder.buildProblemSet()).thenReturn(testList);
		when(fractionProblemBuilder.buildProblemSet()).thenReturn(testList);
	}

	@Test
	public void test_getSimpleProblemSet() {
		List<Problem<BigDecimal>> problems = generatorService.getSimpleProblemSet(setting);
		assertThat(problems, hasSize(10));
	}

	@Test
	public void test_getFractionProblemSet() {
		List<Problem<Fraction>> problems = generatorService.getFractionProblemSet(setting);
		assertThat(problems, hasSize(10));
	}

}
