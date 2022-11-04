package ar.edu.unlam.pb2;

public class NoSeEncontroLaCarga extends Exception {

	public NoSeEncontroLaCarga(String string) {
		System.out.println("No existe tal carga en el monta cargas");
	}

}
