package anotherOne.gui.input;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import anotherOne.ast.question.ValueStorage;

public class QuestionWidget extends JComponent implements WidgetTemplate{

	JLabel label;
//	Input input;
	JComponent component;
	ValueStorage values;
	
	public QuestionWidget (JLabel label, JComponent component, ValueStorage values){
		this.label = label;
		this.component = component;
		this.values = values;
	}

	@Override
	public void storeValue(JComponent component, ValueStorage values) {
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
//			frame3.setVisible(true);
			System.out.print(input);
			trgt.setText("" + (input*3));
			
			if (input > 10) {System.out.print("mo");
			gbc.gridy ++;
//			gbc.gridy++;
			panel1.add(defaultLabel, gbc);
		
//			panel1.add(lbl,gbc );
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

//			jp.setVisible(false);
//            jp7.setVisible(true);


//			if (input < 10)  {
//			System.out.print("mi");
//			jp.setVisible(true);}
//			jp7.setVisible(false);

            }

			}

	});

		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	
}
