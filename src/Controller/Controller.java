package Controller;

import Model.Logic;
import processing.core.PApplet;

public class Controller {
	
	Logic logica;
	
	public Controller(PApplet app) {
		
		logica = new Logic();
		logica.cargarTXT(app);
		logica.crearListas(app);
		logica.crearFiguras();
	}
	
	public void Draw(PApplet app) {
		logica.fusiones(app);
		logica.pintarFiguras(app);
	}

}
