package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uva.ql.ast.expressions.PrimitiveType;
import uva.ql.ast.question.*;
import uva.ql.interpreter.observer.Observer;
import uva.ql.interpreter.observer.Subject;
import uva.ql.interpreter.typecheck.Symbol;
import uva.ql.interpreter.typecheck.SymbolMap;
import uva.ql.supporting.Tuple;

public class UIQuestion extends Observer implements UIWidget<Object> {
	
	protected Question question;
	protected SymbolMap symbolTable;
	private String questionText;
	private Component component;
	private Subject subject;
	
	public UIQuestion(Question _question, Subject _subject, SymbolMap _symbolTable) {
		this.subject = _subject;
        this.question = _question;		
        this.symbolTable = _symbolTable;
	}
	
	public UIQuestion(Question _question, Subject _subject, SymbolMap _symbolTable, String questionString){
		this(_question, _subject, _symbolTable);
		this.questionText = questionString;
	}
	
	public UIContainer createElement() {
		UIContainer container = new UIContainer(new Tuple<Integer, Integer>(600,50));
		
		if (question.getType().getPrimitiveType() == PrimitiveType.BOOLEAN) {
			UICheckBox checkbox = new UICheckBox(this.question, this.subject, this.symbolTable, "yes");
			return this.addWithOptions(checkbox.getWidget(), container);
		}
		else {
			UITextField textbox = new UITextField(this.question, this.subject, this.symbolTable);
			return this.addWithOptions(textbox.getWidget(), container);
		}
	}
	private UIContainer addWithOptions(Component component, UIContainer container){
		this.component = component;
		
		List <Object> components = new ArrayList<>(Arrays.asList(new UILabel(this.questionText), this.component));
		container.addComponents(components);
		return container;
	}
	public Component getComponent(){
		return this.component;
	}
	
	@Override
	public void update(){
		if (this.subject == null) System.err.println("Subject is null");
		this.subject.notifyObserver();
	}
	
	@Override
	public Object getWidgetValue() {
		return null;
	}
	@Override
	public String getIdentifier() {
		return this.question.getIdentifier().evaluate().getValue();
	}
	@Override
	public Object getExpression() {
		Symbol question = this.symbolTable.getSymbolForAttributes(this.getIdentifier(), null, Question.class.getName());
		return question;
	}
}