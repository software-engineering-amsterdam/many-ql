package ast;

public abstract class Testik implements IMainVisitable {
	public abstract <T> T accept(IMainVisitor<T> visitor);

}
