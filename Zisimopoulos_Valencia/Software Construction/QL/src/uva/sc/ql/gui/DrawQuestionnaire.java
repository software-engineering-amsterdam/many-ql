package uva.sc.ql.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import uva.sc.ql.gui.helpers.ListenerHelper;

public class DrawQuestionnaire extends ListenerHelper {

    List<Component> componentList;

    public DrawQuestionnaire(List<Component> c) {
	componentList = c;
    }

    public void render() {
	JFrame frame = new JFrame();
	JButton submitButton = new JButton("Submit");
	submitButton.setName("subButton");
	componentList.add(submitButton);
	JPanel questionnairePanel = new JPanel();
	JScrollPane scrollerPane = new JScrollPane(questionnairePanel);
	frame.setTitle("QL questionnaire Form");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	questionnairePanel.setLayout(new GridLayout(componentList.size(), 0));
	scrollerPane.setPreferredSize(new Dimension(300, 600));
	for (Component component : componentList) {
	    questionnairePanel.add(component);
	}
	frame.add(scrollerPane);
	frame.pack();
	frame.setVisible(true);
    }

}
