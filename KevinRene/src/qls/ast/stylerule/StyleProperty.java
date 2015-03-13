package qls.ast.stylerule;

import ql.ast.QLNode;

public abstract class StyleProperty implements QLNode {
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
