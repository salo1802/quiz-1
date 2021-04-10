package Controller;

import Model.Circulo;
import Model.Cuadrado;
import Model.Logic;
import Model.Triangulo;
import processing.core.PApplet;

public class Controller {
	
	Logic logica;
	boolean tipo;
	
	public Controller(PApplet app) {
		
		logica = new Logic();
		logica.cargarTXT(app);
		logica.crearListas(app);
		logica.crearFiguras();
		tipo = true;
		
	}
	
	public void Draw(PApplet app) {
		logica.fusiones(app);
		logica.pintarFiguras(app);
	}

	public void NuevaFigura(int mouseX,int mouseY) {
		if (tipo==true) {
				Circulo actual = new Circulo( (int)(5 +(Math.random()*100)), mouseX, mouseY, 1,  (int)(Math.random()*15));
			logica.getCirculos().add(actual);
			tipo = false;}
		else {
			Cuadrado actual = new Cuadrado( (int)(5 +(Math.random()*100)), mouseX, mouseY, 1,  (int)((1+Math.random()*15)));
			logica.getCuadrados().add(actual);}}
	
	
	public void pararMovimiento(int mouseX, int mouseY) {
		for(int i = 0;  i < logica.getCirculos().size();i++) {
			Circulo actual = logica.getCirculos().get(i);
			if(PApplet.dist(mouseY, mouseY, actual.getPosX(),actual.getPosY())<actual.getTam()) {
				if(actual.getDirX()== 0 && actual.getDirY()== 0) { actual.setDirX(1); actual.setDirY(1);}
				else actual.setDirX(0); actual.setDirY(0);}}
	
		for(int i = 0;  i < logica.getCuadrados().size();i++) {
			Cuadrado actual = logica.getCuadrados().get(i);
			if(PApplet.dist(mouseY, mouseY, actual.getPosX(),actual.getPosY())<actual.getTam()) {
				if(actual.getDirX()== 0 && actual.getDirY()== 0) { actual.setDirX(1); actual.setDirY(1);}
				else actual.setDirX(0); actual.setDirY(0);}}
		
		for(int i = 0;  i < logica.getTriangulos().size();i++) {
			Triangulo actual = logica.getTriangulos().get(i);
			if(PApplet.dist(mouseY, mouseY, actual.getPosX(),actual.getPosY())<actual.getTam()) {
				if(actual.getDirX()== 0 && actual.getDirY()== 0) { actual.setDirX(1); actual.setDirY(1);}
				else actual.setDirX(0); actual.setDirY(0);}}
	}
}
