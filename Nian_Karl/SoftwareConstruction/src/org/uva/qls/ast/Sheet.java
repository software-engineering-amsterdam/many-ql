package org.uva.qls.ast;

import java.util.ArrayList;
import java.util.List;

import org.uva.ql.ast.BaseNode;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.utility.CodePosition;

public class Sheet extends BaseNode {

	private final Identifier identifier;
	private final List<Page> pageList;

	public Sheet(Identifier identifier, CodePosition pos) {
		super(pos);
		this.identifier = identifier;
		pageList = new ArrayList<Page>();
	}

	public void addPage(Page page) {
		pageList.add(page);
	}

	public Identifier getIdentifier() {
		return identifier;
	}

	public List<Page> getPageList() {
		return pageList;
	}
}
