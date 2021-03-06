package dev.lf.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.lf.brewer.model.Cidade;

@Controller
public class CidadeController {

	@RequestMapping("/cidades/novo")
	public String novo(Cidade cidade) {
		return "cidade/CadastroCidade";
	}
	
	@RequestMapping(value = "/cidades/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Cidade cidade, BindingResult result, Model model, RedirectAttributes red) {
		if (result.hasErrors()) {
			return novo(cidade);
		}
		
		//save in database
		
		red.addFlashAttribute("msg", "cidade salva com sucesso");
		
		return "redirect:/cidades/novo";
	}
	
}
