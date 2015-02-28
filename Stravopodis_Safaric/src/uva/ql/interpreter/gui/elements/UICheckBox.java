package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.awt.event.ItemEvent;

import javax.swing.JCheckBox;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.BooleanLiteral;
import uva.ql.ast.question.Question;
import uva.ql.ast.statements.Assign;
import uva.ql.interpreter.observer.Observer;
import uva.ql.interpreter.observer.Subject;
import uva.ql.interpreter.typecheck.Symbol;
import uva.ql.interpreter.typecheck.SymbolMap;
import uva.ql.supporting.ExpressionSupporting;

public class UICheckBox extends UIQuestion{
	
	private JCheckBox checkBox;
	private Subject subject;
	
	public UICheckBox(Question question, Subject _subject, SymbolMap _symbolTable, String text) {
		super(question, _subject, _symbolTable);
		
		this.subject = _subject;
		this.checkBox = new JCheckBox();
		this.checkBox.setText(text);
		this.checkBox.setSelected((boolean)this.getExpression().evaluate().getValue());	
		
		this.checkBox.addItemListener(event -> checkBoxSelected(event));
	}
	
	public void setCheckBoxValue(Boolean _status) {
		this.checkBox.setSelected(_status);
	}
	
	public Component getWidget(){
		return this.checkBox;
	}
	
	private void checkBoxSelected(ItemEvent e){
		String identifier = this.getIdentifier();
		this.symbolTable.updateValue(identifier, 
				new BooleanLiteral((e.getStateChange() - 1) == 0, null));
		super.update();
	}
	@Override
	public String getIdentifier(){
		return this.question.getIdentifier().evaluate().getValue();
	}
	@Override
	public Expression getExpression(){
		Symbol s = this.symbolTable.getSymbolForAttributes(this.getIdentifier(), this.question.getType().getTypeName(), Assign.class.getName());
		
		return ExpressionSupporting.symbolAssignmentExists(s, (Symbol)super.getExpression());
	}
	@Override
	public Boolean getWidgetValue() {
		return this.checkBox.isSelected();
	}

}
