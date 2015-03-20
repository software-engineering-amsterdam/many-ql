package uva.qls.interpreter.typecheck;

import org.antlr.v4.runtime.tree.ParseTree;

import uva.ql.interpreter.typecheck.TypeCheckVisitor;
import uva.qls.ast.CodeLines;
import uva.qls.ast.Prog;
import uva.ql.main.Main;
import uva.qls.interpreter.typecheck.table.ErrorTable;
import uva.qls.interpreter.typecheck.table.SymbolTable;
import uva.ql.ast.ASTNode;
import uva.qls.ast.literal.*;
import uva.qls.ast.statements.DefaultValue;
import uva.qls.ast.statements.Question;
import uva.qls.interpreter.typecheck.TypeCheckVisitorQLS;
import uva.ql.supporting.*;

public class TypeCheckQLS {
	
	private SymbolTable table;
	private TypeCheckVisitor typeCheckQL;
	private ErrorTable errorTable;
	private TypeCheckVisitorQLS visitor;
	
	public TypeCheckQLS(uva.qls.ast.ASTNode _ast){
		this.errorTable = new ErrorTable();
		this.table = new SymbolTable();
		
		this.initTypeCheckQL();
		this.startTypeVisitor(_ast);
		this.allQuestionsDefined();
	}
	
	public TypeCheckVisitor getTypeCheckQL(){
		return this.typeCheckQL;
	}
	
	public SymbolTable getSymbolTable(){
		return this.table;
	}
	
	public ErrorTable getErrorTable(){
		return this.errorTable;
	}
	
	private void initTypeCheckQL(){
		
		try{
			ParseTree tree = Main.getParseTree("SupportingFiles/Test.ql");
			ASTNode ast = Main.getAST(tree);
			this.typeCheckQL = Main.getTypeCheck(ast);
		}
		catch (Exception ex){
			System.out.println("save to the error table: " + ex.getMessage());
		}
		
	}
	
	private void startTypeVisitor(uva.qls.ast.ASTNode _ast){
		this.visitor = new TypeCheckVisitorQLS(this, this.table);
		visitor.visitProg((Prog) _ast);
	}
	
	public boolean hasErrors(){
		return this.errorTable.getTable().values().size() != 0;
	}
	
	public boolean isMultiple (Identifier _identifier){
		return 	this.table.keyExists(_identifier)
				? this.setValuesToErrorTable("Multiple references to same question" , _identifier.getLOC())			
				: false;
	}
	
	public boolean correctWidget(String _type, String _evaltype, CodeLines _lines){
		return 	((_type).equals(_evaltype))
				? false
				: this.setValuesToErrorTable("Wrong widget selection" , _lines);
			
	}
	
	public boolean isUndefined (Identifier _identifier) {
		return	this.typeCheckQL.getSymbolTable().keyExists(_identifier.evaluatedValue())
				? false	
				: this.setValuesToErrorTable("Question is not defined in both QL & QLS", _identifier.getLOC());
	}
	
	
	public boolean allQuestionsDefined(){

		for (String key : this.typeCheckQL.getSymbolTable().getTable().keySet()){
			
			if (!this.table.keyExists(new Identifier(key, null))){
				
				try{
					this.typeCheckQL.getSymbolTable().retrieveValue(key).getPrimitiveType();
					
					Tuple<Integer, Integer> locs = this.typeCheckQL.getSymbolTable().retrieveValue(key).getSourceCodeLines().getLOCTuple();
					
					this.setValuesToErrorTable("Question of QL not defined: " + key, new CodeLines(locs.x, locs.y));
				}
				catch (Exception ex){
					System.out.println("Primitive type for: " + key + " could not be found");
				}
			}
		}
		
		return true;
	}
	
	public boolean isCompatibleDefaultValue(DefaultValue value, String type, String componentName){
		return 	isCompatible(type, componentName)
				? true
				: this.setValuesToErrorTable("Default value not compatible type: " + value.toString(), value.getLOC());
	}
	
	public boolean isCompatibleQuestionType(Question question, String type, String componentName){
		
		return 	isCompatible(type, componentName) 
				? true
				: this.setValuesToErrorTable("Question not compatible with type: " + 	question.getIdentifier().evaluatedValue(), 
																						question.getLOC());
	}
	
	private boolean isCompatible(String type, String componentName){
		for (CheckWidget w : CheckWidget.detectTypes(type)){
			if (w.getName().equals(componentName)){
				return true;
			}
		}
		return false;
	}
	
	public boolean setValuesToErrorTable(String value, CodeLines codeLines){
		this.errorTable.putValue(value, codeLines);
		return true;
	}
}