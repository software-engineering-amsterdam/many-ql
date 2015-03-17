package typechecker;

import java.util.List;

import typechecker.elements.ExpressionChecker;
import typechecker.elements.QuestionChecker;
import typechecker.errors.ErrorCollector;
import typechecker.errors.TaZQLError;
import typechecker.errors.TaZQLWarning;
import ast.expression.Binary;
import ast.expression.Brackets;
import ast.expression.IExpressionVisitor;
import ast.expression.arithmetic.Addition;
import ast.expression.arithmetic.Division;
import ast.expression.arithmetic.Multiplication;
import ast.expression.arithmetic.Substraction;
import ast.expression.comparison.Equal;
import ast.expression.comparison.GreaterEqual;
import ast.expression.comparison.GreaterThan;
import ast.expression.comparison.LessEqual;
import ast.expression.comparison.LessThan;
import ast.expression.comparison.NotEqual;
import ast.expression.logical.And;
import ast.expression.logical.Or;
import ast.expression.variables.BooleanVariable;
import ast.expression.variables.Id;
import ast.expression.variables.IntegerVariable;
import ast.expression.variables.StringVariable;
import ast.form.Form;
import ast.form.IFormVisitor;
import ast.question.ComputationQuestion;
import ast.question.IQuestionVisitor;
import ast.question.IfElseStatement;
import ast.question.IfStatement;
import ast.question.Question;
import ast.question.SimpleQuestion;
import ast.type.ChoiceType;
import ast.type.ITypeVisitor;
import ast.type.IntegerType;
import ast.type.TextType;
import ast.type.UndefinedType;
import ast.unary.Minus;
import ast.unary.Not;
import ast.unary.Plus;
import ast.unary.Unary;

/*
The type checker detects:
    + reference to undefined questions
    + duplicate question declarations with different types
      conditions that are not of the type boolean
    + operands of invalid type to operators 
      cyclic dependencies between questions
    + duplicate labels (warning)
 */
public class TypeCheckerVisitor implements IFormVisitor<Void>, IQuestionVisitor<Void>, IExpressionVisitor<Void> , ITypeVisitor<Void> {
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
	
	
	public Void checkExpression(Binary expression) {
		expression.getLeftExpression().accept(this);
		expression.getRightExpression().accept(this);
		
		ExpressionChecker expressionCheckerLeft = new ExpressionChecker(this.errorCollector,
																		this.typeRepository,
																		expression.getLeftExpression());
		ExpressionChecker expressionCheckerRight = new ExpressionChecker(this.errorCollector,
																		 this.typeRepository,
																		 expression.getRightExpression());

		expressionCheckerLeft.checkType(expression.getType());
		expressionCheckerRight.checkType(expression.getType());
		return null;
	}
	
	public Void checkUnaryExpression(Unary expression) {
		expression.getUnaryExpression().accept(this);
		
		ExpressionChecker expressionChecker = new ExpressionChecker(this.errorCollector,
																		this.typeRepository,
																		expression.getUnaryExpression());
		
		expressionChecker.checkType(expression.getType());
		return null;
	}
	
	
	/*** Visitors ***/
	
	@Override
	public Void visit(Form form) {
		for(Question q : form.getQuestionText())
			q.accept(this);
		return null;
	}
	
	@Override
	public Void visit(Id identifier) {
		String id = identifier.getID();
		
		if(!this.typeRepository.isDeclared(id)) {
			this.errorCollector.addError("Error: reference to undefined question *" + id + "*."); 
		}
		return null;
	}


	@Override
	public Void visit(SimpleQuestion simpleQuestion) {
		this.checkQuestion(simpleQuestion);
		typeRepository.putID(simpleQuestion.getQuestionId().getID(), simpleQuestion.getQuestionType());
		typeRepository.putIDLabel(simpleQuestion.getQuestionId().getID(), simpleQuestion.getQuestionText());
		
		return null;
	}

	@Override
	public Void visit(ComputationQuestion calQuestion) {
		this.checkQuestion(calQuestion);
		calQuestion.getExpression().accept(this);
		
		typeRepository.putID(calQuestion.getQuestionId().getID(), calQuestion.getQuestionType());
		typeRepository.putIDLabel(calQuestion.getQuestionId().getID(), calQuestion.getQuestionText());
		
		ExpressionChecker expressionChecker = new ExpressionChecker(this.errorCollector,
																	this.typeRepository,
																	calQuestion.getExpression());

		expressionChecker.checkType(calQuestion.getQuestionType());
		
		return null;
	}

	@Override
	public Void visit(IfStatement ifStatement) {
	//	ifStatement.getExpression().accept(this);
		for(Question q : ifStatement.getIfStatement()) {
			q.accept(this);
		}
	
		return null;
	}

	@Override
	public Void visit(IfElseStatement ifElseStatement) {
		//ifElseStatement.getExpression().accept(this);
		
		for(Question q : ifElseStatement.getIfStatement()) {
			q.accept(this);
		}
		
		for(Question q : ifElseStatement.getElseStatement()) {
			q.accept(this);
		}
		
		return null;
	}

	@Override
	public Void visit(Brackets expr) {
		//return this.checkExpression(expr);
		return null;
	}

	@Override
	public Void visit(Multiplication expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(Division expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(Addition expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(Substraction expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(Equal expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(NotEqual expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(LessThan expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(GreaterThan expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(LessEqual expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(GreaterEqual expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(Not expr) {
		return this.checkUnaryExpression(expr);
	}

	@Override
	public Void visit(Plus expr) {
		return this.checkUnaryExpression(expr);
	}

	@Override
	public Void visit(Minus expr) {
		return this.checkUnaryExpression(expr);
	}

	@Override
	public Void visit(And expr) {
		return this.checkExpression(expr);
	}

	@Override
	public Void visit(Or expr) {
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
	public Void visit(TextType type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void visit(IntegerType type) {
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
