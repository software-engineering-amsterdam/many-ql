package uva.ql.supporting;

public class Tuple <T,K>{
	public final T x;
	public final K y;
	
	public Tuple(T _x, K _y){
		this.x = _x;
		this.y = _y;
	}
	public Tuple<T,K> getTuple(){
		return this;
	}
}
