package anotherOne.ast.trash;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;

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
import anotherOne.ast.expression.Id;
import anotherOne.ast.expression.VariablesCollectionVisitor;
import anotherOne.ast.expression.arithmeticExpr.ArithmeticExpressionEvaluationVisitor;
import anotherOne.ast.question.ComputedQuestion;
import anotherOne.ast.question.Question;
import anotherOne.ast.question.QuestionList;
import anotherOne.ast.question.ValueStorage;
import anotherOne.ast.questionsVisitors.QuestionValuesVisitor;
import anotherOne.ast.value.NumericalTypeValue;
import anotherOne.ast.value.StringTypeValue;
import anotherOne.ast.value.TypeValue;
//import javax.swing.SpringLayout;

/** Client */

public class Copy_2_of_FormGUI extends JFrame {

	public static JFrame frame = new JFrame();
	public static JPanel panel1 = new JPanel(new GridBagLayout());
	public static JPanel pan = new JPanel(new GridBagLayout());
	public static GridBagConstraints gbc = new GridBagConstraints();
	public static JFrame frame3 = new JFrame();

    public static JFrame frame9;
	public static JLabel defaultLabel = new JLabel("Please select an option ", JLabel.CENTER);
	public static ValueStorage values = new ValueStorage();
	public static HashMap<String, TypeValue> vali = new HashMap<String,TypeValue>();;
	public static HashMap<String, Question> questionsBank = new HashMap<String,Question>();;
	public static Map<String,Id> tempVarsColl = new HashMap<String, Id>();
	public Copy_2_of_FormGUI()
	{
	}
	
	public static void main(FormObject questionnaire) { // (String[] args) {
		
		vali.put("1", new NumericalTypeValue(1));
		values.vali.put("2", new StringTypeValue("hiho"));

		NumericalTypeValue value = (NumericalTypeValue)vali.get("1");
        
		panel1.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(6, 6, 0, 0);
		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.gridy = 0;
		gbc.gridwidth = 20; //GridBagConstraints.REMAINDER;
		gbc.gridy++;
		gbc.gridy++;

		JPanel pnl = pan(questionnaire);
		frame9 = new JFrame("JFrame Example");
        frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame9.setLayout(new GridLayout(0, 1, 2, 2));
        frame9.setVisible(true);
		frame9.setBounds(0,0,300,300);

		pan = panel1;
// 		frame.add(panel1);
		frame9.add(panel1);

//		JFrame testframe = new JFrame("testology");
//		testframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        testframe.setLayout(new GridLayout(0, 1, 2, 2));
//		testframe.setVisible(true);
//        testframe.setBounds(0,0,300,300);
//        testframe.add(panel1);

	}
	
		static JPanel pan (FormObject questionnaire){
		
		for (BoxObject box : questionnaire.getBoxs()){
		for (Question question : box.getQuestions()){
			questionsBank.put(question.getId(), question);
//			values.vali.put(question.getId(),null); // should return null from the value environment
		}
		}
			
		int i = 0;
		for (BoxObject box : questionnaire.getBoxs()){
		for (Question question : box.getQuestions()){

//				updateFromTextField((JTextField)question.getType().getWidget());				
//				values.vali.put(question.getId(),null); // should return null from the value environment
				panel1.add(new JLabel ((String)question.accept(new QuestionValuesVisitor(frame9)).get(1)),gbc); //question.
				panel1.add(new JLabel (question.getId()),gbc); //question.
				
				System.out.println("question " + i + " accepted: ");
					System.out.println(question.getId());
					i ++;

					Component jComp = question.getType().getWidget();
					
//					panel1.add(jComp); // here!!!
					if(jComp instanceof JTextField) {						
//					updateFromTextField((JTextField)jComp, question.getId());
					System.out.println("Text field");}					
					else /*if (jComp instanceof JCheckBox)*/ {
					System.out.println("CheckBox");
					}
					
					if (question.isComputed()){
						
						JTextField jtxt = (JTextField)question.getType().getWidget(); 
						JLabel idlbl = new JLabel(question.getId());
						ComputedQuestion cq = (ComputedQuestion)question;//..bindExpressions (question);
						tempVarsColl = cq.arithmeticExpr.accept(new VariablesCollectionVisitor());
						int innie = cq.arithmeticExpr.accept(new ArithmeticExpressionEvaluationVisitor(),tempVarsColl);
						 
//						Map<String,Id>cq.arithmeticExpr.accept(new VariablesCollectionVisitor()); 
						
						cq.expInputVaribales = tempVarsColl;
								
						int in = 9;
						for (String idString : cq.expInputVaribales.keySet()){
							System.out.println("This" + idString);							// check if exists
							// this comment 1
						bindTxtFields((JTextField)cq.getType().getWidget(),(JTextField)questionsBank.get(idString).getType().getWidget(), cq.getId(),idString);

						values.vali.put(idString, new StringTypeValue("hiho"));
//						NumericalTypeValue value2 = (NumericalTypeValue)vali.get("1");
//						System.out.println(((NumericalTypeValue)vali.get("1")).getValue());
//						System.out.println((new NumericalTypeValue(1)).getValue());//.get("1").getValue());

						System.out.println(
						"The trick worked: " +
//						String str = "" + 
						((StringTypeValue)values.vali.get(idString)).getValue());
						
						System.out.println(
						"The trick worked2: " +
//						String str = "" + 
						(((NumericalTypeValue)vali.get("1")).getValue()));						
//((StringTypeValue)values.vali.get(id.getIdValue())).getValue());

						}
						System.out.println(innie); //innie = 3;
//						jtxt.setText("here");
//						jtxt.setText("" + cq.arithmeticExpr.accept(new ArithmeticExpressionEvalutaionVisitor()));
//						panel1.add(question.getType().getWidget(),gbc);

						jtxt.setText("" + innie + 1);
						panel1.add(jtxt,gbc);
						System.out.println("this is it:  ");
//						System.out.print("" + cq.arithmeticExpr.accept(new ArithmeticExpressionEvalutaionVisitor()));

						;}
					else {
						if(jComp instanceof JTextField) {						
							updateFromTextField((JTextField)jComp, question.getId());
						}
						panel1.add(question.getType().getWidget(),gbc);
					}
//				}
					gbc.gridy++;
			}		
		}

		return panel1;
	}

	public static void updateFromTextField (JTextField jtxt, String id){ // attention - > Component should be controlled on subtype downcasting.
		
		jtxt.getDocument().addDocumentListener(new DocumentListener(){

		@Override
		public void changedUpdate(DocumentEvent arg0) {
			warn(); // update**
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
			System.out.println("change!!");
			int inputValue = Integer.parseInt(jtxt.getText());
			System.out.println("the parsed int is: " + inputValue);
			//			theMap.p
			NumericalTypeValue num = new NumericalTypeValue(1);
			((NumericalTypeValue)questionsBank.get(id).getType()).setValue(inputValue);
			
			values.vali.put(id, new NumericalTypeValue(inputValue));
			//			values._values.put("real test", num); // currently NumericalTypeValue and not just an Object value
			System.out.print("Updated values environment with: " 
			+ values.vali.get(id).getValue());			
			System.out.println(
			"Updated values environment with: " 
			+ 
			questionsBank.get(id).getType().getValue());
		}
			

		});}


	public static void bindTxtFields (JTextField orgn, JTextField trgt, String trgtId, String orgnId){
		System.out.println("2look2: ");

		trgt.getDocument().addDocumentListener(new DocumentListener(){

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
			
			
//			int input4 = ((ComputedQuestion)questionsBank.get(trgtId)).arithmeticExpr.accept(new ArithmeticExpressionEvaluationVisitor(), tempVarsColl);
			int input3 = Integer.parseInt(trgt.getText());
			// 
			
			((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales.put(orgnId,new Id(trgtId,input3));
//			tempVarsColl = ((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales;//.expInputVaribales;
			int input4 = ((ComputedQuestion)questionsBank.get(trgtId)).arithmeticExpr.accept(new ArithmeticExpressionEvaluationVisitor(), ((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales);
			int ss = (((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales).size();
			System.out.println("mapssize:  " + ss);
			System.out.println("check binding88: " + input4);
//			
			System.out.println("check binding: " + ((ComputedQuestion)questionsBank.get(trgtId)).expInputVaribales.get(orgnId).getNumericalValue());
			orgn.setText("" + input4);
//			orgn.setText("it should be this one" + input3);

			
			((NumericalTypeValue)questionsBank.get(trgtId).getType()).setValue(input4);
			System.out.println("iterates?      " + input4);
			System.out.println("Updated values environment with computed value: " 
			+ questionsBank.get(trgtId).getType().getValue());

			
		
		}
	});
	}



	
	
	
	
	
	



	public static void bindTxtField (JTextField orgn, JTextField trgt, JTextField test){
		/*public static*/ JTextField txtfld = new JTextField ("eee");	

		orgn.getDocument().addDocumentListener(new DocumentListener(){

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
			
			int input = Integer.parseInt(orgn.getText());
			System.out.print(input);
			trgt.setText("" + (input*3));
			test.setText("" + (
					Integer.parseInt(trgt.getText())
					+ Integer.parseInt(orgn.getText())));
			
			if (input > 10) {System.out.print("mo");
			gbc.gridy ++;
			panel1.add(defaultLabel, gbc);
		
			panel1.add(txtfld ,gbc);
//            jp7.setVisible(true);
            frame9.revalidate();  // For JDK 1.7 or above.
            frame9.repaint();			
			}
//            frame9.add(tfld);
            if (input < 10) {System.out.print("mo");
			panel1.remove(defaultLabel); //}
			panel1.remove(txtfld); //}
		frame9.repaint();

            //            frame9.remove(tfld);
//			panel1.remove(lbl);
			panel1.remove(txtfld);
            frame9.invalidate();  // For JDK 1.7 or above.
            frame9.revalidate();  // For JDK 1.7 or above.
            frame9.validate();  // For JDK 1.7 or above.
            frame9.repaint();			

            }
			}
	});

	}

	
	
	
	
	
	
	
	
//	public static int evaluateExpression(Expression expr){
		// bind - observe  (current computed label should observe
		//   				the assigned labels.
		// visitor - upon a change in the observable labels - 
		// 				set new value in the 
		// make a test of question values
		// maintain question-values.
		// refresh by setting Id Value to it.
		// evaluate.
		
//		return (-1);
//	}
}

/*
JFrame frame2 = new JFrame();
frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame2.setBounds(0,0,300,302);
JPanel panel2 = new JPanel(new GridBagLayout());
panel2.setBackground(Color.green);
panel2.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));

JPanel panel3 = new JPanel(new GridBagLayout());
panel3.setBackground(Color.blue);
panel3.setBorder(BorderFactory.createEmptyBorder(4, 10, 10, 10));

panel2.add(panel3);
frame2.add(panel2);
frame2.setVisible(true);


JPanel main = new JPanel( new FlowLayout(FlowLayout.CENTER, 0, 0) );

JPanel panel4 = new JPanel();
panel4.setBackground(Color.green);
panel4.setPreferredSize( new Dimension(100, 100) );
panel4.add( new JButton() );
main.add( panel4 );

JPanel panel5 = new JPanel();
panel5.setBackground(Color.red);
panel5.setPreferredSize( new Dimension(100, 100) );
panel5.add( new JButton() );
main.add( panel5 );
//main.setVisible(false);
frame3.add( main );
//frame3.setVisible(true);


frame = new JFrame("JFrame Example");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setLayout(new GridLayout(0, 1, 2, 2));
//button = new JButton("Add JTextField");
//JPanel jp = new JPanel();
jp.add(tfield);
frame.add(jp);
jp.setVisible(true);

*
*
*
*		bindTxtField(orgn2,trgt2, test2); // !!!		
//		panel1.add(orgn2, gbc);
//		panel1.add(trgt2, gbc);
//		gbc.gridy ++;
//		panel1.add(test2, gbc);

//		gbc.gridy ++;
//		panel1.add(defaultLabel, gbc);
*
*
*					System.out.println (question.accept(new QuestionValuesVisitor(frame9)).get(1));
//					panel1.add(question.getType().getWidget());
//					panel1.add((Component) question.accept(new QuestionValuesVisitor(frame9)).get(2), gbc); //question.
//					gbc.gridy++;

*
*			// this comment1//							if(questionsBank.containsKey(idString)){
//								JTextField one = (JTextField)cq.getType().getWidget();
//								JTextField two = (JTextField)questionsBank.get(idString).getType().getWidget();
//								bindTxtFields(one, two);
//						}

*
*
*	//					if (question.isComputed()){
//						bindExpressions (question);
//						;}
//					question.getType().getWidget().;
//					panel1.add(new JLabel ("Niks"),gbc);
					JTextField orgn = new JTextField("15", 15);
					JTextField trgt = new JTextField(20);
					JTextField test = new JTextField(20);
					
//					bindTxtField(orgn,trgt, test);
					
//					panel1.add(orgn, gbc);
//					panel1.add(trgt, gbc);
//					gbc.gridy ++;
//					panel1.add(test, gbc);

//					gbc.gridy++;
//					panel1.add(defaultLabel, gbc);
					System.out.print("This should be printed");		
*
*
*
*							map.put("map1", "value1");
		
		vali.put("1", new NumericalTypeValue(1));
		values.vali.put("2", new StringTypeValue("hiho"));

		NumericalTypeValue value = (NumericalTypeValue)vali.get("1");

*
*
*		public static void bindExpressions(Question question){
		
	};

*
*
*
*
*/

/*

public static void printForm(FormObject questionnaire){

	for (BoxObject box : questionnaire.getBoxs()){
		printQstns(box.questionsList);
	}
}

static void printQstns(List<Question> questions){
for (Question question : questions){
if(question instanceof IfQuestion){
	printQstns(((IfQuestion) question).getQuestions());
}
else{
	System.out.println("QUESTIONNNNNN ID: "+question.getId());
}
}
}

*/