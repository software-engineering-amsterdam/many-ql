package typechecker;

import gui.errors.ErrorCollector;
import gui.errors.TaZQLError;
import gui.errors.TaZQLWarning;

import java.util.List;
import java.util.Map;

import ast.expression.Binary;
import ast.expression.Brackets;
import ast.expression.Expression;
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
import ast.type.IntegerType;
import ast.type.Type;
import ast.unary.Minus;
import ast.unary.Not;
import ast.unary.Plus;
import ast.unary.Unary;


public class TypeCheckerVisitor implements IFormVisitor<Void>, IQuestionVisitor<Void>, IExpressionVisitor<Void>  {
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
	
	/*** Question checks ***/
	private void checkQuestion(SimpleQuestion question) {
		checkDuplicateDeclaration(question);
		checkDuplicateLabels(question);
	}
	
	// duplicate question declarations with different types
	private void checkDuplicateDeclaration(SimpleQuestion question) {
		String id = question.getQuestionId().getID();
		Type type = question.getQuestionType();
		
		  if(!this.typeRepository.empty()) {
			if (!this.typeRepository.isDeclared(id) || this.typeRepository.getValue(id).equals(type)) {
				return;
			}
			
			this.errorCollector.addError("Question declaration *" + id + "* is duplicated. "
										+ "It is used with a different type.");
		  }
	}
	
	//duplicate labels (warning)
	private void checkDuplicateLabels(SimpleQuestion question) {
		String id = question.getQuestionId().getID();
		String label = question.getQuestionText();
		
	  if(!this.typeRepository.empty()) {
					
		for(Map.Entry<String, String> entry : this.typeRepository.getLabelRepository().entrySet()) {
			String key = entry.getKey();
			String labelValue = entry.getValue();
			
			if(!labelValue.equals(label) || key.equals(id)) {
				continue;
			}
			this.errorCollector.addWarning("Warning! Duplicated label *" + labelValue + "* in question *" + key + "*.");	
		}
	  }	
	}
	
	/*** Expression checks ***/
	
	private Void checkExpression(Binary expression) {
		expression.getLeftExpression().accept(this);
		expression.getRightExpression().accept(this);
		
		checkType(expression.getLeftExpression(),expression.getType());
		checkType( expression.getRightExpression(), expression.getType());
		return null;
	}
	
	private Void checkComparisonExpression(Binary expression) {
		expression.getLeftExpression().accept(this);
		expression.getRightExpression().accept(this);
		
		checkType(expression.getLeftExpression(), new IntegerType());
		checkType(expression.getRightExpression(), new IntegerType());
		return null;
	}

	private Void checkUnaryExpression(Unary expression) {
		expression.getUnaryExpression().accept(this);
		
		checkType(expression.getUnaryExpression(), expression.getType());
		return null;
	}
	
	private void checkType(Expression expression, Type type) {
		  
		if(expression.getType().isCompatibleToType(type)) {
			return;
		}
		this.errorCollector.addError("Error. Expression *" + expression.toString() +
					   "* is of wrong type: *" + expression.getType() + 
					   "*, has to be *" +type + "*.");
		  
		if(expression.getType() == null) {
		  this.errorCollector.addError("This declaration *" + expression.toString() + "* has an undefined type.");
		}
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
		typeRepository.putType(simpleQuestion.getQuestionId().getID(), simpleQuestion.getQuestionType());
		typeRepository.putLabel(simpleQuestion.getQuestionId().getID(), simpleQuestion.getQuestionText());
		
		return null;
	}

	@Override
	public Void visit(ComputationQuestion calQuestion) {
		this.checkQuestion(calQuestion);
		
		String id = calQuestion.getQuestionId().getID();
		typeRepository.putType(id, calQuestion.getQuestionType());
		typeRepository.putLabel(id, calQuestion.getQuestionText());
		
		calQuestion.getExpression().accept(this);
		
		checkType(calQuestion.getExpression(), calQuestion.getQuestionType());
		
		return null;
	}

	@Override
	public Void visit(IfStatement ifStatement) {
		for(Question q : ifStatement.getIfStatement()) {
			q.accept(this);
		}
		
		ifStatement.getExpression().accept(this);
		Expression expression = ifStatement.getExpression();
		
		checkType(expression, expression.getType());
		
	
		return null;
	}

	@Override
	public Void visit(IfElseStatement ifElseStatement) {
		
		for(Question q : ifElseStatement.getIfStatement()) {
			q.accept(this);
		}
		
		for(Question q : ifElseStatement.getElseStatement()) {
			q.accept(this);
		}
		
		ifElseStatement.getExpression().accept(this);
		Expression expression = ifElseStatement.getExpression();
		
		checkType(expression, expression.getType());
		
		return null;
	}

	@Override
	public Void visit(Brackets expr) {
		expr.getBracketsExpression().accept(this);
		checkType(expr.getBracketsExpression(), expr.getType());
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
		return this.checkComparisonExpression(expr);
	}

	@Override
	public Void visit(GreaterThan expr) {
		return this.checkComparisonExpression(expr);
	}

	@Override
	public Void visit(LessEqual expr) {
		return this.checkComparisonExpression(expr);
	}

	@Override
	public Void visit(GreaterEqual expr) {
		return this.checkComparisonExpression(expr);
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
}
