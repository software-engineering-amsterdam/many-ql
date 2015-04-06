package org.nlamah.QL;

import java.awt.Container;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import org.nlamah.QL.FormModel.Form;

@SuppressWarnings("serial")
public class FormUI extends JFrame {

	public FormUI(Form form)
	{
		JButton button1 = new JButton("button1");
		JButton button2 = new JButton("button2");
		JButton button3 = new JButton("button3");
		
		createLayout(button1, button2, button3);
		
		setTitle(form.getTitle());
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout layout = new GroupLayout(pane);
        pane.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup().
                 addComponent(arg[0]).addComponent(arg[2]));
        hGroup.addGroup(layout.createParallelGroup().
                 addComponent(arg[1]));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                 addComponent(arg[0]).addComponent(arg[1]));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                 addComponent(arg[2]));
        layout.setVerticalGroup(vGroup);
        
        
    }
	
}
