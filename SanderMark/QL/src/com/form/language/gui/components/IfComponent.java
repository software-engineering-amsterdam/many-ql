package com.form.language.gui.components;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.form.language.ast.statement.Statement;
import com.form.language.memory.IdCollector;

public class IfComponent {
	
	
	
	
	
/*	@Override
	public JComponent createGUIComponent(JPanel panel) {
		//Create panel with the statements in there (questions) and show/hide this
		ArrayList<Component> co = getAllComponents(panel);		
		
		JPanel p = new JPanel();
		createPanel(p);
		panel.add(p);		
		
		addListener(panel,p);
		return null;
	}
	
	//Get all key components of a question like checkbox / textfield etc.
	public ArrayList<Component> getAllComponents(JPanel panel)
	{
		List<Component> result = new ArrayList<Component>();
		
		//Get all panels of frame
		Component[] cArray =  panel.getComponents();	
		for(Component c : cArray)
		{
			//Get all components of panel
			Component[] ccArray = ((JPanel) c).getComponents();
			for(Component cj : ccArray)
			{
				//If checkbox add listeren
				if(cj instanceof JCheckBox || cj instanceof JTextField)	
				{
					result.add(cj);
				}
			}
		}
		return (ArrayList<Component>) result;
	}
	
	public void addListener(JPanel panel,final JPanel p)
	{
		//Put id's of conditions into memory 		
		IdCollector m = new IdCollector();
		this.conditions.collectIds(m);

		//Get all panels of frame
		Component[] cArray =  panel.getComponents();	
		for(Component c : cArray)
		{
			//Get all components of panel
			Component[] ccArray = ((JPanel) c).getComponents();
			for(Component cj : ccArray)
			{
				//If checkbox add listeren
				if(cj instanceof JCheckBox)	
				{
					final JCheckBox jh = (JCheckBox)cj;
					if(m.containsId(jh.getName()) == true)
					{
						ActionListener actionListener = new ActionListener() {
							public void actionPerformed(ActionEvent actionEvent) {
								System.out.println(jh.getName());
								p.setVisible(jh.isSelected());
							}
						};
						jh.addActionListener(actionListener);
					}
				}
			}
		}					
	}
	
	public void createPanel(JPanel panel)
	{
		for(Iterator<Statement> s = this.thenStatements.iterator(); s.hasNext();)
		{
			Statement statement = s.next();
			JComponent component = statement.createGUIComponent(panel);
			if(component != null)
			{
				panel.add(component);
			}
		}				
	}*/

}
