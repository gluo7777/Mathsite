package mathsite.services;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import mathproblems.generator.Operation;
import mathsite.beans.Setting;
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
		Setting setting = transformerService.settingViewToObject(settingModel);
		assertThat(setting.getFrequency().get(Operation.DIVIDE),equalTo(30));
		assertThat(setting.getFrequency().get(Operation.MULTIPLY),equalTo(0));
	}
	
	@Test
	public void test_settingObjectToView() {
		Setting setting = new Setting();
		Map<Operation, Integer> map = new LinkedHashMap<>();
		map.put(Operation.ADD, 3);
		map.put(Operation.SUBTRACT, 6);
		SettingModel settingModel = transformerService.settingObjectToView(setting);
		assertThat(settingModel.getFrequencies()[0],equalTo(3));
		assertThat(settingModel.getFrequencies()[0],equalTo(6));
	}

}
