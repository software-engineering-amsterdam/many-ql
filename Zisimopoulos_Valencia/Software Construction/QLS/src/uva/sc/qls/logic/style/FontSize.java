package uva.sc.qls.logic.style;

import uva.sc.qls.ast.INodeVisitor;

public class FontSize implements StyleProperty{

	Integer value;
	
	public FontSize(Integer value) {
		this.value = value;
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Integer getValue() {
		return value;
	}
	
	public String toString() {
		String result = "[FontSize]: " + value;
		return result;
	}

}
