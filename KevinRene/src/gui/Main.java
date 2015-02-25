package gui;

import javax.swing.JFrame;

import cons.TypeEnvironment;
import cons.ValueEnvironment;
import cons.ql.ast.ASTNode;
import cons.ql.ast.visitor.typechecker.TypeChecker;
import cons.ql.parser.Parser;

public class Main {
	
	public static final String form = "form taxOfficeExample { "
			+ "   hasSoldHouse: string {"
			+ "        \"Did you sell a house in 2010?\""
			+ "    }"
			+ "    hasBoughtHouse: boolean {"
			+ "        \"Did you buy a house in 2010?\""
			+ "    }"
			+ "    hasMaintLoan: boolean {"
			+ "        \"Did you enter a loan?\""
			+ "    }"
			+ "    assignedValue: string {"
			+ "        \"is the IF visible?\""
			+ "			assign(hasSoldHouse)"
			+ "    }"
			+ ""
			+ ""
			+ "    if (hasSoldHouse == \"yes\") {"
			+ "        sellingPrice: money {"
			+ "            \"What was the selling price?\""
			+ "        }"
			+ "        privateDebt: money {"
			+ "            \"Private debts for the sold house:\" "
			+ "        }"
			+ ""
//			+ "        valueResidue: money {"
//			+ "            \"Value residue:\""
//			+ "            assign(sellingPrice - privateDebt)"
//			+ "        }"
			+ "    }"
			+ "}";
	
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Questionnaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Load and parse the entire form and what not.
        Parser formParser = new Parser();
        ASTNode tree = formParser.parse(form);
		TypeEnvironment register = new TypeEnvironment();
		ValueEnvironment valueEnv = new ValueEnvironment();
		
		if(!TypeChecker.check(tree, register)) {
			System.out.println("Type error detected in the form.");
			System.exit(0);
		}
		
		ComponentCreator.check(frame.getContentPane(), tree, valueEnv);
 
        //Display the window.
        frame.pack();
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setVisible(true);
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
