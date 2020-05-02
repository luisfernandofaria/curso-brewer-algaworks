package dev.lf.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.lf.brewer.model.Cerveja;
import dev.lf.brewer.model.Origem;
import dev.lf.brewer.model.Sabor;
import dev.lf.brewer.repository.Estilos;
import dev.lf.brewer.service.CadastroCervejaService;

@Controller
public class CervejasController {
	
	@Autowired
	private Estilos estilos;
	
	@Autowired
	private CadastroCervejaService cadastroCervejaService;

	@RequestMapping("/cervejas/novo")
	public ModelAndView novo(Cerveja Cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		
		return mv;
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes red) {
		if (result.hasErrors()) {
			System.out.println(result.getFieldError());
			return novo(cerveja);
		}

		// save in database

		cadastroCervejaService.salvar(cerveja);
		red.addFlashAttribute("msg", "cerveja salva com sucesso");
		
		return new ModelAndView("redirect:/cervejas/novo");
	}

}