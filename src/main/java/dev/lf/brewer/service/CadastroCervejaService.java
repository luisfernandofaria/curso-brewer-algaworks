package dev.lf.brewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.lf.brewer.model.Cerveja;
import dev.lf.brewer.repository.Cervejas;

@Service
public class CadastroCervejaService {
	
	@Autowired
	private Cervejas cervejas;

	@Transactional
	public void salvar(Cerveja cerveja) {
		cervejas.save(cerveja);
	}
	
}
