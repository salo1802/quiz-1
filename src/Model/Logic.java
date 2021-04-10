package Model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {
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
	
	public void fusiones(PApplet app) {
		
		boolean colision = false;
		int masGrande = 0;
		//colision de cuadrado con circulo
		for(int i=0; i < cuadrados.size();i++ ) {
			Cuadrado actual1 = cuadrados.get(i);
			for(int j = 0;j < circulos.size();j++) {
			Circulo actual2 = circulos.get(j);
			if(PApplet.dist(actual1.getPosX(),actual1.getPosY(),actual2.getPosX(),actual2.getPosY())<actual2.getTam()) {
				colision = true;}
				if(colision==true) {
				int tam = actual1.getTam()+actual2.getTam();
				int posX = (actual1.getPosX()+actual2.getPosX())/2;
				int posY = (actual1.getPosY()+actual2.getPosY())/2;
				int dir = 1;
				int valor = actual1.getValor()+actual2.getValor();
				Triangulo nuevotriangulo = new Triangulo(tam, posX, posY, dir, valor);
				triangulos.add(nuevotriangulo);
				circulos.remove(actual2);
				cuadrados.remove(actual1);
				colision = false;
			}}}
		//colision de cuadrados con cuadrados
		for(int i=0;i < cuadrados.size();i++) {
			for(int j=1;j < cuadrados.size();j++) {
			Cuadrado actual1 = cuadrados.get(i);
			Cuadrado actual2 = cuadrados.get(j);
			if(actual1.getTam()>actual2.getTam()) {masGrande = actual1.getTam();}
			if(actual1.getTam()<actual2.getTam()) {masGrande = actual2.getTam();
			if(PApplet.dist(actual1.getPosX(),actual1.getPosY(),actual2.getPosX(),actual2.getPosY())< masGrande) {
				colision = true;}
				if(colision==true) {
				int tam = actual1.getTam()+actual2.getTam();
				int posX = (actual1.getPosX()+actual2.getPosX())/2;
				int posY = (actual1.getPosY()+actual2.getPosY())/2;
				int dir = 1;
				int valor = actual1.getValor()+actual2.getValor();
				Triangulo nuevotriangulo = new Triangulo(tam, posX, posY, dir, valor);
				triangulos.add(nuevotriangulo);
				cuadrados.remove(actual2);
				cuadrados.remove(actual1);
				colision = false;
			}}}}
		//colision entre circulos
		
		for(int i=0;i < circulos.size();i++) {
			for(int j=1;j < circulos.size();j++) {
			Circulo actual1 = circulos.get(i);
			Circulo actual2 = circulos.get(j);
			if(actual1.getTam()>actual2.getTam()) {masGrande = actual1.getTam();}
			if(actual1.getTam()<actual2.getTam()) {masGrande = actual2.getTam();
			if(PApplet.dist(actual1.getPosX(),actual1.getPosY(),actual2.getPosX(),actual2.getPosY())< masGrande) {
				colision = true;}
				if(colision==true) {
				int tam = actual1.getTam()+actual2.getTam();
				int posX = (actual1.getPosX()+actual2.getPosX())/2;
				int posY = (actual1.getPosY()+actual2.getPosY())/2;
				int dir = 1;
				int valor = actual1.getValor()+actual2.getValor();
				Triangulo nuevotriangulo = new Triangulo(tam, posX, posY, dir, valor);
				triangulos.add(nuevotriangulo);
				circulos.remove(actual2);
				circulos.remove(actual1);
				colision = false;
			}}}}
		
	}
	
	
	
	public ArrayList<String> getPalabras() {
		return palabras;
	}
	 
	public ArrayList<Circulo> getCirculos() {
		return circulos;
	}
	public ArrayList<Cuadrado> getCuadrados() {
		return cuadrados;
	}
	
	public ArrayList<Triangulo> getTriangulos() {
		return triangulos;
	}
	public int prueba() {
		return prueba;
	} 
}