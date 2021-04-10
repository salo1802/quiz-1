package View;




import Controller.Controller;
import processing.core.PApplet;

public class Main extends PApplet{
	
	public static void main(String[] args) {
		PApplet.main("View.Main");
	}
	
	@Override
	public void settings() {
		size(900,600);
		 
		 
	}
	
	Controller controller;
	
	
	
	
	@Override
	public void setup() {
		textAlign(CENTER,CENTER);
		rectMode(CENTER);
		ellipseMode(CENTER);
		controller = new Controller(this);
		
		
	}
	
@Override
public void draw() {
	background(255);
	controller.Draw(this); 
	}


@Override
public void mousePressed() {
	controller.pararMovimiento(mouseX, mouseY);
	if(mouseButton==RIGHT) {
	controller.NuevaFigura(mouseX, mouseY);}
}
 }

