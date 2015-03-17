package uva.sc.qls.logic;

import java.util.List;
import java.util.ArrayList;

import uva.sc.qls.ast.IQLSNode;
import uva.sc.qls.ast.IQLSNodeVisitor;

public class StyleSheet implements IQLSNode {

	ID			id;
	List<Page>	pages	= new ArrayList<Page>();

	public StyleSheet(ID id, List<Page> pages) {
		this.id = id;
		this.pages = pages;
	}

	public ID getId() {
		return id;
	}

	public List<Page> getPages() {
		return pages;
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		String result = "[Stylesheet]: " + id.toString() + " {\n\t";
		for (Page page : pages) {
			result += page.toString();
		}
		result += "\n}";
		return result;
	}

}
