package nl.uva.sc.encoders.qls.ast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.qls.visitor.AstVisitor;

public class Section extends AstNode {

	private final String name;
	private final List<Question> questions;
	private final List<Section> subSections;
	private final List<DefaultStyle> sectionDefaultStyles;

	public Section(TextLocation textLocation, String name, List<Question> questions, List<Section> subSections,
			List<DefaultStyle> sectionDefaultStyles) {
		super(textLocation);
		this.name = name;
		this.questions = questions;
		this.subSections = subSections;
		this.sectionDefaultStyles = sectionDefaultStyles;
	}

	public String getName() {
		return name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public List<Section> getSubSections() {
		return subSections;
	}

	public List<DefaultStyle> getSectionDefaultStyles() {
		return sectionDefaultStyles;
	}

	public void collectQuestions(Collection<Question> questions) {
		questions.addAll(this.questions);
		for (Section subSection : subSections) {
			subSection.collectQuestions(questions);
		}
	}

	public boolean containsQuestion(String name) {
		List<Question> questions = new ArrayList<>();
		collectQuestions(questions);
		return questions.stream().anyMatch(question -> question.getName().equals(name));
	}

	public DefaultStyle getDefaultStyle(String questionName) {
		for (Section subSection : subSections) {
			if (subSection.containsQuestion(questionName)) {
				return subSection.getDefaultStyle(questionName);
			}
		}
		if (!sectionDefaultStyles.isEmpty()) {
			return sectionDefaultStyles.get(0);
		}
		return null;
	}

	public <T> T accept(AstVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
