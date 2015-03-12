package org.uva.qls.ast.sheet;

import java.util.ArrayList;
import java.util.List;

import org.uva.qls.ast.BaseNode;
import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.IdentifierLiteral;
import org.uva.qls.visitor.SheetVisitable;
import org.uva.qls.visitor.SheetVisitor;

public class Sheet extends BaseNode implements SheetVisitable {

	private final IdentifierLiteral identifier;
	private final List<Page> pageList;

	public Sheet(IdentifierLiteral name, CodePosition pos) {
		super(pos);
		this.identifier = name;
		pageList = new ArrayList<Page>();
	}

	public void addPage(Page page) {
		pageList.add(page);
	}

	public IdentifierLiteral getIdentifier() {
		return identifier;
	}

	public List<Page> getPageList() {
		return pageList;
	}

	@Override
	public String toString() {
		return identifier.getValue().toString();
	}

	@Override
	public <T> T accept(SheetVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
