package uva.sc.ql.gui.listeners;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import uva.sc.ql.atom.BooleanAtom;
import uva.sc.ql.atom.ID;
import uva.sc.ql.evaluator.QuestionsPropertiesVisitor;
import uva.sc.ql.gui.helpers.ListenerHelper;
import uva.sc.ql.gui.helpers.QuestionData;

public class VisibilityListener implements ActionListener, Observer {

    private QuestionsPropertiesVisitor questionsProperties;
    private List<Component> componentList;
    private Map<ID, List<ID>> patronElements;
    private ID id;

    public VisibilityListener(Map<ID, List<ID>> patronElements, QuestionsPropertiesVisitor questionsProperties,
	    List<Component> componentList, ID id) {
	this.patronElements = patronElements;
	this.questionsProperties = questionsProperties;
	this.componentList = componentList;
	this.id = id;
	questionsProperties.addObserver(this);
    }

    public void actionPerformed(ActionEvent e) {
	QuestionData data = questionsProperties.questionData(id);
	boolean value = true;
	if (data.getValue() != null) {
	    BooleanAtom visibility = (BooleanAtom) data
		    .evaluateValue(questionsProperties.getValuesTable());
	    value = !(visibility.getValue());
	}
	data = new QuestionData(new BooleanAtom(value), data.getVisibility());
	questionsProperties.putToValuesTable(id, data);
    }

    public void update(Observable o, Object arg) {
	List<ID> elements = patronElements.get(id);
	setComponentsVisibility(elements);
    }

    private void setComponentsVisibility(List<ID> elements) {
	ListenerHelper helper = new ListenerHelper();
	for (ID element : elements) {
	    QuestionData data = questionsProperties.questionData(element);
	    boolean visible = data.evaluateVisibility(questionsProperties
		    .getValuesTable());
	    helper.getComponentByName(element, componentList).setVisible(
		    visible);
	}
    }
}