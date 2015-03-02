package uva.ql.interpreter.gui;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JTextField;

import uva.ql.ast.Prog;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.StringLiteral;
import uva.ql.ast.statements.Assign;
import uva.ql.interpreter.gui.elements.UIContainer;
import uva.ql.interpreter.gui.elements.UIFrame;
import uva.ql.interpreter.gui.elements.UILabel;
import uva.ql.interpreter.gui.elements.UIScrollPanel;
import uva.ql.interpreter.observer.Subject;
import uva.ql.interpreter.typecheck.Symbol;
import uva.ql.interpreter.typecheck.SymbolMap;
import uva.ql.supporting.Tuple;

public class GUI extends GUIVisitor{

	private SymbolMap symbolTable;
	public UIScrollPanel container;
	public UIFrame frame;
	private Prog prog;
	
	public GUI(SymbolMap _symbolTable, Prog _prog, Subject _subject) {
		super(_symbolTable, _prog, _subject);
		this.gui = this;
		this.prog = _prog;
		this.symbolTable = _symbolTable;
	}
	
	public void rander(){
		this.visitProg(this.prog);
	}
	
	public SymbolMap getSymbolTable(){
		return this.symbolTable;
	}
	
	public void setFrame(){
		if (this.frame == null){
			this.container = new UIScrollPanel(new Tuple<Integer, Integer>(500, 400));
			this.container.getPanel().setLayout(new GridLayout(1,1));
			
			this.frame = new UIFrame(new Tuple<Integer, Integer>(500, 400), this.container);
			this.frame.randerFrame();
		}
	}
	
	public boolean hasFocus(String identifier, Subject subject){
		return identifier == subject.lastResponse;
	}
	
	public void setFocus(String _identifier, Subject _subject, UIContainer _component){
		if (this.hasFocus(_identifier, _subject)){
			for(Component c : _component.getComponents()){
				if (!c.getClass().equals(UILabel.class)){
					if (c.getClass().equals(JTextField.class)){
						JTextField text = (JTextField)c;
						text.requestFocus();
						break;
					}
				}
			}
		}
	}
	
	public Expression expressionForQuestion(SymbolMap _symbolTable, String _identifier){
		
		Expression expression = null;
		for (Symbol symbol : _symbolTable.retrieve(_identifier)){
			if (symbol.getClassName().equals(Assign.class.getName())){
				if (!symbol.getContent().getClass().equals(StringLiteral.class)){
					expression = (Expression)this.visitExpression((Expression)symbol.getContent());
				}
			}
		}
		return expression;
	}

}
