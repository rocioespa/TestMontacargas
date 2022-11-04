package ar.edu.unlam.pb2;

import java.util.*;

public class MontaCarga {

	private Integer id;
	private final Double pesoMax;
	private Double pesoActual;
	private Set<Carga> cargas;

	public MontaCarga(Integer id, Double pesoMax, Double pesoActual) {
		super();
		this.id = id;
		this.pesoMax = pesoMax;
		this.pesoActual = pesoActual;
		this.cargas = new HashSet<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPesoMax() {
		return pesoMax;
	}

	public Double getPesoActual() {
		return pesoActual;
	}

	public void setPesoActual(Double pesoActual) {
		this.pesoActual = pesoActual;
	}

	public Set<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(Set<Carga> cargas) {
		this.cargas = cargas;
	}

	public Double limitecargarMontaCarga(Carga c) throws NoRespetaElLimiteDeCarga {
		if (pesoActual <= pesoMax) {
			pesoActual += c.getPesoActual();
			return pesoActual;
		}
		throw new NoRespetaElLimiteDeCarga("Limite de carga");
	}

	public void agregarCarga(Carga c) throws NoRespetaElLimiteDeCarga {
		if ((limitecargarMontaCarga(c) <= this.pesoMax)) {
			this.cargas.add(c);
		}

	}

	public Double obtenerPesoDeLaCarga(Carga c) throws NoSeEncontroLaCarga {
		double pesoActualDeLaCarga = 0.0;
		if(buscarCarga(c)) {
			 pesoActualDeLaCarga = pesoActual;
		}
		return  pesoActualDeLaCarga;
	}

	public Boolean buscarCarga(Carga c) throws NoSeEncontroLaCarga {
		for (Carga carga : cargas) {
			if (carga.getId().equals(c.getId())) {
				return true;
			}
		}
		throw new NoSeEncontroLaCarga("No existe tal carga en el monta cargas");
	}

	public void descargarCarga() {
		for (Carga carga : cargas) {
			this.pesoActual -= carga.getPesoActual();
		}
		this.cargas.removeAll(getCargas());
		
	}

	public Double promedioDeCargas() {
		Double promedio = 0.0;
		for (Carga carga : cargas) {
			promedio += (carga.getPesoActual()/cargas.size());
		}
		return promedio;
		
		
	}

}
