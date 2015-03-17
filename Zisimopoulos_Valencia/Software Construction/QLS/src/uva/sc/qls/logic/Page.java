package uva.sc.qls.logic;

import java.util.ArrayList;
import java.util.List;

import uva.sc.qls.ast.IQLSNode;
import uva.sc.qls.ast.IQLSNodeVisitor;
import uva.sc.qls.logic.style.DefaultStyle;

public class Page implements IQLSNode {

	ID				id;
	List<Section>	sections	= new ArrayList<Section>();
	DefaultStyle	defaultStyle;

	public Page(ID id, List<Section> sections, DefaultStyle defaultStyle) {
		this.id = id;
		this.sections = sections;
		this.defaultStyle = defaultStyle;
	}

	public ID getId() {
		return id;
	}

	public List<Section> getSections() {
		return sections;
	}

	public DefaultStyle getDefaultStyle() {
		return defaultStyle;
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		String result = "[Page]: " + id.toString() + "\n\t\t";
		for (Section section : sections) {
			result += section.toString();
		}
		if (defaultStyle != null) {
			result += defaultStyle.toString();
		}
		return result;
	}

}
