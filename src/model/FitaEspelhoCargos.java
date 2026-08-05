package model;

import java.util.ArrayList;
import java.util.List;

public class FitaEspelhoCargos {

	private List<Cargo> cargos = new ArrayList<>();

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void addCargo(Cargo cargo) {
		this.cargos.add(cargo);
	}
}
