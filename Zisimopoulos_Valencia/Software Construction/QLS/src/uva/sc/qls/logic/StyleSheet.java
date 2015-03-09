package uva.sc.qls.logic;

import java.util.List;
import java.util.ArrayList;

import uva.sc.qls.ast.INode;
import uva.sc.qls.ast.INodeVisitor;
import uva.sc.qls.atom.ID;

public class StyleSheet implements INode{

	ID id;
	List<Page> pages = new ArrayList<Page>();
	
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

	public <T> T accept(INodeVisitor<T> visitor) {
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
