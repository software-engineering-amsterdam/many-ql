package qls.ast;


public abstract class QLSType implements QLSNode {
	public QLSType() {}
	
	public abstract QLSType getType();
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}