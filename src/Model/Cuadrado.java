package Model;

import processing.core.PApplet;

public class Cuadrado extends Figura {
	private int color;
	public Cuadrado(int tam, int posX, int posY, int dir, int valor) {
		super(tam, posX, posY, dir, valor);
		color = (int)(Math.random()*11);
		
	}
	
	public void pintarCuadrado(PApplet app) {
		
		switch (color) {
		case 0:
			app.fill(255,0,0);
			break;
		case 1:
			app.fill(255,125,0);
			break;
		case 2:
			app.fill(255,225,0);
			break;
		case 3:
			app.fill(125,255,0);
			break;
		case 4:
			app.fill(0,255,0);
			break;
		case 5:
			app.fill(0,255,125);
			break;
		case 6:
			app.fill(0,255,255);
			break;
		case 7:
			app.fill(0,125,255);
			break;
		case 8:
			app.fill(0,0,255);
			break;
		case 9:
			app.fill(125,0,255);
			break;
		case 10:
			app.fill(255,0,255);
			break;
		case 11:
			app.fill(255,0,125);
			break;
		}
		app.rect(posX, posY, tam, tam);
		app.fill(0);
		app.textSize(tam/2);
		app.text(valor +"", posX, posY);
	} 

}
