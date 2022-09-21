package myboot.app1.web;

import myboot.app1.model.Counter;
import myboot.app1.model.Movie;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Un contrôleur pour gérer les films.
 */
@Controller()
public class HelloController {

	protected final Log logger = LogFactory.getLog(getClass());

	/*
	 * Récupérer un message particulier dans le fichier de configuration pour ne pas
	 * utiliser de constantes dans le code.
	 */
	@Value("${application.message:Hello World}")
	private String message;

	/**
	 * Une simple page de test (GET)
	 */
	@Autowired
	Counter counter;
	@RequestMapping(value = "/hello")
	private ModelAndView hello() {
		counter.setCounter(counter.getCounter()+1);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message",message);
		modelAndView.addObject("counter",counter.getCounter());
		modelAndView.setViewName("hello");
		return modelAndView;
	}


}
