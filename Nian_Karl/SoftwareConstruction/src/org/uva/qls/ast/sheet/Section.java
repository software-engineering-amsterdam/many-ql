package org.uva.qls.ast.sheet;

import java.util.List;

import org.uva.qls.ast.BaseNode;
import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.StrLiteral;
import org.uva.qls.visitor.SheetVisitable;
import org.uva.qls.visitor.SheetVisitor;

public class Section extends BaseNode implements SheetVisitable {

	private final StrLiteral sectionTitle;
	private final List<Style> styleList;
	private final List<Question> questionList;

	public Section(StrLiteral sectionTitle, List<Style> styleList, List<Question> questionList, CodePosition pos) {
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

	public List<Style> getStyleList() {
		return styleList;
	}

	public Question getQuestion(int i) {
		return questionList.get(i);
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	@Override
	public String toString() {
		return sectionTitle.toString();
	}

	@Override
	public <T> T accept(SheetVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
