package paqueteParcial;


public class Main {

	public static void main(String[] args) {
		NodoArbol raiz = new NodoArbol(" ");
		FormandoEquipo E = new FormandoEquipo();
		E.cargarArbol("equipos2.in", raiz);
		E.resolver(raiz, "equipos.out");
	}

}
