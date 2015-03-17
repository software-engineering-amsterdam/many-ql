package uva.sc.qls.logic;

import java.util.ArrayList;
import java.util.List;

import uva.sc.qls.ast.IQLSNode;
import uva.sc.qls.ast.IQLSNodeVisitor;
import uva.sc.qls.logic.style.DefaultStyle;

public class SectionBody implements IQLSNode {

	List<Question>	questions	= new ArrayList<Question>();
	List<Section>	sections	= new ArrayList<Section>();
	DefaultStyle	defaultStyle;

	public SectionBody(List<Question> questions, List<Section> sections, DefaultStyle defaultStyle) {
		this.questions = questions;
		this.sections = sections;
		this.defaultStyle = defaultStyle;
	}

	public List<Question> getQuestions() {
		return questions;
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
		String result = "[SectionBody]:\n\t";
		for (Question question : questions) {
			result += question.toString();
		}
		for (Section section : sections) {
			result += section.toString();
		}
		if (defaultStyle != null) {
			result += defaultStyle.toString();
		}
		return result;
	}
}
