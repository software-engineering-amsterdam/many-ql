package qls;

import java.util.List;

import javax.swing.JFrame;

import ql.TypeEnvironment;
import ql.ast.expression.Identifier;
import ql.errorhandling.ErrorEnvironment;
import ql.gui.UIComponent;
import qls.ast.visitor.WidgetEnvironment;
import qls.ast.visitor.domaincreator.ConditionalDomain;
import qls.ast.visitor.domaincreator.DomainCreator;
import qls.ast.visitor.pagebuilder.PageBuilder;
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
			+ 		"section \"Page 1 Section 1\" {"
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
			+ 		"section \"Page 2 Section 1\" {"
			+ 			"question booleanValue {"
			+				"width : 600;"
			+				"height : 600;"
			+				"font : \"Consolas\";"
			+				"fontsize : 20;"
			+				"color : #FF0000;"
			+ 				"widget dropdown(\"Yes\", \"No\");"
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
			+  		"section \"Page 2 Section 2\" {"
			+ 			"question firstInteger {"
			+ 				"widget spinbox;"
			+ 			"}"	
			+ 			"question secondInteger;"
			+ 		"}"
			+ 		"default integer widget text;"
			+ 	"}"
			+ "}";
		
	/**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
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
		
		List<ConditionalDomain> domains = DomainCreator.create(qlTree, widgets);
		
		for(Identifier identifier : widgets.getIdentifiers()) {
			System.out.println(identifier + " : " + widgets.resolve(identifier));
		}
		
		UIComponent createdPanel = PageBuilder.build(qlsTree, domains, widgets);
		
        //Create and set up the window.
        JFrame frame = new JFrame("Questionnaire");
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
        
        frame.add(createdPanel.getComponent());
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
