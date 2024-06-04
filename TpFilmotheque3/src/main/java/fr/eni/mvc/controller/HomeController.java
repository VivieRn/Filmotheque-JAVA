package fr.eni.mvc.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
public class HomeController {
		@Autowired
		private SessionLocaleResolver slr;
		
		@RequestMapping(value = "/accueil", method = RequestMethod.GET)
		public String accueil() {
			return "index";
		}
		
		@RequestMapping(value = "/i18n", method = RequestMethod.GET)
		public String changerLangue(String lg, ModelMap map) {
			Locale locale = new Locale(lg);
			slr.setDefaultLocale(locale);
			return "index";
		}

}
