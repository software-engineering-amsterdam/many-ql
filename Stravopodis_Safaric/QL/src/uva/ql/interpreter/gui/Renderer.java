package uva.ql.interpreter.gui;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import uva.ql.ast.ASTNode;
import uva.ql.ast.Form;
import uva.ql.ast.Prog;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.tablevisitor.ValueTable;
import uva.ql.ast.statements.Assign;
import uva.ql.ast.statements.IfStatement;
import uva.ql.ast.statements.Question;
import uva.ql.ast.statements.Statement;
import uva.ql.ast.value.GenericValue;
import uva.ql.ast.visitor.StatementVisitor;
import uva.ql.interpreter.gui.elements.UIFrame;
import uva.ql.interpreter.gui.elements.UIScrollPanel;
import uva.ql.interpreter.gui.elements.UIWidget;
import uva.ql.interpreter.gui.supporting.Size;
import uva.ql.interpreter.gui.supporting.UpdateValue;

public class Renderer implements StatementVisitor<Void>, Observer{

	private UIScrollPanel scrollPanel;
	private ValueTable valueTable;
	private Identifier lastFocus;
	private JFrame frame;
	private Prog prog;
	
	public Renderer(Prog prog){
		this.prog = prog;
		this.valueTable = new ValueTable(prog);
		this.setFrame();
	}
	
	private void setFrame(){
		if (this.frame == null){
			this.scrollPanel = new UIScrollPanel();
			
			this.frame = new UIFrame().randerFrame(new Size(500,400));
			this.frame.add(this.scrollPanel.randerScrollPane(new Size(500,400)));
			this.frame.revalidate();
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
		this.randerQuestion(question);
		return null;
	}
	
	@Override
	public Void visitComputedQuestion(Question question) {
		this.randerQuestion(question);
		return null;
	}
	
	private void randerQuestion(Question question){
		
		Identifier id = question.getQuestionIdentifier();
		String identifier = question.getQuestionIdentifierValue();
		
		GenericValue<?> value = this.valueTable.getValue(identifier);
		
		UIWidget widget = new UIWidget(question, value, this);
		
		this.scrollPanel.addComponent(widget.randerUIWidget());
		this.scrollPanel.revalidateMasterPanel();
		
		widget.requestFocus(this.hasFocus(id));
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
		this.scrollPanel.revalidateLayout();
		
		this.lastFocus = value.getIdentifier();
		
		this.visitProg(this.prog);	
	}
	
	private boolean hasFocus(Identifier identifier){
		return identifier.equals(lastFocus);
	}
}
