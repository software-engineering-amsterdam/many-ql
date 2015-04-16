package qlProject.typeChecking.typeCheckVisitors;

import java.util.*;

import qlProject.ast.Questionnaire;
import qlProject.ast.statement.IStatement;
import qlProject.ast.statement.IStatementsVisitor;
import qlProject.ast.statement.IfStatement;
import qlProject.ast.statement.assignment.Assignment;
import qlProject.ast.statement.assignment.ComputedAssignment;
import qlProject.ast.statement.assignment.DirectAssignment;
import qlProject.ast.type.Type;
import qlProject.ast.value.Value;
import qlProject.gui.gui_building_visitors.DefaultValueVisitor;
import qlProject.typeChecking.complaints.Complaint;
import qlProject.typeChecking.complaints.expression_level_complaint.CyclicReferenceError;
import qlProject.typeChecking.complaints.statement_level_complaint.DuplicateLabelsWarning;
import qlProject.typeChecking.complaints.statement_level_complaint.TypeClashingDuplicateQsError;
import qlProject.util.QuestionDetails;

public class QuestionsStoringVisitor implements IStatementsVisitor {

	private final Map<String,Set<String>> deps;
	private final List<String> labelsEnvironment = new ArrayList<String>();
	private final HashSet<Complaint> complaints;
	private final Map<String,Set<String>> awaitingCalculationIds; 
	private final Map<String, QuestionDetails> questionsDetails;

	public QuestionsStoringVisitor(Map<String, QuestionDetails> questionsDetails, 
			Map<String, Value> valuesEnvironment, Map<String, Set<String>> deps, 
			HashSet<Complaint> complaints, Map<String,Set<String>> awaitingCalculationIds) {
		this.questionsDetails = questionsDetails;
		this.deps = deps;
		this.complaints = complaints;
		this.awaitingCalculationIds = awaitingCalculationIds;
	}

	@Override
	public void visit(Questionnaire q) {
		for (IStatement statement : q.getStatements()){
			statement.accept(this);
		}
	}
	
	@Override
	public void visit(IfStatement ifBox){

		for (IStatement question : ifBox.getIfTrueStatements()){
			question.accept(this);
		}
		for (IStatement question : ifBox.getIfFalseStatements()){
			question.accept(this);
		}
	}

	public void addDependency(String observer, String observed,Map<String,Set<String>> depMap){
		if (depMap.containsKey(observer)){
			if (!(depMap.get(observer).contains(observed))){// a set sod can be removed
			depMap.get(observer).add(observed);
			}
		}
		else {depMap.put(observer, new HashSet<String>());
			depMap.get(observer).add(observed);
		}
	}
	
	public void documentExpressionVariables(ComputedAssignment a, Map<String, Set<String>> dependenciesMap) {
		for (String observed : a.getExpressionVariables()){
			addDependency(a.getId(), observed, dependenciesMap);
		}
	}

	@Override
	public void visit (ComputedAssignment a){
		documentExpressionVariables(a, deps);
		processAssignment(a);
	}

	@Override
	public void visit (DirectAssignment a){
		processAssignment(a);
	}

	public void processAssignment(Assignment a){
		checkTypeClash(a);
		checkExistingLabel(a);
		storeToEnvironments(a);
	}

	public Value getDefaultValue(Type t){
		return (Value)t.accept(new DefaultValueVisitor());
	}
	
	
	public void storeToEnvironments(Assignment a){
		Value v = getDefaultValue(a.getType());
		QuestionDetails qDetails = new QuestionDetails(a, a.getId(), a.getQuestionText(),a.getType(),v);
		questionsDetails.put(a.getId(), qDetails);
		labelsEnvironment.add(a.getQuestionText());
	}

	public void checkExistingLabel(Assignment q){
		if (labelsEnvironment.contains(q.getQuestionText())){
			complaints.add(new DuplicateLabelsWarning (q.getQuestionText()));
		}
	}

	public void checkTypeClash(Assignment a){

		if (questionsDetails.containsKey(a.getId()) && 
				!(a.getType().equals(a.getType()))){

			complaints.add(new TypeClashingDuplicateQsError (a,
							questionsDetails.get(a.getId()).getQuestion()));
		}
	}

	/* The following methods extract the indirect dependencies between questions
	 * from <a,questionsA> -> <b,questionsB> <a,questionsA + >
	 * if questionsA[i] is b then questionsB are added to the collection questionsA
	 * possible problems of modifying a collection while it is being iterated over are solved 
	 * by storing them in * temporary collections and after the loop adding them 
	 * the **** collection ****
	 * 
	 */
	public void extractTransitiveClosureDependencies(){

		Map<String, Set<String>> indirectDependencies = new HashMap<String, Set<String>>();
		Map<String, Set<String>> intermediatingDependencies = new HashMap<String, Set<String>>();

		for(String observer : deps.keySet()){

			checkCyclicDependency(observer);

			for (String observedByObserver : deps.get(observer)){

				addTemporaryTransitiveReference(indirectDependencies, intermediatingDependencies, observer, observedByObserver);
			}
		}

		updateIndirectDependencies(indirectDependencies);
		updateIntermediatingDependencies(intermediatingDependencies);

		// TODO document the steps
		if (!indirectDependencies.isEmpty()){
			extractTransitiveClosureDependencies();
		}
	}


	public void checkCyclicDependency(String id){
		if (deps.get(id).contains(id)){
			complaints.add(new CyclicReferenceError(id));
		}
	}


	public void updateIndirectDependencies(Map<String, Set<String>> dMap){
		for (String observer : dMap.keySet()){
			deps.get(observer).addAll(dMap.get(observer));
		}
	}


	public void updateIntermediatingDependencies(Map<String, Set<String>> dMap){
		for (String observer : dMap.keySet()){
			deps.get(observer).removeAll(dMap.get(observer));
		}
	}


	public void addTemporaryTransitiveReference (Map<String, Set<String>> indirect, Map<String, Set<String>> intermediate, String observer, String observed){
		if (deps.keySet().contains(observed)){
			addIndirectDependencies(indirect, observer, observed);
			addIntermediaitingDependency(intermediate, observer, observed);
			addAwaitingCalculationId(observer, observed);
		}
	}


	public void addIndirectDependencies(Map<String, Set<String>> dMap, String observer, String observed){
		if (!dMap.keySet().contains(observer))
		{dMap.put(observer, new HashSet<String>());}
		dMap.get(observer).addAll(deps.get(observed));
	}


	public void addIntermediaitingDependency(Map<String, Set<String>> dMap, String observer, String observed){

		if (!dMap.keySet().contains(observer))
		{dMap.put(observer, new HashSet<String>());}
		// TODO wrong - no put
		dMap.get(observer).add(observed);
	}


	public void addAwaitingCalculationId(String observer, String observed){
		if (!awaitingCalculationIds.keySet().contains(observed))
		{awaitingCalculationIds.put(observed, new HashSet<String>());}
		awaitingCalculationIds.get(observed).add(observer);
	}
}