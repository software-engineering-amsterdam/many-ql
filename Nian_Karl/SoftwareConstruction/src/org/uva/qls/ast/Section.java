package org.uva.qls.ast;

import java.util.List;

import org.uva.ql.ast.BaseNode;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.qls.ast.style.Style;
import org.uva.utility.CodePosition;

public class Section extends BaseNode{

	private final StrLiteral sectionTitle;
	private final List<Style> styleList;
	private final List<Question> questionList;

	public Section(StrLiteral sectionTitle, List<Style> styleList, List<Question> questionList,CodePosition pos) {
		super(pos);
		this.sectionTitle = sectionTitle;
		this.styleList = styleList;
		this.questionList = questionList;
	}

	public StrLiteral getSectionTitle() {
		return sectionTitle;
	}

	public Style getStyle(int i) {
		return styleList.get(i);
	}

	public int getStylesize() {
		return styleList.size();
	}
	
	public Question getQuestion(int i) {
		return questionList.get(i);
	}

	public int getQuestionListSize() {
		return questionList.size();
	}
}
