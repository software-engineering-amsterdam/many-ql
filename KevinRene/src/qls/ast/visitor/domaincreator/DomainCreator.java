package qls.ast.visitor.domaincreator;

import java.util.ArrayList;
import java.util.List;

import ql.ast.Expression;
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
import ql.ast.visitor.evaluator.ValueEnvironment;
import ql.gui.Component;
import ql.gui.content.UIComputedQuestion;
import ql.gui.content.UIQuestion;
import ql.gui.structure.Label;
import qls.ast.visitor.ProcessedCache;
import qls.ast.visitor.WidgetEnvironment;
import qls.gui.widget.InputWidget;

public class DomainCreator extends StatementVisitor<Void> implements ExpressionVisitor<Component>, TypeVisitor<QLType> {
	private WidgetEnvironment widgetEnvironment;
	private ValueEnvironment valueEnvironment;
	private List<ConditionalDomain> conditionalDomains;
	private ProcessedCache<Component> processedQuestions;
	private ProcessedCache<Expression> prerequisiteExpressions;
	 
	private DomainCreator(WidgetEnvironment widgetEnvironment) {
		super.setExpressionVisitor(this);
		super.setTypeVisitor(this);
		
		this.widgetEnvironment = widgetEnvironment;
		valueEnvironment = new ValueEnvironment();
		conditionalDomains = new ArrayList<ConditionalDomain>(); 
		processedQuestions = new ProcessedCache<Component>();
		prerequisiteExpressions = new ProcessedCache<Expression>();
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
		processedQuestions = new ProcessedCache<Component>(processedQuestions);
		prerequisiteExpressions = new ProcessedCache<Expression>(prerequisiteExpressions);
	}
	
	private void increaseScope() {
		processedQuestions = processedQuestions.getParent();
		prerequisiteExpressions = prerequisiteExpressions.getParent();
	}
	
	@Override
	public Component visit(Identifier identifier) {
		return widgetEnvironment.resolve(identifier);
	}

	@Override
	public Component visit(StringLiteral stringNode) {
		return new Label(stringNode.getValue());
	}
	
	@Override
	public Void visit(If ifNode) {	
		ConditionalDomain ifDomain = new ConditionalDomain(ifNode.getExpression(), valueEnvironment);
		
		decreaseScope();
		
		ifNode.getBlock().accept(this);	
		prerequisiteExpressions.addObject(ifNode.getExpression());
		ifDomain.setIfComponent(processedQuestions.getProcessedObjects());
		increaseScope();

		ifDomain.setPrerequisites(prerequisiteExpressions.getProcessedObjects());
		conditionalDomains.add(ifDomain);
		
		return null;
	}
	
	@Override
	public Void visit(IfElse ifElseNode) {
		ConditionalDomain ifElseDomain = new ConditionalDomain(ifElseNode.getExpression(), valueEnvironment);

		decreaseScope();
		prerequisiteExpressions.addObject(ifElseNode.getExpression());
		ifElseNode.getIfBranch().accept(this);
		ifElseDomain.setIfComponent(processedQuestions.getProcessedObjects());
		increaseScope();
		
		ifElseDomain.setPrerequisites(prerequisiteExpressions.getProcessedObjects());
		
		decreaseScope();
		ifElseNode.getElseBranch().accept(this);
		ifElseDomain.setElseComponent(processedQuestions.getProcessedObjects());
		increaseScope();
		
		conditionalDomains.add(ifElseDomain);
		
		return null;
	}
	
	@Override
	public Void visit(ComputedQuestion compQuestionNode) {
		InputWidget<?> questionWidget = (InputWidget<?>) compQuestionNode.getIdentifier().accept(this);
    	Component questionText = compQuestionNode.getText().accept(this);    	
    	Component computedQuestionWidget = new UIComputedQuestion(compQuestionNode.getIdentifier(), questionText,
				questionWidget, compQuestionNode.getExpression(), valueEnvironment);
    	
    	widgetEnvironment.store(compQuestionNode.getIdentifier(), computedQuestionWidget);
    	
    	processedQuestions.addObject(computedQuestionWidget);
    	
    	return null;
	}
	
	@Override
	public Void visit(Question questionNode) {
		Component questionText = questionNode.getText().accept(this);
    	Component inputWidget = questionNode.getIdentifier().accept(this);
    	Component questionWidget = new UIQuestion(questionNode.getIdentifier(), 
    			questionText, inputWidget, valueEnvironment);
    	
    	widgetEnvironment.store(questionNode.getIdentifier(), questionWidget);
    	
    	processedQuestions.addObject(questionWidget);
    	
    	return null;
	}
}
