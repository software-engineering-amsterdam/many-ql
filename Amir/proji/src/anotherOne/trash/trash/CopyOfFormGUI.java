//package anotherOne.main;
package anotherOne.ast.trash;
//import org.encog.util.http.FormUtility;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import anotherOne.ast.BoxObject;
import anotherOne.ast.FormObject;
import anotherOne.ast.question.Question;
import anotherOne.ast.questionsVisitors.QuestionValuesVisitor;
import anotherOne.gui.input.ExtendedListener;
//import javax.swing.SpringLayout;

/** Client */

public class CopyOfFormGUI extends JFrame {// {
//	 extends JFrame implements ActionListener{
	
	
//	FormObject questionnaire = new FormObject();

//   JTextField tField;
//   JPasswordField pwField;
//   JTextArea tArea;
//   JFormattedTextField formattedField;
//
//   JPanel tfPanel = new JPanel(new GridLayout(3, 2, 10, 2));
//   tfPanel.setBorder(BorderFactory.createTitledBorder("Text Fields: "));
   
	private static final JFrame frame = new JFrame("titletitle");
	private JPanel panel1 = new JPanel();
	static public String tmp = "";
	public CopyOfFormGUI()
	    {
	    }
	public static void main(FormObject questionnaire) { // (String[] args) {
		
		JFrame frame1 = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500, 900);
	    frame.setLayout(new GridBagLayout());
	    GridBagConstraints constraints = new GridBagConstraints();

	    constraints.anchor = GridBagConstraints.CENTER;
	    
	    for (BoxObject box : questionnaire.getBoxs()){
		for (Question question : box.getQuestions()){
//			frame
			
		}
	}    
		
		JFrame frfr = new JFrame();
        frfr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frfr.setBounds(0,0,300,302);


        JPanel panel1 = new JPanel(new GridBagLayout());
        panel1.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(6, 6, 0, 0);
        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = 0;
        gbc.gridwidth = 20; //GridBagConstraints.REMAINDER;
        	
        
        for (BoxObject box : questionnaire.getBoxs()){
		for (Question question : box.getQuestions()){
			
	        for (int i11 = 0; i11 < 2; i11++) {
	        	panel1.add(new JLabel ((String)question.accept(new QuestionValuesVisitor()).get(1)),gbc); //question.
	        	System.out.println (question.accept(new QuestionValuesVisitor()).get(1));
	        	System.out.println ("2" + (String) question.accept(new QuestionValuesVisitor()).get(1));
	        	panel1.add((Component) question.accept(new QuestionValuesVisitor()).get(2), gbc); //question.
//	        panel1.add(new JLabel(question.questionText));
//	        String ok = question.questionText;
//		    JLabel newLabel = new JLabel(ok);

//		    JLabel newLabel = new JLabel(i11 +  question.questionText + "   ");
//		    JLabel newLabel = new JLabel(question.questionText);
//		    panel1.add(new JLabel(question.questionText),gbc);;
	        gbc.gridy++;
//	        panel1.add(new JLabel("ada"), gbc);
//	        panel1.add(new JLabel(question.questionText),gbc);
//	        panel1.add(newLabel, gbc);
	        JCheckBox chk = new JCheckBox("Yes");
//	        panel1.add(new JTextField(20), gbc);
	        panel1.add(chk, gbc);
	        }
	        gbc.gridy++;
	        gbc.weightx = 1;
	        panel1.add(new JTextField(20), gbc);
		}
		
		panel1.add(new JCheckBox("unnecessary"), gbc);
		JTextField tf = new JTextField(15);
		JTextField trgt = new JTextField(20);
		
		tf.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void changedUpdate(DocumentEvent arg0) {
				warn();
			}

			@Override
			public void insertUpdate(DocumentEvent arg0) {
				warn();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				warn();	
			}
			
			public void warn(){
				trgt.setText(tf.getText());
			}
			
		});
		
		panel1.add(tf, gbc);
		panel1.add(trgt, gbc);

		
		
//		tf.addActionListener(new ActionListener(){
//			String str = "";
////			//@Override
//			public void actionPerformed(ActionEvent e){
//				str = tf.getText();
//			}			
//		}
		String strr = "NO!";
		ExtendedListener listener = new ExtendedListener(strr);
//		listener.actionPerformed 

//		panel1.add(new JTextField("33",15), gbc);
//		JTextField second = new JTextField();
//		second.addActionListener(listener);
//		panel1.add(new JTextField(tf.getText(),10), gbc);
	    
	    
        }
	    
	    frfr.add(panel1);
        frfr.setVisible(true);
	
	}
	
//	@Override
//	public void actionPerformed(ActionEvent arg0) {
//		// TODO Auto-generated method stub
//		str = tf.getText();
//
//	}    
	
	 /**
     * Grid bag constraints for fields and labels
     */
	}


//JFrame myFrame = new JFrame("Example");
//MSBLayout layout = new MSBLayout(
//     "([1],1)([1],1),1,(['buttons' 2])",myFrame);
//
//layout.add(new JLabel("Short"));
//layout.add(new JTextField(20));
//
//layout.add(new JLabel("A good deal longer"));
//layout.add(new JTextField(20));
//
//layout.glue(0, 16, 16384); // some space to separate the form from the buttons
//
//layout.add(new JButton("Short"));
//layout.add(new JButton("A good deal longer"));
//
//myFrame.pack();
//myFrame.setVisible(true);


//JFrame frame9 = new JFrame("Test");
//frame.setSize(500,500);
//frame.setVisible(true);
//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//JPanel panel9 = new JPanel(new GridLayout());
//frame.getContentPane().add(panel9, BorderLayout.NORTH);
//frame.add(panel9);
//GridBagConstraints c = new GridBagConstraints(); 
//JLabel label1 = new JLabel("Test1");
//c.gridx = 0;
//c.gridy = 0;
//c.insets = new Insets(10,10,10,10);
//panel9.add(label1,c);
//JLabel label2 = new JLabel("Test1");
//c.gridx = 0;
//c.gridy = 1;
//panel9.add(label2,c);
//JLabel label3 = new JLabel("Test2");
//c.gridx = 0;
//c.gridy = 2;
//panel9.add(label3,c);
//JButton button = new JButton ("Test3");
//c.gridx = 1;
//c.gridy = 3;
//panel9.add(button,c);
//
//
//	
//	
//	JFrame frame = new JFrame("Demo application");
//	frame.setSize(300, 150);
//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//	JPanel panel6 = new JPanel();
//	frame.add(panel6);
////	placeComponents(panel6);
//
////	frame.setVisible(true);
//	
//	panel6.setLayout(null);
//
//	JLabel userLabel = new JLabel("User");
//	userLabel.setBounds(10, 10, 80, 25);
//	panel6.add(userLabel);
//
//	JTextField userText = new JTextField(20);
//	userText.setBounds(100, 10, 160, 25);
//	panel6.add(userText);
//
//	JLabel passwordLabel = new JLabel("Password");
//	passwordLabel.setBounds(10, 40, 80, 25);
//	panel6.add(passwordLabel);
//
//	JPasswordField passwordText = new JPasswordField(20);
//	passwordText.setBounds(100, 40, 160, 25);
//	panel6.add(passwordText);
//
//	JButton loginButton = new JButton("login");
//	loginButton.setBounds(10, 80, 80, 25);
//	panel6.add(loginButton);
//	
//	JButton registerButton = new JButton("register");
//	registerButton.setBounds(180, 80, 80, 25);
//	panel6.add(registerButton);





//JPanel p = new JPanel(new SpringLayout());
//for (int i11 = 0; i11 < 0; i11++) {
//	JLabel l = new JLabel(labels[i11], JLabel.TRAILING);
//    panel2.add(new JLabel(labels[i11], JLabel.TRAILING));
//    JTextField textField = new JTextField(10);
//    l.setLabelFor(textField);
//
//    panel2.add(textField);
//}
//
//JPanel panel3 = new JPanel(new GridLayout(2, 2));
//panel3.add(new JLabel("Field 1:"));
//JPanel panel4 = new JPanel(new GridLayout(2, 2));
//panel4.add(new JLabel("		"));
//String[] labels2 = {"Name: ", "Fax: ", "Email: ", "Address: "};
//int numPairs2 = labels.length;
//
////Create and populate the panel.
//JPanel p2 = new JPanel(new SpringLayout());
//for (int i11 = 0; i11 < numPairs; i11++) {
//    JTextField textField = new JTextField(10);
//    p.add(textField);
//}
//
//
////Lay out the panel.
////SpringUtilities.makeCompactGrid(p,
////                              numPairs, 2, //rows, cols
////                              6, 6,        //initX, initY
////                              6, 6);       //xPad, yPad
//
//
////frame.add(p);
//
////(int i = 0; i < labelInputPairs.size(); i++) {
////    LabelInputPair labelInputPair = labelInputPairs.get(i);
////    this._mainPanel.add(labelInputPair.getLabel(), this._createGridBagConstraints(0, i));
////    this._mainPanel.add(labelInputPair.getInput().getJComponent(),
////        this._createGridBagConstraints(1, i));
////}
