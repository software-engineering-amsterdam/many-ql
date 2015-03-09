package typechecker;

import java.util.List;

import typechecker.elements.ExpressionChecker;
import typechecker.elements.QuestionChecker;
import typechecker.errors.ErrorCollector;
import typechecker.errors.TaZQLError;
import typechecker.errors.TaZQLWarning;
import ast.expression.BinaryExpression;
import ast.expression.BracketsExpression;
import ast.expression.arithmetic.AdditionExpression;
import ast.expression.arithmetic.DivisionExpression;
import ast.expression.arithmetic.MultiplicationExpression;
import ast.expression.arithmetic.SubstractionExpression;
import ast.expression.comparison.EqualExpression;
import ast.expression.comparison.GreaterEqualExpression;
import ast.expression.comparison.GreaterThanExpression;
import ast.expression.comparison.LessEqualExpression;
import ast.expression.comparison.LessThanExpression;
import ast.expression.comparison.NotEqualExpression;
import ast.expression.logical.AndExpression;
import ast.expression.logical.OrExpression;
import ast.expression.variables.BooleanVariable;
import ast.expression.variables.Id;
import ast.expression.variables.IntegerVariable;
import ast.expression.variables.StringVariable;
import ast.form.Form;
import ast.form.IFormVisitor;
import ast.question.ComputationQuestion;
import ast.question.IfElseStatement;
import ast.question.IfStatement;
import ast.question.Question;
import ast.question.SimpleQuestion;
import ast.type.ChoiceType;
import ast.type.DigitsType;
import ast.type.TextType;
import ast.type.UndefinedType;
import ast.unary.MinusExpression;
import ast.unary.NotExpression;
import ast.unary.PlusExpression;
import ast.unary.UnaryExpression;

/*
The type checker detects:
      reference to undefined questions
    + duplicate question declarations with different types
      conditions that are not of the type boolean
    + operands of invalid type to operators 
      cyclic dependencies between questions
    + duplicate labels (warning)
 */
public class TypeCheckerVisitor implements IFormVisitor<Void> {
	private final ErrorCollector errorCollector;
	private final TypeRepository typeRepository;
	
	public TypeCheckerVisitor() {
		this.errorCollector = new ErrorCollector();
		this.typeRepository = new TypeRepository();
	}
	
	public List<TaZQLError> getError() {
		return this.errorCollector.getErrorCollection();
	}
	
	public List<TaZQLWarning> getWarning() {
		return this.errorCollector.getWarningCollection();
	}

	public boolean isCorrect() {
		return !this.errorCollector.containsError();
	}
	
	
	public void checkQuestion(SimpleQuestion question) {
		QuestionChecker questionChecker = new QuestionChecker(question.getQuestionId().getID(),
															  question.getQuestionText(),
															  question.getQuestionType(),
															  this.errorCollector, this.typeRepository);
		questionChecker.checkDuplicateDeclaration();
		questionChecker.checkDuplicateLabels();
	}
	
	
	public Void checkExpression(BinaryExpression expression) {
		expression.getLeftExpression().accept(this);
		expression.getRightExpression().accept(this);
		
		ExpressionChecker expressionCheckerLeft = new ExpressionChecker(this.errorCollector,
																		this.typeRepository,
																		expression.getLeftExpression());
		ExpressionChecker expressionCheckerRight = new ExpressionChecker(this.errorCollector,
																		 this.typeRepository,
																		 expression.getRightExpression());

		expressionCheckerLeft.checkType(expression.getExpressionType());
		expressionCheckerRight.checkType(expression.getExpressionType());
		return null;
	}
	
	public Void checkUnaryExpression(UnaryExpression expression) {
		expression.getUnaryExpression().accept(this);
		
		ExpressionChecker expressionChecker = new ExpressionChecker(this.errorCollector,
																		this.typeRepository,
																		expression.getUnaryExpression());
		
		expressionChecker.checkType(expression.getExpressionType());
		return null;
	}
	
	
	/*** Visitors ***/
	
	@Override
	public Void visit(Form form) {
		for(Question q : form.getQuestionText())
			q.accept(this);
		
		//Test
		this.errorCollector.addError("Testing my awesome JDialog and arraylist");
		
		return null;
	}

	@Override
	public Void visit(Question question) {
		return null;
	}

	@Override
	public Void visit(SimpleQuestion simpleQuestion) {
		this.checkQuestion(simpleQuestion);
		typeRepository.putID(simpleQuestion.getQuestionId().getID(), simpleQuestion.getQuestionType());
		typeRepository.putIDLabel(simpleQuestion.getQuestionId().getID(), simpleQuestion.getQuestionText());
		
		System.out.println("typerep: " + this.typeRepository.getTypeRepository());
		
		return null;
	}

	@Override
	public Void visit(ComputationQuestion calQuestion) {
		this.checkQuestion(calQuestion);
		calQuestion.getExpression().accept(this);
		
		typeRepository.putID(calQuestion.getQuestionId().getID(), calQuestion.getQuestionType());
		typeRepository.putIDLabel(calQuestion.getQuestionId().getID(), calQuestion.getQuestionText());
		
		System.out.println("typerep2: " + this.typeRepository.getTypeRepository());
		
		ExpressionChecker expressionChecker = new ExpressionChecker(this.errorCollector,
																	this.typeRepository,
																	calQuestion.getExpression());

		expressionChecker.checkType(calQuestion.getQuestionType());
		
		return null;
	}

	@Override
	public Void visit(IfStatement ifStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IfElseStatement ifElseStatement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(BracketsExpression expr) {
		return this.checkUnaryExpression(expr);
	}

	@Override
	public Void visit(MultiplicationExpression expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(DivisionExpression expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(AdditionExpression expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(SubstractionExpression expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(EqualExpression expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(NotEqualExpression expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(LessThanExpression expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(GreaterThanExpression expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(LessEqualExpression expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(GreaterEqualExpression expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(NotExpression expr) {
		return this.checkUnaryExpression(expr);
	}

	@Override
	public Void visit(PlusExpression expr) {
		return this.checkUnaryExpression(expr);
	}

	@Override
	public Void visit(MinusExpression expr) {
		return this.checkUnaryExpression(expr);
	}

	@Override
	public Void visit(AndExpression expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(OrExpression expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(StringVariable string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IntegerVariable integer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(BooleanVariable bool) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(Id identifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(TextType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(DigitsType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(ChoiceType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(UndefinedType type) {
		// TODO Auto-generated method stub
		return null;
	}
}
