package qlProject.typeChecking;

import qlProject.ast.Questionnaire;
import qlProject.ast.value.Value;
import qlProject.typeChecking.complaints.Complaint;
import qlProject.typeChecking.typeCheckVisitors.QuestionsStoringVisitor;
import qlProject.typeChecking.typeCheckVisitors.StatementsTypeCheckVisitor;
import qlProject.util.QuestionDetails;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TypeCheckManager {

	private Questionnaire questionnaire;
	private Map<String,QuestionDetails> questionsDetails;
	private Map<String, Value> valuesEnvironment;
	private Map<String,Set<String>> dependencies;
	private Map<String,Set<String>> awaitingCalculationIds;
	private final HashSet<Complaint> complaints = new HashSet<Complaint>();

	public TypeCheckManager(Questionnaire questionnaire, Map<String, QuestionDetails> questionsDetails, Map<String, Value> valuesEnvironment, 
			Map<String, Set<String>> dependencies, Map<String, Set<String>> awaitingCalculationIds){
		this.questionnaire = questionnaire;
		this.questionsDetails = questionsDetails;
		this.valuesEnvironment = valuesEnvironment;
		this.dependencies = dependencies;
		this.awaitingCalculationIds = awaitingCalculationIds;
	}

	public void manageTypeChecking(){

		/*A visitor for storing the questions info in maps, 
		 * also collects complaints about already existing elements */
		QuestionsStoringVisitor questionsStoringVisitor = new QuestionsStoringVisitor(
				questionsDetails, valuesEnvironment, dependencies, complaints, awaitingCalculationIds);
		questionnaire.accept(questionsStoringVisitor);

		/*after the data environment are initiated and populated, the transitive
		 * dependencies have to be added, which is done by the function called next */
		questionsStoringVisitor.extractTransitiveClosureDependencies();

		/*A visitor for checking compatibility between expressions' and questions' types
		 * When an expression is present, the expression type checker is then being used */ 
		StatementsTypeCheckVisitor checker = new StatementsTypeCheckVisitor(questionsDetails, complaints, dependencies);
		questionnaire.accept(checker);

		checker.showComplaints();
	}
}