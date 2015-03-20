package qls.ast.visitor.domaincreator;

import java.util.ArrayList;
import java.util.List;

import ql.ValueEnvironment;
import ql.ast.QLType;
import ql.ast.Statement;
import ql.ast.expression.Identifier;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.statement.ComputedQuestion;
import ql.ast.statement.If;
import ql.ast.statement.IfElse;
import ql.ast.statement.Question;
import ql.ast.visitor.ExpressionVisitor;
import ql.ast.visitor.StatementVisitor;
import ql.ast.visitor.TypeVisitor;
import ql.gui.UIComponent;
import ql.gui.content.UIComputedQuestion;
import ql.gui.content.UIQuestion;
import ql.gui.structure.Label;
import qls.ast.visitor.WidgetEnvironment;
import qls.gui.widget.InputWidget;

public class DomainCreator extends StatementVisitor<Void> implements ExpressionVisitor<UIComponent>, TypeVisitor<QLType> {
	private WidgetEnvironment widgetEnvironment;
	private ValueEnvironment valueEnvironment;
	private List<ConditionalDomain> conditionalDomains;
	private ProcessedQuestions processedQuestions;
	 
	private DomainCreator(WidgetEnvironment widgetEnvironment) {
		super.setExpressionVisitor(this);
		super.setTypeVisitor(this);
		
		this.widgetEnvironment = widgetEnvironment;
		valueEnvironment = new ValueEnvironment();
		conditionalDomains = new ArrayList<ConditionalDomain>(); 
		processedQuestions = new ProcessedQuestions();
	}

	public static List<ConditionalDomain> create(Statement tree, WidgetEnvironment widgetEnvironment) {
		DomainCreator domainCreator = new DomainCreator(widgetEnvironment);
				
		tree.accept(domainCreator);
		
		return domainCreator.getDomains();
	}
	
	public List<ConditionalDomain> getDomains() {
		return conditionalDomains;
	}
	
	private void decreaseScope() {
		processedQuestions = new ProcessedQuestions(processedQuestions);
	}
	
	private void increaseScope() {
		processedQuestions = processedQuestions.getParent();
	}
	
	@Override
	public UIComponent visit(Identifier identifier) {
		return widgetEnvironment.resolve(identifier);
	}

	@Override
	public UIComponent visit(StringLiteral stringNode) {
		return new Label(stringNode.getValue());
	}
	
	@Override
	public Void visit(If ifNode) {	
		ConditionalDomain ifDomain = new ConditionalDomain(ifNode.getExpression(), valueEnvironment);
		
		decreaseScope();
		ifNode.getBlock().accept(this);		
		ifDomain.setIfComponent(processedQuestions.getProcessedQuestions());
		increaseScope();
		
		conditionalDomains.add(ifDomain);
		
		return null;
	}
	
	@Override
	public Void visit(IfElse ifElseNode) {
		ConditionalDomain ifElseDomain = new ConditionalDomain(ifElseNode.getExpression(), valueEnvironment);

		decreaseScope();
		ifElseNode.getIfBranch().accept(this);
		ifElseDomain.setIfComponent(processedQuestions.getProcessedQuestions());
		increaseScope();
		
		decreaseScope();
		ifElseNode.getElseBranch().accept(this);
		ifElseDomain.setElseComponent(processedQuestions.getProcessedQuestions());
		increaseScope();
		
		conditionalDomains.add(ifElseDomain);
		
		return null;
	}
	
	@Override
	public Void visit(ComputedQuestion compQuestionNode) {
		InputWidget<?> questionWidget = (InputWidget<?>) compQuestionNode.getIdentifier().accept(this);
    	UIComponent questionText = compQuestionNode.getText().accept(this);    	
    	UIComponent computedQuestionWidget = new UIComputedQuestion(compQuestionNode.getIdentifier(), questionText,
				questionWidget, compQuestionNode.getExpression(), valueEnvironment);
    	
    	widgetEnvironment.store(compQuestionNode.getIdentifier(), computedQuestionWidget);
    	
    	processedQuestions.addQuestion(computedQuestionWidget);
    	
    	return null;
	}
	
	@Override
	public Void visit(Question questionNode) {
		UIComponent questionText = questionNode.getText().accept(this);
    	UIComponent inputWidget = questionNode.getIdentifier().accept(this);
    	UIComponent questionWidget = new UIQuestion(questionNode.getIdentifier(), 
    			questionText, inputWidget, valueEnvironment);
    	
    	widgetEnvironment.store(questionNode.getIdentifier(), questionWidget);
    	
    	processedQuestions.addQuestion(questionWidget);
    	
    	return null;
	}
}