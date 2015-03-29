package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observer;
import javax.swing.JPanel;
import uva.ql.ast.statements.Question;
import uva.ql.ast.type.Type;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.type.TypeInteger;
import uva.ql.ast.type.TypeMoney;
import uva.ql.ast.type.TypeString;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.TypeVisitor;
import uva.ql.interpreter.gui.supporting.Size;

public class UIWidget implements TypeVisitor<Component>{
	
	private Question question;
	private GenericValue<?> value;
	private Observer observer;
	private Component component;
	
	public UIWidget(){}
	
	public UIWidget(Question question, GenericValue<?> value, Observer observer){
		this.question = question;
		this.observer = observer;
		this.value = value;
	}
	
	public Component randerUIWidget(){
		Type type = this.question.getQuestionType();
		return type.accept(this);
	}
	
	public void requestFocus(boolean hasFocus){
		if (hasFocus){
			this.component.requestFocus();
		}
	}
	
	private JPanel randerUIWidgetWithUILabel(Component component){
	
		JPanel container = new UIContainer().randerContainer(new Size(500,50));
		String labelText = this.question.getQuestionLabelText();
		
		List <Component> components = new ArrayList<Component>(
				Arrays.asList(new UILabel().randerUILabel(new Size(280,50), labelText), component));
		
		container = new UIContainer().addComponents(container, components);
		
		return container;
	}

	@Override
	public Component visitTypeBoolean(TypeBoolean booleanType) {
		this.component = new UICheckBox(this.question, this.value, this.observer).rander();
		return this.randerUIWidgetWithUILabel(this.component);
	}

	@Override
	public Component visitTypeInteger(TypeInteger integerType) {
		this.component = new UITextField(this.question, this.value, this.observer).rander();
		return this.randerUIWidgetWithUILabel(this.component);
	}

	@Override
	public Component visitTypeMoney(TypeMoney moneyType) {
		this.component = new UITextField(this.question, this.value, this.observer).rander();
		return this.randerUIWidgetWithUILabel(this.component);
	}

	@Override
	public Component visitTypeString(TypeString stringType) {
		this.component = new UITextField(this.question, this.value, this.observer).rander();
		return this.randerUIWidgetWithUILabel(this.component);
	}
}