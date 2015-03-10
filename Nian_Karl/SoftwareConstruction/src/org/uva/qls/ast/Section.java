package org.uva.qls.ast;

import java.util.List;

import org.uva.ql.ast.BaseNode;
import org.uva.utility.CodePosition;

public class Section extends BaseNode{

	private final String sectionTitle;
	private final List<Section> sectionList;
	private final List<Question> questionList;

	public Section(String sectionTitle, List<Section> sectionList, List<Question> questionList,CodePosition pos) {
		super(pos);
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
