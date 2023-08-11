package model;

import java.util.ArrayList;
import java.util.List;

public class FitaEspelhoUnidade {
	private List<Unidade> unidades = new ArrayList<>();

	public List<Unidade> getUnidades() {
		return unidades;
	}

	public void addUnidade(Unidade unidade) {
		this.unidades.add(unidade);
	}
	
	
}
