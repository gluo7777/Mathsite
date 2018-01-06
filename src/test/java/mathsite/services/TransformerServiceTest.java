package mathsite.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.fraction.Fraction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import mathproblems.generator.Operation;
import mathproblems.generator.problem.Problem;
import mathsite.beans.ProblemType;
import mathsite.beans.Setting;
import mathsite.viewmodels.ProblemModel;
import mathsite.viewmodels.SettingModel;

@RunWith(SpringRunner.class)
public class TransformerServiceTest {
	
	TransformerService transformerService;

	@Before
	public void setUp() throws Exception {
		transformerService = new TransformerService();
	}

	@Test
	public void test_settingViewToObject() {
		SettingModel settingModel = new SettingModel();
		settingModel.setFrequencies(new int[] {0,0,0,30});
		settingModel.setProblemType("Number");
		Setting setting = transformerService.settingViewToObject(settingModel);
		assertThat(setting.getFrequency().get(Operation.DIVIDE),equalTo(30));
		assertThat(setting.getFrequency().get(Operation.MULTIPLY),equalTo(0));
		assertThat(setting.getProblemType(), equalTo(ProblemType.NUMBER));
	}
	
	@Test
	public void test_settingObjectToView() {
		Setting setting = new Setting();
		Map<Operation, Integer> map = new LinkedHashMap<>();
		map.put(Operation.ADD, 3);
		map.put(Operation.SUBTRACT, 6);
		setting.setMixMode(false);
		setting.setFrequency(map);
		setting.setProblemType(ProblemType.FRACTION);
		SettingModel settingModel = transformerService.settingObjectToView(setting);
		assertThat(settingModel.getFrequencies()[0],equalTo(3));
		assertThat(settingModel.getFrequencies()[1],equalTo(6));
		assertThat(settingModel.isMixMode(),equalTo(false));
	}
	
	@Test
	public void test_problemObjectToViewList() {
		Problem<BigDecimal> p1 = new Problem<>(new Operation[] {Operation.ADD,Operation.SUBTRACT}, new BigDecimal[] {BigDecimal.valueOf(1),BigDecimal.valueOf(2),BigDecimal.valueOf(3)});
		Problem<BigDecimal> p2 = new Problem<>(new Operation[] {Operation.ADD}, new BigDecimal[] {BigDecimal.valueOf(1),BigDecimal.valueOf(2)});
		p2.setAnswer(BigDecimal.valueOf(10));
		p2.setResult(BigDecimal.valueOf(3));
		List<Problem<BigDecimal>> problems = Arrays.asList(p1,p2);
		List<ProblemModel> problemModels = transformerService.problemObjectToViewList(problems);
		assertThat(problemModels.get(0).getStringList(), contains("1","+","2","-","3"));
		assertThat(problemModels.get(1).getStringList(), contains("1","+","2"));
		assertThat(problemModels.get(1).getUserAnswer(), equalTo("10"));
		assertThat(problemModels.get(1).getCorrectAnswer(), equalTo("3"));
	}
	
	@Test
	public void test_problemObjectToViewResult_BigDecimal() {
		Problem<BigDecimal> problem = new Problem<>(null,null);
		problem.setResult(BigDecimal.valueOf(3));
		ProblemModel problemModel = new ProblemModel();
		transformerService.problemObjectToViewResult(problem, problemModel);
		assertThat(problemModel.getCorrectAnswer(), equalTo("3"));
	}
	
	@Test
	public void test_problemObjectToViewResult_Fraction() {
		Problem<Fraction> problem = new Problem<>(null,null);
		problem.setResult(new Fraction(3, 4));
		ProblemModel problemModel = new ProblemModel();
		transformerService.problemObjectToViewResult(problem, problemModel);
		assertThat(problemModel.getCorrectAnswer(), equalTo("3/4"));
	}
	
	@Test
	public void test_problemViewToObjectAnswerForNumber() {
		ProblemModel problemModel = new ProblemModel();
		problemModel.setUserAnswer("3.5");
		Problem<BigDecimal> problem = new Problem<>(null,null);
		transformerService.problemViewToObjectAnswerForNumber(problem, problemModel);
		assertThat(problem.getAnswer(), equalTo(BigDecimal.valueOf(3.5)));
	}
	
	@Test
	public void test_problemViewToObjectAnswerForFraction() {
		ProblemModel problemModel = new ProblemModel();
		problemModel.setUserAnswer("3/4");
		Problem<Fraction> problem = new Problem<>(null,null);
		transformerService.problemViewToObjectAnswerForFraction(problem, problemModel);
		assertThat(problem.getAnswer(), equalTo(new Fraction(3, 4)));
	}

}
