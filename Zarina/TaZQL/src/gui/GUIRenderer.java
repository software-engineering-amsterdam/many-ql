package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import ast.form.Form;
import ast.form.IFormVisitor;
import ast.question.Question;
import evaluator.ValueRepository;
import gui.questions.SimpleQuestionUI;
import gui.widgets.listeners.SaveButtonListener;

public class GUIRenderer implements IFormVisitor<JPanel> {
	private final JPanel panel;
	private final ValueRepository valueRepository;
	private final LinkedHashMap<String, SimpleQuestionUI> widgetsRepository;
	private final JButton saveData;
	
	private GUIRenderer() { 
		this.panel = new JPanel();
		this.panel.setLayout(new MigLayout( "wrap 2, hidemode 3")); 
		this.saveData = new JButton("Save questionnaire");
		this.valueRepository = new ValueRepository();
		this.widgetsRepository = new LinkedHashMap<String, SimpleQuestionUI>();
	}
	
	public static JPanel make(Form form) { 
		GUIRenderer visitor = new GUIRenderer(); 
		form.accept(visitor);
		return visitor.getPanel();
	}
	
	public JPanel getPanel() {
		return panel;
	}
	
	
	public void addToPanel() {
		Set<String> keys = widgetsRepository.keySet();
        for(String k:keys){
            System.out.println(k+" <- added to panel ");
            this.panel.add(widgetsRepository.get(k).getLabel());
            this.panel.add(widgetsRepository.get(k).getWc().getWidget(), "wrap");    
        }
        addSaveButton();
    }
	
	public void addSaveButton() {
		saveData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			   new SaveButtonListener(valueRepository);
			}
		});
		this.panel.add(saveData, "span 2, align center");
	}
	
	public Set<String> getIDkeys() {
		Set<String> keys = widgetsRepository.keySet();
		return keys;
	}
	
	public void putWidgetRepository(String id, SimpleQuestionUI widgets) {
		this.widgetsRepository.put(id, widgets);
	}
	
	public SimpleQuestionUI getIDSimpleQuestionUI(String id) {
		return this.widgetsRepository.get(id);
	}
	
	 public boolean containsSimpleQuestionUI(String id) {
		 return this.widgetsRepository.containsKey(id);
	 }

	
	@Override
	public JPanel visit(Form form) {
		for(Question q : form.getQuestionText()){
			q.accept(new GUIVisitor(this, valueRepository));
		}
		addToPanel();
		return panel;
	}
}