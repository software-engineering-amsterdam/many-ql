package nl.uva.sc.encoders.qls.ast;

import java.util.ArrayList;
import java.util.List;

public class Section extends AstNodeWithLocation {

	private final String name;

	private List<String> questionNames = new ArrayList<>();

	private List<Section> subSections = new ArrayList<>();

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

}
