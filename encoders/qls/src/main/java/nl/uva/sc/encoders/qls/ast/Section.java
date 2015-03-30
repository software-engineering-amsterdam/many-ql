package nl.uva.sc.encoders.qls.ast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.qls.visitor.SectionVisitor;

public class Section extends AstNode {

	private final String name;
	private final List<String> questionNames;
	private final List<Section> subSections;
	private final List<DefaultStyle> sectionDefaultStyles;

	public Section(TextLocation textLocation, String name, List<String> questionNames, List<Section> subSections,
			List<DefaultStyle> sectionDefaultStyles) {
		super(textLocation);
		this.name = name;
		this.questionNames = questionNames;
		this.subSections = subSections;
		this.sectionDefaultStyles = sectionDefaultStyles;
	}

	public String getName() {
		return name;
	}

	public List<String> getQuestionNames() {
		return questionNames;
	}

	public List<Section> getSubSections() {
		return subSections;
	}

	public List<DefaultStyle> getSectionDefaultStyles() {
		return sectionDefaultStyles;
	}

	public void collectQuestions(Collection<String> questions) {
		questions.addAll(questionNames);
		for (Section subSection : subSections) {
			subSection.collectQuestions(questions);
		}
	}

	public boolean containsQuestion(String name) {
		List<String> questions = new ArrayList<>();
		collectQuestions(questions);
		return questions.stream().anyMatch(question -> question.equals(name));
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

	public <T> T accept(SectionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
