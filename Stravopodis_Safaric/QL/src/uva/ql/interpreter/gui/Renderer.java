package uva.ql.interpreter.gui;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import uva.ql.ast.ASTNode;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.tablevisitor.ValueTable;
import uva.ql.ast.statements.Assign;
import uva.ql.ast.statements.IfStatement;
import uva.ql.ast.statements.Question;
import uva.ql.ast.statements.Statement;
import uva.ql.ast.visitor.StatementVisitor;
import uva.ql.interpreter.gui.elements.Size;
import uva.ql.interpreter.gui.elements.UIContainer;
import uva.ql.interpreter.gui.elements.UIFrame;
import uva.ql.interpreter.gui.elements.UIQuestion;
import uva.ql.interpreter.gui.elements.UIScrollPanel;

public class Renderer implements StatementVisitor<Void>, Observer{

	private final ValueTable valueTable;
	private UIScrollPanel scrollPanel;
	private Identifier lastFocus;
	private UIFrame frame;
	private Prog prog;
	
	public Renderer(Prog prog){
		this.prog = prog;
		this.valueTable = new ValueTable(prog);
		this.setFrame();
	}
	
	private void setFrame(){
		if (this.frame == null){
			this.scrollPanel = new UIScrollPanel(new Size(500, 400));
			this.scrollPanel.getPanel().setLayout(new GridLayout(1,1));
			
			this.frame = new UIFrame(new Size(500,400), this.scrollPanel);
			this.frame.randerFrame();
		}
	}
	
	@Override
	public Void visitProg(Prog prog) {
		prog.getForm().accept(this);
		return null;
	}

	@Override
	public Void visitForm(Form form) {
		for (Statement statement : form.getStatement()){
			statement.accept(this);
		}
		return null;
	}

	@Override
	public Void visitASTNode(ASTNode node) {
		return null;
	}

	@Override
	public Void visitStatement(Statement statement) {
		statement.accept(this);
		return null;
	}

	@Override
	public Void visitSimpleQuestion(Question question) {
			
		UIQuestion _question = new UIQuestion(question, this.valueTable, this);
		UIContainer component = _question.returnQuestionElement();
		
		this.scrollPanel.addComponent(component);
		this.scrollPanel.revalidatePanel();
		
		this.hasFocus(question.getQuestionIdentifier(), component.getChildComponent());
		
		return null;
	}

	@Override
	public Void visitComputedQuestion(Question question) {
		
		UIQuestion _question = new UIQuestion(question, this.valueTable, this);
		UIContainer component = _question.returnQuestionElement();
		
		this.scrollPanel.addComponent(component);
		this.scrollPanel.revalidatePanel();
		
		this.hasFocus(question.getQuestionIdentifier(), component.getChildComponent());
		
		return null;
	}

	@Override
	public Void visitIfStatement(IfStatement ifStatement) {
		boolean conditionIsTrue = this.valueTable.conditionalExpression(ifStatement.getExpression());
		
		if (conditionIsTrue){
			for (Statement statement : ifStatement.getStatement()){
				statement.accept(this);
			}
		}
		
		return null;
	}

	@Override
	public Void visitAssign(Assign assign) {
		return null;
	}

	@Override
	public void update(Observable o, Object arg) {
		this.valueTable.updateValueTable();
		this.scrollPanel.removeAll();
		this.scrollPanel.revalidate();
		this.lastFocus = (Identifier)arg;
		this.visitProg(this.prog);	
	}
	
	private void hasFocus(Identifier identifier, Component component){
		if (identifier.equals(this.lastFocus)){
			System.out.println("has focus: " + identifier + " " + component);
			component.requestFocus();
		}
	}
}
