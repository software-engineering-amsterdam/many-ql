package uva.ql.interpreter.gui.elements;

import java.util.Observable;

import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.value.GenericValue;

public abstract class UIWidget extends Observable{
		
	public abstract String getQuestionLabelText();
	
	public abstract Identifier getQuestionIdentifier();
	public abstract String getQuestionIdentifierValue();
	
	public abstract GenericValue<?> getValueForQuestion();
}