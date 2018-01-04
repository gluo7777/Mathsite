package mathsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mathsite.beans.Setting;
import mathsite.repository.SettingRepository;

@Service
public class SettingService {
	
	@Autowired
	SettingRepository settingRepository;
	
	public Setting getSetting(String cookieId) {
		return settingRepository.findOne(cookieId);
	}

	public void saveSetting(Setting setting) {
		Setting old = settingRepository.findOne(setting.getCookieId());
		if(old != null) {
			setting.setCookieId(old.getCookieId());		
		}
		settingRepository.save(setting);
	}
}
