package uva.ql.supporting;

public class Tuple <T,K>{
	
	private T x;
	private K y;
	
	public Tuple(T _x, K _y){
		this.x = _x;
		this.y = _y;
	}
	
	public T getX(){
		return this.x;
	}
	
	public K getY(){
		return this.y;
	}
	
	public Tuple<T,K> getTuple(){
		return this;
	}

	public String toString(){
		return this.x + " " + this.y;
	}
}
