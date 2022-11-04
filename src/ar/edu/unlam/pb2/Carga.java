package ar.edu.unlam.pb2;

public class Carga {
	
	private Integer id;
	private Double pesoActual;
	public Carga(Integer id, Double pesoActual) {
		super();
		this.id = id;
		this.pesoActual = pesoActual;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPesoActual() {
		return pesoActual;
	}
	public void setPesoActual(Double pesoActual) {
		this.pesoActual = pesoActual;
	}
	@Override
	public String toString() {
		return "Carga [id=" + id + ", pesoActual=" + pesoActual + "]";
	}
	
	

}
