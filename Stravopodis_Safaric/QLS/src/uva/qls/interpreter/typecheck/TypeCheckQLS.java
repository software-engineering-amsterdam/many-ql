package uva.qls.interpreter.typecheck;


import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;

import uva.ql.interpreter.typecheck.TypeCheck;
import uva.ql.parser.QLLexer;
import uva.ql.parser.QLMainVisitor;
import uva.ql.parser.QLParser;
import uva.qls.interpreter.typecheck.table.SymbolTableValue;
import uva.qls.ast.CodeLines;
import uva.qls.ast.Prog;
import uva.qls.interpreter.typecheck.table.ErrorTable;
import uva.qls.interpreter.typecheck.table.SymbolTable;
import uva.ql.ast.ASTNode;
import uva.qls.ast.literal.Identifier;
import uva.qls.interpreter.typecheck.TypeCheckVisitor;
public class TypeCheckQLS {
	
	
	private SymbolTable table;
	private ErrorTable errorTable;
	private TypeCheckVisitor visitor;
	private TypeCheck typeCheck;
	
	public TypeCheckQLS(uva.qls.ast.ASTNode _ast){
		this.errorTable = new ErrorTable();
		this.table = new SymbolTable();
		this.startTypeVisitor(_ast);
		this.typeCheck.getSymbolTable();
	}
	
	public static void main(String[] args) throws IOException{
	ANTLRInputStream inputStream = new ANTLRInputStream(new FileInputStream("/SupportingFiles/Test.ql"));
	QLLexer lexer = new QLLexer(inputStream);
	
	CommonTokenStream stream = new CommonTokenStream(lexer);
	QLParser parser = new QLParser(stream);
	ParseTree tree = parser.prog();
	
	QLMainVisitor visit = new QLMainVisitor();
	ASTNode ast = visit.visit(tree);
	TypeCheck typeCheck = new TypeCheck(ast);
	}
	
	
	public ErrorTable getErrorTable(){
		return this.errorTable;
	}
	
	public SymbolTable getSymbolTable(){
		return this.table;
	}
	
	private void startTypeVisitor(uva.qls.ast.ASTNode _ast){
		this.visitor = new TypeCheckVisitor(this, this.table);
		visitor.visitProg((Prog) _ast);
	}
	
	public boolean isMultiple (Identifier _identifier){
		
		
		
		return this.table.keyExists(_identifier)
				? this.setValuesToErrorTable("Multiple references to same question" , _identifier.getLOC())			
				:false;
	}
	public boolean correctWidget(String _type, String _evaltype, CodeLines _lines){
		return ((_type).equals(_evaltype))
			? false
			: this.setValuesToErrorTable("Wrong widget selection" , _lines);
			
	}
	public boolean isUndefined (Identifier _identifier) {
		return this.table.keyExists(_identifier)
				?false: this.setValuesToErrorTable("Question is not defined in both QL & QLS", _identifier.getLOC());
	}
	public boolean setValuesToErrorTable(String value, CodeLines codeLines){
		this.errorTable.putValue(value, codeLines);
		return true;
	}
}