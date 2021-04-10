package View;



import Model.Logic;
import processing.core.PApplet;

public class Main extends PApplet{
	
	public static void main(String[] args) {
		PApplet.main("View.Main");
	}
	
	@Override
	public void settings() {
		size(500,350);
		 
		 
	}
	
	Logic logica;
	
	
	
	
	@Override
	public void setup() {
		textAlign(CENTER,CENTER);
		rectMode(CENTER);
		logica = new Logic();
		logica.cargarTXT(this);
		logica.crearListas(this);
		logica.crearFiguras();
		
	}
	
@Override
public void draw() {
	background(255);
	logica.pintarFiguras(this);
	
	
     
     

     
    
	}

 }

