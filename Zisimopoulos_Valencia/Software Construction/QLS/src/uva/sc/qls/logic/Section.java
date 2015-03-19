package uva.sc.qls.logic;

import uva.sc.qls.ast.IQLSNode;
import uva.sc.qls.ast.IQLSNodeVisitor;

public class Section implements IQLSNode {

	String		str;
	SectionBody	sectionBody;

	public Section(String str, SectionBody sectionBody) {
		this.str = str;
		this.sectionBody = sectionBody;
	}

	public SectionBody getSectionBody() {
		return sectionBody;
	}

	public <T> T accept(IQLSNodeVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public String toString() {
		String result = "[Section]: " + str + "\n\t";
		result += sectionBody.toString();
		return result;
	}

}
