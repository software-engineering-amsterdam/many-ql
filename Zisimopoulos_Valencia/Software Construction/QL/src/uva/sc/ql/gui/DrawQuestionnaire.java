package uva.sc.ql.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import uva.sc.ql.evaluator.EvaluatorVisitor;

public class DrawQuestionnaire extends GUIListener {
    
    Map<String, List<String>> dependentElements;
    List<Component> componentList;
    EvaluatorVisitor evalVisitor;
    
    public DrawQuestionnaire(EvaluatorVisitor v, List<Component> c, Map<String, List<String>> d){
	evalVisitor = v;
	componentList = c;
	dependentElements = d;
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
	questionnairePanel.setLayout(new GridLayout(
		componentList.size(), 0));
	scrollerPane.setPreferredSize(new Dimension(300, 600));
	for (Component component : componentList) {
	    questionnairePanel.add(component);
	}
	frame.add(scrollerPane);
	frame.pack();
	frame.setVisible(true);
    }

}
