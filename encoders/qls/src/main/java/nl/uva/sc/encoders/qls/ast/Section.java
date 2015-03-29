package nl.uva.sc.encoders.qls.ast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.TextLocation;
import nl.uva.sc.encoders.qls.visitor.SectionVisitor;

public class Section extends AstNode {

	private final String name;
	private final List<String> questionNames = new ArrayList<>();
	private final List<Section> subSections = new ArrayList<>();
	private final List<DefaultStyle> sectionDefaultStyles = new ArrayList<>();

	public Section(TextLocation textLocation, String name) {
		super(textLocation);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<String> getQuestionNames() {
		return questionNames;
	}

	public void addQuestion(String questionName) {
		questionNames.add(questionName);
	}

	public List<Section> getSectionNames() {
		return subSections;
	}

	public void addSubSection(Section subSection) {
		subSections.add(subSection);
	}

	public void addSectionDefaultStyle(DefaultStyle sectionDefault) {
		sectionDefaultStyles.add(sectionDefault);
	}

	public void collectQuestions(Collection<String> questions) {
		questions.addAll(questionNames);
		for (Section subSection : subSections) {
			subSection.collectQuestions(questions);
		}
	}

	public <T> T accept(SectionVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
