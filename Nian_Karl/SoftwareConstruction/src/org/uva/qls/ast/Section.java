package org.uva.qls.ast;

import java.util.List;

import org.uva.ql.ast.QLNode;

public class Section implements QLNode{

	private final String sectionTitle;
	private final List<Section> sectionList;
	private final List<Question> questionList;

	public Section(String sectionTitle, List<Section> sectionList, List<Question> questionList) {
		super();
		this.sectionTitle = sectionTitle;
		this.sectionList = sectionList;
		this.questionList = questionList;
	}

	public String getSectionTitle() {
		return sectionTitle;
	}

	public Section getSection(int i) {
		return sectionList.get(i);
	}

	public int getSectionListSize() {
		return sectionList.size();
	}
	
	public Question getQuestion(int i) {
		return questionList.get(i);
	}

	public int getQuestionListSize() {
		return questionList.size();
	}
}
