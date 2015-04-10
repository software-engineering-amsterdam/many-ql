package qlProject.gui;

import qlProject.ast.Questionnaire;
import qlProject.ast.value.Value;
import qlProject.gui.gui_building_visitors.QuestionWidget;
import qlProject.gui.gui_building_visitors.WidgetsCreationVisitor;
import qlProject.gui.input_response_visitors.TrackChangesVisitor;
import qlProject.util.QuestionDetails;

import java.awt.*;

import javax.swing.*;

import java.util.Map;
import java.util.Set;

public class GuiManager {

	private final Map<String, QuestionDetails> questionsDetails;;
	private final Map<String, Value> valuesEnvironment;
	private final Map<String,Set<String>> deps;
	private final Map<String,Set<String>> awaitingCalculationIds;
	
	public GuiManager(Map<String, QuestionDetails> questionsDetails, Map<String, Value> valuesEnvironment, Map<String,Set<String>> deps, Map<String,Set<String>> awaitingCalculationIds)
	{
		this.questionsDetails = questionsDetails;
		this.valuesEnvironment = valuesEnvironment;
		this.deps = deps;
		this.awaitingCalculationIds = awaitingCalculationIds;
		}

	public GridBagConstraints initializeGridBagConstraints(){
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		return gbc;
	}

	public Map<String, QuestionWidget> createWidgets(Questionnaire q){
		WidgetsCreationVisitor visitor = new WidgetsCreationVisitor (valuesEnvironment);
		q.accept(visitor);
		return visitor.getQuestionWidgets();
	}

	public JFrame initiateAFrame (){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);
		return frame;
	}

	public JPanel buildPanel(Map<String, QuestionWidget> questionWidgetsMap, GridBagConstraints gbc){

		JPanel panel = new JPanel(new GridBagLayout());

		for (String id : questionWidgetsMap.keySet()){
			addWidgetToPanel(panel, questionWidgetsMap, id, gbc);
		}
		
		return panel;
	}

	public void addWidgetToPanel(JPanel p, Map<String, QuestionWidget> questionWidgetsMap, String id, GridBagConstraints gbc){
		QuestionWidget questionWidget = questionWidgetsMap.get(id);
		gbc.gridx++;
		p.add(questionWidget.getComponent(), gbc);
		gbc.gridx--;
		p.add(questionWidget.getLabel(), gbc);
		gbc.gridy++;		
	}

	public void manageGUI(Questionnaire q) {

		JFrame frame = initiateAFrame();
		GridBagConstraints gbc = initializeGridBagConstraints();
		Map<String, QuestionWidget> questionWidgetsMap = createWidgets(q);
		q.accept(new TrackChangesVisitor(questionsDetails, valuesEnvironment, deps, questionWidgetsMap, awaitingCalculationIds));
		JPanel panel = buildPanel(questionWidgetsMap, gbc);
		frame.add(panel);
		frame.setVisible(true);

	}
}