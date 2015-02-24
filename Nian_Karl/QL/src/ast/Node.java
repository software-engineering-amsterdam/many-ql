package ast;

public interface Node {
	public <T> T accept (Visitor<T> visitor);
}
