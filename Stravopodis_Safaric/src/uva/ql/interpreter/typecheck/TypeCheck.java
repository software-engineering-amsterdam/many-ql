package uva.ql.interpreter.typecheck;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.Prog;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.StringLiteral;
import uva.ql.ast.question.Question;
import uva.ql.ast.statements.Assign;
import uva.ql.ast.visitor.StatementVisitorInterface;
import uva.ql.interpreter.typecheck.exception.IllegalTypeException;

public class TypeCheck {
	
	private SymbolMap symbolTable;
	private StatementVisitorInterface<Object> v;
	
	public TypeCheck(ASTNode ast){
		this.v = new TypeCheckVisitor();
		this.v.visitProg((Prog)ast);
		this.symbolTable = ((TypeCheckVisitor)this.v).getSymbolTable();
	}
	
	public SymbolMap getSymbolTable(){
		return this.symbolTable;
	}
	
	public static boolean withinScope(CodeLines x, CodeLines y){
		if (x == null || y == null) return false;
		return 		x.getSourceCodeLocation().x > y.getSourceCodeLocation().x 
				&& 	x.getSourceCodeLocation().y <= y.getSourceCodeLocation().y;
	}
	
	public static void hasDuplicateLabels(SymbolMap _symbols, Expression _expression){
		if (_expression.getClass().equals(StringLiteral.class) && _symbols.contentExists(_expression))
			throw new IllegalArgumentException("IllegalArgumentException: multiple question instances have same question: " 
											+ _expression.evaluate().getValue().toString());
	}
	
	public static void hasDuplicateQuestionDeclarations(SymbolMap _symbols, String _identifer, Question _question, Symbol _symbol){
		if (_symbols.existsWithClassType(_identifer, _question.getClass().getName())){
			
			if (_symbols.keyWithSymbolExists(_identifer, _symbol))
				throw new IllegalTypeException("IllegalTypeException: duplicate question with same type" + _identifer );
			else 
				throw new IllegalTypeException("IllegalTypeException: duplicate question with different type" + _identifer);	
		}
	}
	
	public static void declarationWithinQuestionScope(SymbolMap _symbols, String _identifier, Assign _assign, Symbol _symbol){
		if (_symbols.exists(_identifier)){			
			Symbol symbol = _symbols.getSymbolForAttributes(_identifier, null , Question.class.getName());
			
			if (!TypeCheck.withinScope(_assign.getCodeLines(), symbol.getCodeLines()))
				throw new IllegalArgumentException("IllegalArgumentException: question assignment not in scope of question -> " 
													+ _assign.getCodeLines().toString());
			
		}
	}
	
	public static boolean questionReferenceUndefined(SymbolMap _symbols, Identifier identifier){
		return _symbols.existsWithClassType(identifier.evaluate().getValue(), Question.class.getName());
	}
	
}
