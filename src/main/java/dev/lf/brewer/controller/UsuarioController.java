package dev.lf.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.lf.brewer.model.Usuario;

@Controller
public class UsuarioController {

	@RequestMapping("/usuarios/novo")
	public String novo(Usuario usuario) {
		return "usuario/CadastroUsuario";
	}
	
	@RequestMapping(value = "/usuarios/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Usuario usuario, BindingResult result, Model model, RedirectAttributes red) {
		if (result.hasErrors()) {
			return novo(usuario);
		}
		
		//save in database
		
		red.addFlashAttribute("msg", "usuário salvo com sucesso");
		
		return "redirect:/usuarios/novo";
	}
	
}
