package paqueteParcial;

import java.util.*;

public class NodoArbol {

	private ArrayList<NodoArbol> hojas;
	private NodoArbol padre;
	private char ch;
	private double puntaje;
	private int cant;
	private int nivel;
	
	public double getPuntaje() {
		return puntaje;
	}

	public NodoArbol(char ch) {
		this.ch = ch;
		this.hojas = new ArrayList<NodoArbol>();
		this.puntaje = 0;
		this.cant = 0;
		this.padre =null;
		this.nivel = 0;
	}

	public NodoArbol(String s) {
		this.ch = (s.toCharArray())[0];
		this.hojas = new ArrayList<NodoArbol>();
		this.puntaje = 0;
		this.cant = 0;
		this.padre =null;
		this.nivel = 0;
	}

	public void addR(String s) {
		if (s.isEmpty()) {
			this.cant++;
			if( this.cant > 1 ) {
				this.puntaje = this.cant * Math.pow( this.nivel, 2);
			}
			return;
		}

		this.cant++;
		boolean flag = true;
		for (NodoArbol item : this.hojas) { //veo si ya esta entre las hojas
			if (item.ch == (s.toCharArray())[0]) {
				String[] aux = s.split("", 2);
				item.addR(aux[1]);
				flag = false;
				break;
			}
		}
		if( flag ) { 				//si no estaba entre las hojas creo una hoja nueva
			NodoArbol nuevo = new NodoArbol( s );
			hojas.add( nuevo );
			String[] aux = s.split("", 2);
			nuevo.padre = this;
			nuevo.nivel = this.nivel + 1;
			nuevo.addR(aux[1]);
		}
		
		if( this.cant > 1 ) {
			this.puntaje = this.cant * Math.pow( this.nivel, 2);
		}
	}
	
	public String imprimir(String s) {
		if( this.padre != null ) {
			s = s + Character.toString(this.ch);
			s = padre.imprimir( s );
		}
		return s;
	}

	
	public NodoArbol obtenerMejor() {
		NodoArbol mejor = this;
		
		NodoArbol aux;
		for(NodoArbol item : this.hojas ){
			aux = item.obtenerMejor();
			if( aux.puntaje > mejor.puntaje )
			{
				mejor = aux;
			}
		}
		return mejor;
	}
	
	
	

}
