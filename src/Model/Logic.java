package Model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	
	private String[] texto;
	private String[] lineas;
	private ArrayList <String> palabras;
	
	
	public Logic(){
		palabras = new ArrayList<>();
		
	}
	

	public void cargarTXT(PApplet app) {
		texto = app.loadStrings("archivoTXT.txt");
	}
	
	public void crearListas(PApplet app) {
		for (int i = 0; i < texto.length; i++) {
		lineas = PApplet.split(texto[i], " ");
		for (int j = 0; j < lineas.length; j++) {
			palabras.add(lineas[j]);
		}}
	}

	
	public ArrayList<String> getPalabras() {
		return palabras;
	}
	 
	
}