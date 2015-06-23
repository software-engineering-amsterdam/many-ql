package uva.ql.interpreter.gui.supporting;

import uva.ql.supporting.Tuple;

public class Size {

	private Tuple<Integer, Integer> size;
	
	public Size(int width, int height){
		this.size = new Tuple<Integer, Integer>(width, height);
	}
	
	public int getWidth(){
		return this.size.getX();
	}
	
	public int getHeight(){
		return this.size.getY();
	}
}
