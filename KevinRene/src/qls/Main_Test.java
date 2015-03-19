package qls;

import ql.TypeEnvironment;
import ql.ast.expression.Identifier;
import ql.errorhandling.ErrorEnvironment;
import qls.ast.visitor.WidgetEnvironment;
import qls.ast.visitor.domaincreator.DomainCreator;
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
			+ 		"secondInteger: integer {"
			+  			"\"This is the else second\""
			+ 		"}"
			+ 	"}"
			+ "}";
	
	public static String qlsForm = 
			"stylesheet taxOfficeExample {"
			+ 	"page First {"
			+ 		"section \"SecondSection\" {"
			+ 			"question secondString {"
			+ 				"widget text;"
			+ 			"}"
			+ 			"question sellingPrice {"
			+ 				"widget text;" 
			+ 			"}"
			+ 			"question privateDebt;"
			+ 			"default money widget spinbox;"
			+ 		"}"
			+ 	"}"
			+ 	"page Second {"
			+ 		"section \"SecondSection\" {"
			+ 			"question booleanValue {"
			+ 				"widget radio(\"Yes\", \"No\");"
			+ 			"}"
			+			"section \"Nested\" {"
			+ 				"question valueResidue {"
			+ 					"widget spinbox;"
			+ 				"}"
			+			"}"
			+ 			"question firstString {"
			+ 				"widget text;"
			+ 			"}"
			+			"default integer { "
			+				"width : 500;"
			+ 				"widget text;"
			+			"}"
			+ 		"}"
			+  		"section \"SecondSection Yay\" {"
			+ 			"question firstInteger {"
			+ 				"widget spinbox;"
			+ 			"}"	
			+ 			"question secondInteger;"
			+ 		"}"
			+ 		"default integer widget text;"
			+ 	"}"
			+ "}";
	
	public static void main(String[] args) {
		ql.ast.Statement qlTree = (ql.ast.Statement) ql.parser.Parser.parse(qlForm);
		
		TypeEnvironment typeEnvironment = new TypeEnvironment();
		ErrorEnvironment errors = ql.ast.visitor.typechecker.TypeChecker.check(qlTree, typeEnvironment);
		
		if(errors.hasErrors()) {
			System.out.println(errors.getErrors());
		}
		
		System.out.println(typeEnvironment.getIdentifiers());
		
		qls.ast.Statement qlsTree = (qls.ast.Statement) qls.parser.Parser.parse(qlsForm);
		errors = qls.ast.visitor.typechecker.TypeChecker.check(qlsTree, typeEnvironment);
		
		if(errors.hasErrors()) {
			System.out.println(errors.getErrors());
		}
		
		WidgetEnvironment widgets = WidgetBinder.bind(qlsTree, typeEnvironment);
		
		for(Identifier identifier : widgets.getIdentifiers()) {
			System.out.println(identifier + " : " + widgets.resolve(identifier).getClass().getSimpleName());
		}
		
		DomainCreator.create(qlTree, widgets);
		
		for(Identifier identifier : widgets.getIdentifiers()) {
			System.out.println(identifier + " : " + widgets.resolve(identifier));
		}
	}
}
