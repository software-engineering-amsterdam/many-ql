package uva.sc.qls.logic;

import uva.sc.qls.ast.INode;
import uva.sc.qls.ast.INodeVisitor;

public class Section implements INode{

	String str;
	SectionBody sectionBody;
	
	public Section(String str, SectionBody sectionBody) {
		this.str = str;
		this.sectionBody = sectionBody;
	}

	public SectionBody getSectionBody() {
		return sectionBody;
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
	public String toString() {
		String result = "[Section]: " + str + "\n\t";
		result += sectionBody.toString(); 
		return result;
	}

}
