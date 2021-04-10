package View;



import Model.Figura;
import processing.core.PApplet;

public class Main extends PApplet{
	
	public static void main(String[] args) {
		PApplet.main("View.Main");
	}
	
	@Override
	public void settings() {
		size(900,600);
		 
		 
	}
	
	 
	Figura prueba;
	
	
	@Override
	public void setup() {
		prueba = new Figura(50,450,300,-1,15);
	
	}
	
@Override
public void draw() {
	circle(prueba.getPosX(),prueba.getPosY(), prueba.getTam());
	prueba.bordes();
	prueba.mover();
	
	  
     
     

     
    
	}

 }

