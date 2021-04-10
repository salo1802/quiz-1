package Model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
	private String compCir;
	private String compCua;
	private String[] texto;
	private String[] lineas;
	private ArrayList <String> palabras;
	private ArrayList <Circulo> circulos;
	private ArrayList <Cuadrado> cuadrados;
	private ArrayList <Triangulo> triangulos;
	public int prueba;
	
	public Logic(){
		palabras = new ArrayList<>();
		circulos = new ArrayList<>();
		cuadrados = new ArrayList<>();
		triangulos = new ArrayList<>();
		compCir= " Circulo";
		prueba = 0;
	}
	

	public void cargarTXT(PApplet app) {
		texto = app.loadStrings("archivoTXT.txt");
	}
	
	public void crearListas(PApplet app) {
		for (int i = 0; i < texto.length; i++) {
		lineas = PApplet.split(texto[i], " ");
		
		for (int j = 0; j < lineas.length; j++) {
			palabras.add(lineas[j]);}}
		
	}
	
	public void crearFiguras() {
		
		
		for (int i = 0; i < palabras.size(); i++) {
			if (palabras.get(i).equals("Cuadrado")) {
				int index = i;
				int tam = Integer.parseInt(palabras.get(index+1));
				int posX = Integer.parseInt(palabras.get(index+2));
				int posY = Integer.parseInt(palabras.get(index+3));
				int dir = Integer.parseInt(palabras.get(index+4));
				int valor = Integer.parseInt(palabras.get(index+5));
				Cuadrado nuevoCuadrado = new Cuadrado(tam, posX, posY, dir, valor);
				cuadrados.add(nuevoCuadrado);
				prueba++;
			}
		
			if (palabras.get(i).equals("Circulo")) {	
				int index = i;
				int tam = Integer.parseInt(palabras.get(index+1));
				int posX = Integer.parseInt(palabras.get(index+2));
				int posY = Integer.parseInt(palabras.get(index+3));
				int dir = Integer.parseInt(palabras.get(index+4));
				int valor = Integer.parseInt(palabras.get(index+5));
				Circulo nuevoCirculo = new Circulo(tam, posX, posY, dir, valor);
				circulos.add(nuevoCirculo);
				prueba++;}}}

	public void pintarFiguras (PApplet app) {
		for (int i = 0; i < cuadrados.size(); i++) {
			Cuadrado actual = cuadrados.get(i);
			actual.pintarCuadrado(app);
			actual.mover();
			actual.bordes();
		}
		
		for (int i = 0; i < circulos.size(); i++) {
			Circulo actual = circulos.get(i);
			actual.pintarCirculo(app);
			actual.mover();
			actual.bordes();
		}
		
		for (int i = 0; i < triangulos.size(); i++) {
			Triangulo actual = triangulos.get(i);
			actual.pintarTriangulo(app);
			actual.mover();
			actual.bordes();
		}
	}
	
	public ArrayList<String> getPalabras() {
		return palabras;
	}
	 
	public ArrayList<Circulo> getCirculos() {
		return circulos;
	}
	public int prueba() {
		return prueba;
	} 
}