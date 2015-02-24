package uva.ql.interpreter.gui.elements;
import uva.ql.ast.expressions.PrimitiveType;
import uva.ql.ast.question.*;
import uva.ql.interpreter.gui.elements.*;


public class UIElement  {
	
	private UILabel label;
	private Question question;
	
	
	
	public UIElement(Question _quest) {
        this.question = _quest;		
	}
	
	public UIContainer createElement() {
		UIContainer container = new UIContainer();
		if (question.getType().getPrimitiveType() == PrimitiveType.BOOLEAN) {
			UICheckBox checkbox = new UICheckBox();
			UILabel label = new UILabel(question.getIdentifier().evaluate().getValue());
			container.add(checkbox,label);}
		else{
			UITextbox textbox = new UITextbox();
			UILabel label = new UILabel(question.getIdentifier().evaluate().getValue());
			container.add(textbox,label);
		}
			return container;
	

}
}