package mathsite.controllers;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import mathsite.beans.Session;
import mathsite.beans.Setting;
import mathsite.services.GeneratorService;
import mathsite.services.SettingService;
import mathsite.services.TransformerService;
import mathsite.viewmodels.ProblemModel;
import mathsite.viewmodels.PropertyService;
import mathsite.viewmodels.SettingModel;

@Controller
public class SiteController {
	@Autowired
	PropertyService propertyService;

	@Autowired
	private SettingService settingService;

	@Autowired
	private TransformerService transformerService;

	@Autowired
	private GeneratorService generatorService;
	
	@Autowired
	private Session session;
	
	@RequestMapping("/")
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
		Setting setting = null;
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals(propertyService.getCookieName())) {
				setting = settingService.getSetting(cookie.getValue());
			}
		}
		if (setting == null) {
			setting = transformerService.settingViewToObject((SettingModel) model.asMap().get(propertyService.getSettingModelName()));
			setting.setCookieId(UUID.randomUUID().toString());
		}
		session.setSetting(setting);
		return "index";
	}
	
	@RequestMapping("/generate-problems/{type}")
	public String generateListOfProblems(Model model, @PathVariable("type") String type) {
		List<ProblemModel> problems = null;
		if(type.equals(propertyService.getNumberTypeName())) {
			model.asMap().put(propertyService.getProblemModelName(), problems);
		}
		return null;
	}
	
	
}