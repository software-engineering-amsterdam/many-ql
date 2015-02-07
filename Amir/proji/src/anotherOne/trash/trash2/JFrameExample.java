package anotherOne.main.trash;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JFrameExample
{   
    private JFrame frame;
    private JButton button;
	JTextField orgn = new JTextField(15);

    private JTextField tfield;
    private String nameTField;
    private int count;

    public JFrameExample()
    {
        nameTField = "tField";
        count = 0;
    }

    private void displayGUI()
    {
        frame = new JFrame("JFrame Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1, 2, 2));
        button = new JButton("Add JTextField");
        JPanel jp = new JPanel();
        JPanel jp2 = new JPanel();
        tfield = new JTextField(15);
        jp.add(tfield);
        frame.add(jp);
        frame.add(jp2);
        jp.setVisible(false);
        jp2.setVisible(false);
        
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
//			System.out.print(input);
//			trgt.setText("" + (input*3));
			if (input > 10) {System.out.print("mo");
             tfield.setName(nameTField + count);
             count++;
             jp.setVisible(false);
//             frame.add(tfield);
             tfield = new JTextField();
             tfield.setName(nameTField + count);
             count++;
             frame.add(tfield);
//             frame.re
//             frame.revalidate();  // For JDK 1.7 or above.
//             //frame.getContentPane().revalidate(); // For JDK 1.6 or below.
//             frame.repaint();
      
             frame.revalidate();  // For JDK 1.7 or above.
             //frame.getContentPane().revalidate(); // For JDK 1.6 or below.
             frame.repaint();			
			}
			if (input < 10)  {
				System.out.print("mi");
				jp.setVisible(true);}

		}

	});
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                tfield = new JTextField();
                tfield.setName(nameTField + count);
                count++;
                frame.add(tfield);
                frame.revalidate();  // For JDK 1.7 or above.
                //frame.getContentPane().revalidate(); // For JDK 1.6 or below.
                frame.repaint();
            }
        });
        frame.add(orgn);
        frame.add(button);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new JFrameExample().displayGUI();
            }
        });
    }
}