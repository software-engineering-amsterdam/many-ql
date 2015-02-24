package uva.ql.interpreter.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import uva.ql.ast.ASTNode;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.expressions.literals.StringLiteral;
import uva.ql.ast.question.Question;
import uva.ql.ast.statements.Assign;
import uva.ql.ast.statements.IfStatement;
import uva.ql.ast.statements.Statement;
import uva.ql.ast.visitor.StatementVisitorInterface;
import uva.ql.interpreter.gui.elements.UIContainer;
import uva.ql.interpreter.gui.elements.UIFrame;
import uva.ql.interpreter.typecheck.Symbol;
import uva.ql.interpreter.typecheck.SymbolMap;
import uva.ql.supporting.Tuple;
import uva.ql.interpreter.gui.elements.*;

public class GUIVisitor implements StatementVisitorInterface<Object>{

	public SymbolMap symbolTable;
	private UIContainer container;
	private UIFrame frame;
	private int x;
	
	public GUIVisitor(SymbolMap _symbolTable){
		this.symbolTable = _symbolTable;
	}
	
	@Override
	public Object visitProg(Prog prog) {
		
		this.visitForm(prog.getForm());
		
		
		return null;
	}

	@Override
	public Object visitForm(Form form) {
		
		this.frame = new UIFrame("Questions", new Tuple<Integer, Integer>(600,300));
		this.frame.randerFrame();
		
		this.container = new UIContainer(this.frame.getFrameSize());
		this.container.setLayout(new GridLayout(6,0));
		this.frame.add(this.container);
		this.frame.revalidate();
		
		
		for (Statement s : form.getStatement()){
			s.accept(this);
		}
		
		return null;
	}

	@Override
	public Object visitASTNode(ASTNode node) {
		return null;
	}

	@Override
	public Object visitStatement(Statement statement) {
		return statement.accept(this);
	}

	@Override
	public Object visitQuestion(Question question) {		
		
		// create a container
		// create an object
		// place the object
		
		String identifier = question.getIdentifier().evaluate().getValue();
		String questionText = "";
		
		for (Symbol s : symbolTable.retrieve(identifier)){
			if (s.getClassName().equals(Assign.class.getName()) && s.getSymbolType().equals("string")){
				questionText = ((StringLiteral)s.getContent()).evaluate().getValue();
			}
		}
		
		this.container.add((new UIElement(question, questionText)).createElement());
		this.frame.revalidate();
		
		for (Statement s : question.getStatement()){
			s.accept(this);
		}
		
		System.out.println("Question");
		
		return question;
	}

	@Override
	public Object visitIfStatement(IfStatement ifStatement) {
		System.out.println(ifStatement.getExpression().evaluate().getValue());
		if ((boolean)ifStatement.getExpression().evaluate().getValue() == true){
			System.out.println("Have to go inside of if");
			for (Statement statement : ifStatement.getStatement()){
				statement.accept(this);
			}
		}
		else {
			System.out.println("I'm not going inside of if");
		}
		
		return ifStatement;
	}

	@Override
	public Object visitAssign(Assign assign) {
		// TODO Auto-generated method stub
		return assign;
	}

}
