package anotherOne.ast.expression;

import java.util.Map;

import anotherOne.ast.question.BasicQuestion;
import anotherOne.ast.question.ValueStorage;
import anotherOne.ast.value.NumericalTypeValue;
import anotherOne.ast.value.TypeValue;


public class ExpressionVisitor<Object> {

	Map<String, TypeValue> _values;

	public int visit (int integer){
		
		//		integer.
//		BasicQuestion bsd = new BasicQuestion();
//		NumericalValue nmr = new NumericalValue();
//		vstr._values
//		vstr._values
//		System.out.print(vstr._values);
		//		bsd.
		return 0;
	}

	
//	public TypeValue visit (String string){  // here !!!!
//		ValueStorage vstr = new ValueStorage(new Map<String, Value>());
//		ValueStorage vstr = new ValueStorage(_values);  // here !!!!
//		return vstr._values.get("hasBoughtHouse");  // here !!!!
//	};  // here !!!!

	//	public T visit (enum )
	//	public T visit
	//	public T visit

}


//public static void bindTxtField (JTextField orgn, JTextField trgt, JTextField test){
///*public static*/ JTextField txtfld = new JTextField ("eee");	
//
//orgn.getDocument().addDocumentListener(new DocumentListener(){
//
//@Override
//public void changedUpdate(DocumentEvent arg0) {
//	warn();
//}
//
//@Override
//public void insertUpdate(DocumentEvent arg0) {
//	warn();
//}
//
//@Override
//public void removeUpdate(DocumentEvent arg0) {
//	warn();	
//}
//
//public void warn(){
//	
//	int input = Integer.parseInt(orgn.getText());
//	System.out.print(input);
//	trgt.setText("" + (input*3));
//	test.setText("" + (
//			Integer.parseInt(trgt.getText())
//			+ Integer.parseInt(orgn.getText())));
//	
//	if (input > 10) {System.out.print("mo");
//	gbc.gridy ++;
//	panel1.add(defaultLabel, gbc);
//
//	panel1.add(txtfld ,gbc);
////    jp7.setVisible(true);
//    frame9.revalidate();  // For JDK 1.7 or above.
//    frame9.repaint();			
//	}
////    frame9.add(tfld);
//    if (input < 10) {System.out.print("mo");
//	panel1.remove(defaultLabel); //}
//	panel1.remove(txtfld); //}
//frame9.repaint();
//
//    //            frame9.remove(tfld);
////	panel1.remove(lbl);
//	panel1.remove(txtfld);
//    frame9.invalidate();  // For JDK 1.7 or above.
//    frame9.revalidate();  // For JDK 1.7 or above.
//    frame9.validate();  // For JDK 1.7 or above.
//    frame9.repaint();			
//
//    }
//	}
//});
//
//}









//public static int evaluateExpression(Expression expr){
// bind - observe  (current computed label should observe
//   				the assigned labels.
// visitor - upon a change in the observable labels - 
// 				set new value in the 
// make a test of question values
// maintain question-values.
// refresh by setting Id Value to it.
// evaluate.

//return (-1);
//}

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
//panel1.add(orgn2, gbc);
//panel1.add(trgt2, gbc);
//gbc.gridy ++;
//panel1.add(test2, gbc);

//gbc.gridy ++;
//panel1.add(defaultLabel, gbc);
*
*
*					System.out.println (question.accept(new QuestionValuesVisitor(frame9)).get(1));
//			panel1.add(question.getType().getWidget());
//			panel1.add((Component) question.accept(new QuestionValuesVisitor(frame9)).get(2), gbc); //question.
//			gbc.gridy++;

*
*			// this comment1//							if(questionsBank.containsKey(idString)){
//						JTextField one = (JTextField)cq.getType().getWidget();
//						JTextField two = (JTextField)questionsBank.get(idString).getType().getWidget();
//						bindTxtFields(one, two);
//				}

*
*
*	//					if (question.isComputed()){
//				bindExpressions (question);
//				;}
//			question.getType().getWidget().;
//			panel1.add(new JLabel ("Niks"),gbc);
			JTextField orgn = new JTextField("15", 15);
			JTextField trgt = new JTextField(20);
			JTextField test = new JTextField(20);
			
//			bindTxtField(orgn,trgt, test);
			
//			panel1.add(orgn, gbc);
//			panel1.add(trgt, gbc);
//			gbc.gridy ++;
//			panel1.add(test, gbc);

//			gbc.gridy++;
//			panel1.add(defaultLabel, gbc);
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
*		//		values.vali.put("2", new StringTypeValue("hiho"));
*
*
*/




//public static int evaluateExpression(Expression expr){
	// bind - observe  (current computed label should observe
	//   				the assigned labels.
	// visitor - upon a change in the observable labels - 
	// 				set new value in the 
	// make a test of question values
	// maintain question-values.
	// refresh by setting Id Value to it.
	// evaluate.
	
//	return (-1);
//}
//}
//

//
/*
* 
* 
* 

public static void bindTxtField (JTextField orgn, JTextField trgt, JTextField test){
	/*public static* / JTextField txtfld = new JTextField ("eee");	

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
//        jp7.setVisible(true);
        frame9.revalidate();  // For JDK 1.7 or above.
        frame9.repaint();			
		}
//        frame9.add(tfld);
        if (input < 10) {System.out.print("mo");
		panel1.remove(defaultLabel); //}
		panel1.remove(txtfld); //}
	frame9.repaint();

        //            frame9.remove(tfld);
//		panel1.remove(lbl);
		panel1.remove(txtfld);
        frame9.invalidate();  // For JDK 1.7 or above.
        frame9.revalidate();  // For JDK 1.7 or above.
        frame9.validate();  // For JDK 1.7 or above.
        frame9.repaint();			

        }
		}
});

}








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
//	panel1.add(orgn2, gbc);
//	panel1.add(trgt2, gbc);
//	gbc.gridy ++;
//	panel1.add(test2, gbc);

//	gbc.gridy ++;
//	panel1.add(defaultLabel, gbc);
*
*
*					System.out.println (question.accept(new QuestionValuesVisitor(frame9)).get(1));
//				panel1.add(question.getType().getWidget());
//				panel1.add((Component) question.accept(new QuestionValuesVisitor(frame9)).get(2), gbc); //question.
//				gbc.gridy++;

*
*			// this comment1//							if(questionsBank.containsKey(idString)){
//							JTextField one = (JTextField)cq.getType().getWidget();
//							JTextField two = (JTextField)questionsBank.get(idString).getType().getWidget();
//							bindTxtFields(one, two);
//					}

*
*
*	//					if (question.isComputed()){
//					bindExpressions (question);
//					;}
//				question.getType().getWidget().;
//				panel1.add(new JLabel ("Niks"),gbc);
				JTextField orgn = new JTextField("15", 15);
				JTextField trgt = new JTextField(20);
				JTextField test = new JTextField(20);
				
//				bindTxtField(orgn,trgt, test);
				
//				panel1.add(orgn, gbc);
//				panel1.add(trgt, gbc);
//				gbc.gridy ++;
//				panel1.add(test, gbc);

//				gbc.gridy++;
//				panel1.add(defaultLabel, gbc);
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

