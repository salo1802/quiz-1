package Model;

public class Figura {
int tam;
int posX;
int posY;
int dirY;
int dirX;
int valor;
	public Figura (int tam,int posX,int posY,int dir,int valor){
		this.tam = tam;
		this.posX = posX;
		this.posY = posY;
		this.dirX = dir;
		this.dirY = dir;
		this.valor = valor;
	}
	
	public void  mover () {
		
		posX += dirX;
		posY += dirY;
	}
	
	public void bordes() {
		//colisiones con bordes
		if(posX-tam/2<0) {
			dirX = 1;
		}
		
		if(posY-tam/2<0) {
			dirY = 1;
		}
		
		if(posX+tam/2>900) {
			dirX = -1 ;
		}
		
		if(posY+tam/2>600) {
			dirY = -1;
		}
	}
	
	public int getDirY() {
		return dirY;
	}
	public int getDirX() {
		return dirX;
	}
	public int getPosX() {
		return posX;
	}
	public int getPosY() {
		return posY;
	}
	public int getTam() {
		return tam;
	}
	public int getValor() {
		return valor;
	}
	public void setDirX(int dirX) {
		this.dirX = dirX;
	}
	public void setDirY(int dirY) {
		this.dirY = dirY;
	}
}
