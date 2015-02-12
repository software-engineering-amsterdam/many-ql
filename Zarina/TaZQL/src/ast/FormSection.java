package ast;

public abstract class FormSection implements IMainVisitable {
	public abstract <T> T accept(IMainVisitor<T> visitor);

}
