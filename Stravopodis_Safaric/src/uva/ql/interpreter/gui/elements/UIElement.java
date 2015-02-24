package uva.ql.interpreter.gui.elements;
import java.awt.Dimension;
import java.awt.FlowLayout;

import uva.ql.ast.expressions.PrimitiveType;
import uva.ql.ast.question.*;
import uva.ql.interpreter.gui.elements.*;
import uva.ql.supporting.Tuple;


public class UIElement  {
	
	private String questionText;
	private Question question;
	
	
	public UIElement(Question _quest, String _questionText) {
        this.question = _quest;		
        this.questionText = _questionText;
	}
	
	public UIContainer createElement() {
		UIContainer container = new UIContainer(new Tuple<Integer, Integer>(600,50));
		
		if (question.getType().getPrimitiveType() == PrimitiveType.BOOLEAN) {
			UICheckBox checkbox = new UICheckBox();
			UILabel label = new UILabel(this.questionText);
			
			container.add(label);
			container.add(checkbox);
		}
		else {
			UITextbox textbox = new UITextbox();
			UILabel label = new UILabel(this.questionText);
			
			container.add(label);
			container.add(textbox);
		}
			return container;
	}
}