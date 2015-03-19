package qls;

import ql.TypeEnvironment;
import ql.errorhandling.ErrorEnvironment;
import qls.ast.visitor.widgetbinder.WidgetBinder;

public class Main_Test {
	public static String qlForm = 
			"form taxOfficeExample {"
			+ 	"firstInteger: integer {"
			+ 		"\"First value:\""
			+ 	"}"
			+ 	"booleanValue: boolean {"
			+ 		"\"Second value:\""
			+ 	"}"
			+ 	"if (booleanValue || firstInteger == 10) {"
			+ 		"sellingPrice: money {"
			+ 			"\"What was the selling price?\"" 
			+ 		"}"
			+ 		"privateDebt: money {"
			+ 			"\"Private debts for the sold house:\""
			+ 		"}"
			+ 		"valueResidue: integer {"
			+ 			"\"Value residue:\""
			+ 			"assign(sellingPrice - privateDebt)"
			+ 		"}"
			+ 		"if(firstInteger == 100) {"
			+ 			"firstString: string {"
			+ 				"\"is this IF active??\""
			+ 			"}"
			+ 		"}"		
			+ 	"}"
			+  	"else {"
			+ 		"secondString: string {"
			+ 			"\"This is the else\""
			+ 		"}"
			+ 		"thirdString: integer {"
			+  			"\"This is the else second\""
			+ 		"}"
			+ 	"}"
			+ "}";
	
	public static String qlsForm = 
			"stylesheet taxOfficeExample {"
			+ 	"page First {"
			+ 		"section \"SecondSection\" {"
			+ 			"question secondString {"
			+ 				"widget text"
			+ 			"}"
			+ 			"question sellingPrice {"
			+ 				"widget text" 
			+ 			"}"
			+ 			"question privateDebt;"
			+ 			"default money widget spinbox;"
			+ 		"}"
			+ 	"}"
			+ 	"page Second {"
			+ 		"section \"SecondSection\" {"
			+ 			"question booleanValue {"
			+ 				"widget radio(\"Yes\", \"No\")"
			+ 			"}"
			+ 			"question valueResidue {"
			+ 				"widget spinbox"
			+ 			"}"
			+ 			"question firstString {"
			+ 				"widget text"
			+ 			"}"		
			+ 		"}"
			+  		"section \"SecondSection Yay\" {"
			+ 			"question firstInteger {"
			+ 				"widget spinbox"
			+ 			"}"	
			+ 			"question thirdString;"
			+ 		"}"
			+ 		"default integer widget text;"
			+ 	"}"
			+ "}";
	
	public static void main(String[] args) {
		ql.ast.Statement tree = (ql.ast.Statement) ql.parser.Parser.parse(qlForm);
		
		TypeEnvironment typeEnvironment = new TypeEnvironment();
		ErrorEnvironment errors = ql.ast.visitor.typechecker.TypeChecker.check(tree, typeEnvironment);
		
		if(errors.hasErrors()) {
			System.out.println(errors.getErrors());
		}
		
		System.out.println(typeEnvironment.getIdentifiers());
		
		qls.ast.Statement qlsTree = (qls.ast.Statement) qls.parser.Parser.parse(qlsForm);
		errors = qls.ast.visitor.typechecker.TypeChecker.check(qlsTree, typeEnvironment);
		
		if(errors.hasErrors()) {
			System.out.println(errors.getErrors());
		}
		
		WidgetBinder.bind(qlsTree, typeEnvironment);
	}
}
