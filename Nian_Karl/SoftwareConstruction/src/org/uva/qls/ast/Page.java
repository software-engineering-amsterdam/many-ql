package org.uva.qls.ast;

import java.util.List;

import org.uva.ql.ast.BaseNode;
import org.uva.qls.ast.style.Style;
import org.uva.utility.CodePosition;

public class Page extends BaseNode {

	private final String identifier;
	private final List<Section> sectionList;
	private final List<Style> styleList;

	public Page(String identifier, List<Section> sectionList, List<Style> styleList,CodePosition pos) {
		super(pos);
		this.identifier = identifier;
		this.sectionList = sectionList;
		this.styleList = styleList;
	}

	public List<Section> getSectionList() {
		return sectionList;
	}

	public String getIdentifier() {
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
}
