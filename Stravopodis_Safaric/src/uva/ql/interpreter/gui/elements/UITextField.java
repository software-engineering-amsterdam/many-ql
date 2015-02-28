package uva.ql.interpreter.gui.elements;

import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.question.Question;
import uva.ql.ast.statements.Assign;
import uva.ql.interpreter.observer.Observer;
import uva.ql.interpreter.observer.Subject;
import uva.ql.interpreter.typecheck.Symbol;
import uva.ql.interpreter.typecheck.SymbolMap;
import uva.ql.interpreter.typecheck.exception.IllegalTypeException;
import uva.ql.supporting.ExpressionSupporting;

public class UITextField extends UIQuestion{
	
	private JTextField textField;
	private String value;
	private Subject subject;
	
	public UITextField(Question _question, Subject _subject, SymbolMap _symbolTable) {
		super(_question, _subject, _symbolTable);
		
		this.subject = _subject;
		
		this.textField = new JTextField();
		this.textField.setText(String.valueOf(this.getExpression().evaluate().getValue()));
		this.textField.setColumns(10);
		this.setDocumentListener();
	}
	private void setDocumentListener(){
		
		this.textField.getDocument().addDocumentListener(new DocumentListener(){
			public void insertUpdate(DocumentEvent e) {
				setValue(getWidgetValue());
			}

			public void removeUpdate(DocumentEvent e) {
				setValue(getWidgetValue());
			}

			public void changedUpdate(DocumentEvent e) {
				setValue(getWidgetValue());
			}
		
		});
}
	
	public Component getWidget(){
		return this.textField;
	}
	
	public void setValue(String _value){
		this.value = _value;
		System.err.println("some value - update table: "  + this.getIdentifier() + " - " + this.value);
		// Update the Store Table
		
		Symbol question = (Symbol)super.getExpression();
		question.getSymbolType();
		if (question.getSymbolType() != _value.getClass().getName()){
			throw new IllegalTypeException("IllegalTypeException: you are trying to enter different type of value");
			}
		else {
			this.textField.setText(_value);
			
		}
	}
	@Override
	public String getIdentifier(){
		return this.question.getIdentifier().evaluate().getValue();
	}
	@Override
	public String getWidgetValue() {
		return this.textField.getText();
	}
	@Override
	public Expression getExpression() {
		Symbol s = this.symbolTable.getSymbolForAttributes(getIdentifier(), this.question.getType().getTypeName(), Assign.class.getName());
		
		return ExpressionSupporting.symbolAssignmentExists(s, (Symbol)super.getExpression());
	}
}
