package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import uva.ql.ast.expressions.tablevisitor.ValueTable;
import uva.ql.ast.statements.Question;
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.value.GenericValue;

public class UIQuestion extends Observable{
	
	private ValueTable table;
	private Question question;
	private Observer observer;
	
	public UIQuestion(Question question, ValueTable table, Observer observer) {
        this.question = question;
        this.table = table;
        
        this.observer = observer;
        this.addObserver(observer);
	}
	
	public GenericValue<?> getQuestionValue(){
		return this.table.getValue(this.question.getQuestionIdentifierValue());
	}

	public Question getQuestion(){
		return this.question;
	}
	
	public UIContainer returnQuestionElement() {
		
		UIContainer container = new UIContainer(new Size(600,50));
		
		if (question.getQuestionType().equals(new TypeBoolean())){
			UICheckBox checkbox = new UICheckBox(this.question, this.table, this.observer);
			return this.addWithOptions(checkbox.getWidget(), container);
		}
		
		else {
			UITextField textbox = new UITextField(this.question, this.table, this.observer);
			return this.addWithOptions(textbox.getWidget(), container);
		}

	}
	
	protected void updateValue(GenericValue<?> value){
		// Here comes the magic with the transformation
		this.table.updateValueTable(this.question.getQuestionIdentifierValue(), value);
		this.observer.update(this, this.question.getQuestionIdentifier());
	}

	
	private UIContainer addWithOptions(Component component, UIContainer container){
		String questionLabel = question.getQuestionLabelText();
		
		List <Object> components = new ArrayList<>(Arrays.asList(new UILabel(questionLabel), component));
		container.addComponents(components);
		return container;
	}
}