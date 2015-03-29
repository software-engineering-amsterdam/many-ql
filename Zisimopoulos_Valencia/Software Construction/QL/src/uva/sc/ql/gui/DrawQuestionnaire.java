package uva.sc.ql.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uva.sc.ql.atom.ID;
import uva.sc.ql.gui.helpers.ListenerHelper;

public class DrawQuestionnaire extends ListenerHelper {

    private List<Component> componentList;
    private ID formTitle;
    
    public DrawQuestionnaire(List<Component> componentList, ID formTitle) {
	this.componentList = componentList;
	this.formTitle = formTitle;
    }

    public void render() {
	JPanel questionnairePanel = new JPanel();
	questionnairePanel.setLayout(new GridLayout(componentList.size(), 0));
	addComponentsToPanel(questionnairePanel);
	draw(questionnairePanel);
    }

    private void addComponentsToPanel(JPanel questionnairePanel) {
	for (Component component : componentList) {
	    questionnairePanel.add(component);
	}
    }

    private void draw(JPanel questionnairePanel) {
	JScrollPane scrollerPane = new JScrollPane(questionnairePanel);
	scrollerPane.setPreferredSize(new Dimension(300, 600));
	JFrame frame = new JFrame();
	frame.setTitle(formTitle.getValue());
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(scrollerPane);
	frame.pack();
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
    }
}
