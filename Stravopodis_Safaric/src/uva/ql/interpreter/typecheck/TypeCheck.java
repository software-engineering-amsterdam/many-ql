package uva.ql.interpreter.typecheck;

import uva.ql.ast.ASTNode;
import uva.ql.ast.Prog;
import uva.ql.ast.visitor.StatementVisitorInterface;

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
	
	public void printSymbolTable(){
		for (String s : this.symbolTable.getAllKeys()){
			for (Symbol symbol : this.symbolTable.retrieve(s)){
				System.out.println("SYMBOLTABLE -> " + s + " - " + symbol.toString());
			}
		}
	}
}
