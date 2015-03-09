package uva.ql.interpreter.typecheck;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;
import uva.ql.ast.Prog;
import uva.ql.interpreter.typecheck.table.ErrorTable;
import uva.ql.interpreter.typecheck.table.ExpressionTable;
import uva.ql.interpreter.typecheck.table.SymbolTable;
import uva.ql.interpreter.typecheck.table.SymbolTableValue;
import uva.ql.ast.expressions.Expression;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.literals.StringLiteral;

public class TypeCheck {
	
	private SymbolTable table;
	private ErrorTable errorTable;
	private TypeCheckVisitor visitor;
	private ExpressionTable exprTable;
	
	public TypeCheck(ASTNode ast){
		this.exprTable = new ExpressionTable();
		this.errorTable = new ErrorTable();
		this.table = new SymbolTable();
		this.initTypeVisitor(ast);
	}	
	
	public ErrorTable getErrorTable(){
		return this.errorTable;
	}
	
	public SymbolTable getSymbolTable(){
		return this.table;
	}
	
	public ExpressionTable getExpressionTable(){
		return this.exprTable;
	}
	
	private void initTypeVisitor(ASTNode ast){
		this.visitor = new TypeCheckVisitor(this, this.table, this.exprTable);
		visitor.visitProg((Prog)ast);
	}
	
	public boolean isDuplicate(Identifier _identifier, SymbolTableValue _type){
		
		if (this.table.keyExists(_identifier.evaluatedValue())){
			SymbolTableValue type = this.table.retrieveValue(_identifier.evaluatedValue());
			
			return type.getPrimitiveType().equals(_type.getPrimitiveType()) 
					? this.setValuesToErrorTable("Duplicate question -> same type" , _identifier.getCodeLines())
					: this.setValuesToErrorTable("Duplicate question -> diff type" , _identifier.getCodeLines());
		}
		
		return false;
	}
	
	public boolean referenceUndefinedQuestion(Identifier _identifier){
		return this.table.keyExists(_identifier.evaluatedValue())
				? false : this.setValuesToErrorTable("Reference to undefined question", _identifier.getCodeLines());
	}
	
	public boolean hasDuplicateLabels(Identifier _identifier, Expression _expression){

		if (_expression.getClass().getName().equals(StringLiteral.class.getName()))
			return this.exprTable.expressionExists(_expression)	
						? this.setValuesToErrorTable("Duplicate question label at: " + 
							_expression.getCodeLines().getLOCTuple().toString(), _expression.getCodeLines())
						: false;
		
		return false;
	}
	
	public boolean assignmentWithinScope(Identifier _identifier){
		
		try{
			boolean withinScope = this.withinScope(_identifier.getCodeLines(), this.table.retrieveValue(_identifier.evaluatedValue()).getSourceCodeLines());
			
			return withinScope == false ? this.setValuesToErrorTable("Reference to: " + _identifier.toString() + " outside question scope", _identifier.getCodeLines())
										: true;
		}
		catch(Exception e){
			this.errorTable.putValue("Identifier: " + _identifier.evaluatedValue() + " for unknown question", _identifier.getCodeLines());
		}
		return false;
	}
	
	private boolean withinScope(CodeLines x, CodeLines y){
		if (x == null || y == null) return false;
		
		return 		x.getLOCTuple().x > y.getLOCTuple().x
				&& 	x.getLOCTuple().y <= y.getLOCTuple().y;
	}
	
	private boolean setValuesToErrorTable(String value, CodeLines codeLines){
		this.errorTable.putValue(value, codeLines);
		return true;
	}
}
