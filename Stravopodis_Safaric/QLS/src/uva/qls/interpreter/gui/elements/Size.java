package uva.qls.interpreter.gui.elements;

import uva.qls.supporting.Tuple;

public class Size extends Tuple<Integer, Integer>{

	private int height;
	private int width;
	
	public Size(Integer _k, Integer _l) {
		super(_k, _l);
		this.width = _k;
		this.height = _l;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public int getWidth(){
		return this.width;
	}

}
