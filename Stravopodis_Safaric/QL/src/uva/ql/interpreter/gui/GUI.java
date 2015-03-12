package uva.ql.interpreter.gui;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JTextField;

import uva.ql.ast.Prog;
import uva.ql.interpreter.gui.elements.UIContainer;
import uva.ql.interpreter.gui.elements.UIFrame;
import uva.ql.interpreter.gui.elements.UILabel;
import uva.ql.interpreter.gui.elements.UIScrollPanel;
import uva.ql.interpreter.observer.Subject;
import uva.ql.interpreter.typecheck.table.ExpressionTable;
import uva.ql.interpreter.typecheck.table.SymbolTable;
import uva.ql.supporting.Tuple;

public class GUI extends GUIVisitor{

	private SymbolTable symbolTable;
	public UIScrollPanel container;
	public UIFrame frame;
	private Prog prog;
	
	public GUI(SymbolTable _symbolTable, ExpressionTable _expressionTable, Prog _prog, Subject _subject) {
		super(_symbolTable, _expressionTable, _prog, _subject);
		this.gui = this;
		this.prog = _prog;
		this.symbolTable = _symbolTable;
	}
	
	public void rander(){
		this.visitProg(this.prog);
	}
	
	public SymbolTable getSymbolTable(){
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
}
