package uva.ql.interpreter.gui.elements;

import java.awt.Component;
import java.awt.event.ItemEvent;

import javax.swing.JCheckBox;

import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.BooleanLiteral;
import uva.ql.ast.question.Question;
import uva.ql.interpreter.observer.Subject;
import uva.ql.interpreter.typecheck.SymbolMap;

public class UICheckBox extends UIQuestion{
	
	private JCheckBox checkBox;
	
	public UICheckBox(Question _question, SymbolMap _symbolTable, Subject _subject, Expression _expression) {
		super(_question, _symbolTable, _subject, _expression);
		
		this.checkBox = new JCheckBox();
		this.checkBox.setText("yes");
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
		this.symbolTable.updateValue(this.getIdentifier(), 
				new BooleanLiteral((e.getStateChange() - 1) == 0, this.question.getCodeLines()));
		
		this.subject.lastResponse = this.question.getIdentifier().evaluate().getValue();
		super.update();
	}
	
	@Override
	public String getIdentifier(){
		return this.question.getIdentifier().evaluate().getValue();
	}
	
	@Override
	public Expression getExpression(){
		return super.getExpression();
	}
	
	@Override
	public Boolean getWidgetValue() {
		return this.checkBox.isSelected();
	}

}
