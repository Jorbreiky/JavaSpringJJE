package mvc1.controllers;

import java.util.List;
import java.util.Locale;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mvc1.models.Alumno;
import mvc1.models.AlumnoDao;
import mvc1.utilerias.Log;

@Controller
public class HomeController {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	private AlumnoDao alumnoDao = (AlumnoDao) context.getBean("AlumnoDAO");
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		List<Alumno> lista = alumnoDao.getAll();
		model.addAttribute("lista", lista);	
		return "alumno_all";
	}
	
	@RequestMapping(value = "/insert")
	public String insert(Locale locale, Model model) {
		return "alumno_add";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(int id, Model model) {
		Alumno alumno = alumnoDao.findByAlumnoId(id);
		model.addAttribute("alumno", alumno);
		return "alumno_edit";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int id, Model model) {
		String mensaje = alumnoDao.delete(id);
		model.addAttribute("operacion","Eliminación");
		model.addAttribute("mensaje", "Eliminacion: "+mensaje);
		return "mensaje";
	}
	
	@RequestMapping(value = "/alumnoAdd", method = RequestMethod.GET)
	public String alumnoAdd(Alumno alumno, Model model) {
		model.addAttribute("operacion", "Inserción");
		model.addAttribute("mensaje", "Se ha insertado correctamente ha "+alumno.toString());
		alumnoDao.insert(alumno);
		return "mensaje";
	}
	
	@RequestMapping(value = "/alumnoUpdate", method = RequestMethod.GET)
	public String alumnoUpdate(Alumno alumno, Model model) {
		alumnoDao.update(alumno);
		model.addAttribute("operacion", "Actualización");
		model.addAttribute("mensaje", "Se ha actualizado correctamente ha "+alumno.toString());
		return "mensaje";
	}
	
}
