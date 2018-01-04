package mathsite.viewmodels;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {
	@Value("${cookie.name:sessionId}")
	private String cookieName;

	@Value("${setting.model.name:settingModel}")
	private String settingModelName;

	@Value("${problem.number.type:number}")
	private String numberTypeName;

	@Value("${problem.fraction.type:fraction}")
	private String fractionTypeName;

	@Value("${problem.model.name:problemModel}")
	private String problemModelName;

	public final String getCookieName() {
		return cookieName;
	}

	public final String getSettingModelName() {
		return settingModelName;
	}

	public final String getNumberTypeName() {
		return numberTypeName;
	}

	public final String getFractionTypeName() {
		return fractionTypeName;
	}

	public final String getProblemModelName() {
		return problemModelName;
	}

}
