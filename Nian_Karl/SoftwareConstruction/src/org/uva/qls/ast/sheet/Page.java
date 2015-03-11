package org.uva.qls.ast.sheet;

import java.util.List;

import org.uva.qls.ast.BaseNode;
import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.IdentifierLiteral;
import org.uva.qls.ast.style.StyleProperty;

public class Page extends BaseNode {

	private final IdentifierLiteral identifier;
	private final List<Section> sectionList;
	private final List<Style> styleList;

	public Page(IdentifierLiteral identifier, List<Section> sectionList, List<Style> styleList, CodePosition pos) {
		super(pos);
		this.identifier = identifier;
		this.sectionList = sectionList;
		this.styleList = styleList;
	}

	public List<Section> getSectionList() {
		return sectionList;
	}

	public IdentifierLiteral getIdentifier() {
		return identifier;
	}

	public List<Style> getStyleList() {
		return styleList;
	}

	public Section getSection(int i) {
		return sectionList.get(i);
	}

	public Style getStyle(int i) {
		return styleList.get(i);
	}

	public int getSectionListSize() {
		return sectionList.size();
	}

	public int getStyleListSize() {
		return styleList.size();
	}
	
	@Override
	public String toString() {
		return identifier.getValue().toString();
	}
}
