package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import cons.TypeEnvironment;
import cons.ValueEnvironment;
import cons.ql.ast.ASTNode;
import cons.ql.ast.visitor.typechecker.TypeChecker;
import cons.ql.parser.Parser;

public class Main {
	
	public static final String form = "form taxOfficeExample { "
			+ "    firstValue: integer {"
			+ "        \"First value:\""
			+ "    }"
			+ "    secondValue: integer {"
			+ "        \"Second value:\""
			+ "    }"
			+ "    assignedValue: integer {"
			+ "        \"Addition of first and second value: \""
			+ "			assign(firstValue + secondValue)"
			+ "    }"
			+ ""
			+ "    booleanValue: boolean { "
			+ "        \"Are you awesome?\""
			+ "    }"
			+ ""
			+ "	   booleanValueCopy: boolean { "
			+ "        \"Copies the question above\""
			+ "        assign(booleanValue)"
			+ "    }"
			+ ""
			+ "    if (booleanValue || firstValue == 10) {"
			+ "        sellingPrice: integer {"
			+ "            \"What was the selling price?\""
			+ "        }"
			+ "        privateDebt: integer {"
			+ "            \"Private debts for the sold house:\" "
			+ "        }"
			+ ""
			+ "        valueResidue: integer {"
			+ "            \"Value residue:\""
			+ "            assign(sellingPrice - privateDebt)"
			+ "        }"
			+ "        if (firstValue == 100) {"
			+ "            lol: string {"
			+ "	               \"is this IF active??\""
			+ "            }"
			+ "        }"
			+ "    }"
			+ "    else {"
			+ "        lol2: string {"
			+ "	           \"This is the else\""
			+ "        }"
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
		
		JScrollPane scrollPane = new JScrollPane(ComponentCreator.check(tree, new Controller(), valueEnv));
		frame.getContentPane().add(scrollPane);
 
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
