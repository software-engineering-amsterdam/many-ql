package org.uva.sea.qls.encoders.ast;

import java.util.ArrayList;
import java.util.List;

public class Section {

	private final String name;

	private List<String> questionNames = new ArrayList<>();

	private List<Section> subSections = new ArrayList<>();

	public Section(String name) {
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
