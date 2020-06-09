import processing.core.PApplet;


public class Target extends Block {
	
    public Target(int inrow, int incol) {
    	row = inrow;  	col = incol; w=50; h=20;
    	x = (row-1)*(50+5); 
    	y = (col-1)*(20+3);
    	dx = 3; dy=0; 
    }
	@Override
	public void update() {
		x = x+dx; 	
	}
	@Override
	public void draw(PApplet p) {
	//	p.fill(0,255,0);
		if(col==1){				//to have each row of targets be a different color
			p.fill(0,255,0);
		}
		if(col==2){
			p.fill(0,0,255);
		}
		if(col==3){
			p.fill(255,0,0);
		}
		if(col==4){
			p.fill(255,255,0);
		}
		if(col==5){
			p.fill(230,230,250);
		}
		p.rect(x, y, w, h);
		
		
	}
	
	@Override
	public boolean collide(Missle m) {
	if (m.x- m.w/2 > this.x + this.w) {return false;}  //left
	if (m.x+ m.w/2 < this.x  ) {return false;}  //right
	if (m.y- m.h/2 > this.y + this.h) {return false;}  //bottom
	if (m.y+ m.w/2 < this.y  ) {return false;}  //top
	return true;
	}
	

}
