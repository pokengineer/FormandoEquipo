package paqueteParcial;

import java.io.*;

public class FormandoEquipo {

	public void cargarArbol(String nom, NodoArbol raiz) {
		try {
			File arch = new File(nom);
			FileReader fr = new FileReader(arch);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			for (int i = 0; i < 2; i++) {
				linea = br.readLine();
			}
			while ((linea = br.readLine()) != null) {
				raiz.addR(linea);
			}

			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void resolver(NodoArbol raiz, String path) {
		// resuelve
		String s = new String(" ");
		NodoArbol mejor = raiz.obtenerMejor();
		//System.out.println( mejor.getPuntaje() );
		String best = mejor.imprimir(s);
		//System.out.println( best );
		String posta = new StringBuilder(best).reverse().toString();//
		//System.out.println( posta );
		// guarda
		FileWriter fw;
		try {
//			fw = new FileWriter(path);
//			fw.write( String.valueOf(mejor.getPuntaje() ) +"\n" );
//			fw.write(posta);
//			fw.close();
			PrintStream fs = new PrintStream(new File(path));
			fs.println( String.valueOf(mejor.getPuntaje() ) );
			fs.println( posta );
			fs.close();
			
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
