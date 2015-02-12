package ast;

public interface IMainVisitable {
	
	public <T> T accept(IMainVisitor<T> visitor);
		
}
