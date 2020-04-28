package dev.lf.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.lf.brewer.model.Cerveja;

@Controller
public class EstiloController {

	@RequestMapping("/estilos/novo")
	public String novo(Cerveja Cerveja) {
		return "estilo/CadastroEstilo";
	}
	
	@RequestMapping(value = "/estilos/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes red) {
		if (result.hasErrors()) {
			return novo(cerveja);
		}
		
		//save in database
		
		red.addFlashAttribute("msg", "cerveja salva com sucesso");
		
		System.out.println(">>> sku: " + cerveja.getSku());
		return "redirect:/estilos/novo";
	}
	
}