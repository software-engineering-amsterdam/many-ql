package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.question.Question;
import uva.ql.ast.statements.Assign;
import uva.ql.interpreter.observer.Subject;
import uva.ql.interpreter.typecheck.Symbol;
import uva.ql.interpreter.typecheck.SymbolMap;
import uva.ql.interpreter.typecheck.exception.IllegalTypeException;
import uva.ql.supporting.ExpressionSupporting;

public class UITextField extends UIQuestion{
	
	private JTextField textField;
	private Expression expression;
	
	public UITextField(Question _question, SymbolMap _storeTable, Subject _subject, Expression _expression) {
		super(_question, _storeTable, _subject, _expression);
		
		this.expression = _expression;
		
		this.textField = new JTextField();
		this.textField.setText(this.getValue());
		this.textField.setColumns(10);
		this.textField.setSelectionStart(0);
		this.textField.setSelectionEnd(0);
		this.textField.setEnabled(this.shouldBeEnabled());
		
		this.setDocumentListener();
		this.setFocusListener();
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
		return super.getExpression();
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
	
	private void setFocusListener(){
        this.textField.addFocusListener(new FocusListener() {
        	
			@Override
			public void focusGained(FocusEvent e) {
				textField.setSelectionEnd(0);
				textField.setSelectionStart(getValue().length());
			}

			@Override
			public void focusLost(FocusEvent e) {
				
			}
        });
	}
	
	public Component getWidget(){
		return this.textField;
	}
	
	private String getValue(){
		if (Float.valueOf(this.getExpression().evaluate().getValue().toString()) != 0)
			return String.valueOf(this.getExpression().evaluate().getValue());
		return "";
	}
	
	private void setValue(String _value){
		
		String questionType = super.getQuestionSymbol().getSymbolType();
		
		if (questionType.equals("string") && this.isNumeric(_value) && !_value.equals(""))
			throw new IllegalTypeException("IllegalTypeException: you are trying to enter different type of value");
		else {
			if (!this.isNumeric(_value) && !_value.equals(""))
				throw new IllegalTypeException("IllegalTypeException: you are trying to enter different type of value");
		}
				
		Symbol symbol = new Symbol(this.question.getType().getTypeName(), Assign.class.getName(), this.question.getCodeLines(), _value);
		Expression expression = (Expression)ExpressionSupporting.symbolObjectToLiteral(symbol);
		
		this.symbolTable.updateValue(this.getIdentifier(), expression);
		this.subject.lastResponse = this.question.getIdentifier().evaluate().getValue();
		
		super.update();
	}
	
	private boolean shouldBeEnabled(){
		if (this.expression != null)
			if (!this.expression.evaluateType().matches(".*Literal"))
				return false;
		
		return true;
	}
	
	private boolean isNumeric(String _value){
		try{
			Integer.parseInt(_value);
		}
		catch(NumberFormatException e){
			return false;
		}
		return true;
	}
}
