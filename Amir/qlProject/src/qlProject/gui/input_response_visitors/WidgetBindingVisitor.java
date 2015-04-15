package qlProject.gui.input_response_visitors;

import java.util.Map;
import java.util.Set;

import qlProject.ast.type.BooleanType;
import qlProject.ast.type.ITypeVisitor;
import qlProject.ast.type.IntType;
import qlProject.ast.type.StringType;
import qlProject.ast.value.Value;
import qlProject.gui.InputInterpreter;
import qlProject.gui.gui_building_visitors.QuestionWidget;
import qlProject.gui.listeners.DocumentListenerSelector;
import qlProject.gui.listeners.ItemListenerSelector;
import qlProject.gui.listeners.ListenerSelector;
import qlProject.util.QuestionDetails;

public class WidgetBindingVisitor implements ITypeVisitor {

	private final Map<String, QuestionWidget> questionWidgetsMap;
	private final String observedId;
	private final InputInterpreter interpreter;	
	
	public WidgetBindingVisitor(Map<String, QuestionDetails> questionsDetails, Map<String, QuestionWidget> questionWidgetsMap, String observedId, Map<String, Value> valuesEnvironment, Map<String,Set<String>> awaitingCalculationIds){
		this.questionWidgetsMap = questionWidgetsMap;
		this.observedId = observedId;
	    interpreter = new InputInterpreter(questionsDetails, questionWidgetsMap, valuesEnvironment, awaitingCalculationIds);
	}

	@Override
	public ListenerSelector visit (StringType t){
		return new DocumentListenerSelector(interpreter, questionWidgetsMap, observedId);
	}
		
	@Override
	public DocumentListenerSelector visit (IntType t){
		return new DocumentListenerSelector(interpreter, questionWidgetsMap, observedId);
	}
	
	@Override
	public ItemListenerSelector visit (BooleanType t){
		return new ItemListenerSelector(interpreter, questionWidgetsMap, observedId);
	}

}