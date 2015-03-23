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
import uva.ql.ast.type.TypeBoolean;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.StatementVisitor;
import uva.ql.interpreter.gui.elements.UICheckBox;
import uva.ql.interpreter.gui.elements.UIContainer;
import uva.ql.interpreter.gui.elements.UIFrame;
import uva.ql.interpreter.gui.elements.UIScrollPanel;
import uva.ql.interpreter.gui.elements.UITextField;
import uva.ql.interpreter.gui.supporting.Size;
import uva.ql.interpreter.gui.supporting.UpdateValue;

public class Renderer implements StatementVisitor<Void>, Observer{

	private ValueTable valueTable;
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
		
		GenericValue<?> questionValue = this.valueTable.getValue(question.getQuestionIdentifierValue());
		UIContainer component = this.getQuestionComponentFor(question, questionValue);
		
		this.scrollPanel.addComponent(component);
		this.scrollPanel.revalidatePanel();
		
		this.hasFocus(question.getQuestionIdentifier(), component.getChildComponent());
		
		return null;
	}
	
	@Override
	public Void visitComputedQuestion(Question question) {
		
		GenericValue<?> questionValue = this.valueTable.getValue(question.getQuestionIdentifierValue());
		UIContainer component = this.getQuestionComponentFor(question, questionValue);
		
		this.scrollPanel.addComponent(component);
		this.scrollPanel.revalidatePanel();
		
		this.hasFocus(question.getQuestionIdentifier(), component.getChildComponent());
		
		return null;
	}
	
	private UIContainer getQuestionComponentFor(Question question, GenericValue<?> value){
		if (question.questionTypeEquals(new TypeBoolean())){
			return new UICheckBox(question, value, this).returnQuestionComponent();
		}
		else {
			return new UITextField(question, value, this).returnQuestionComponent();
		}
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
		
		UpdateValue value = (UpdateValue)arg;
		
		this.valueTable.updateValueTable(value.getIdentifier(), value.getUpdateValue());
		this.valueTable.refreshValueTable();
		
		this.scrollPanel.removeAll();
		this.scrollPanel.revalidate();
		
		this.lastFocus = value.getIdentifier();
		
		this.visitProg(this.prog);	
	}
	
	private void hasFocus(Identifier identifier, Component component){
		if (identifier.equals(lastFocus)){
			component.requestFocus();
		}
	}
}
