package project.typeChecking;

import java.util.*;

import project.TypeCheckVisitor;
import project.ast.FormObject;
import project.ast.IGlobalElement;
import project.ast.boxs.BoxObject;
import project.ast.boxs.GlobalBox;
import project.ast.boxs.IfBox;
import project.ast.boxs.IfElseBox;
import project.ast.expression.Expression;
import project.ast.question.BasicQuestion;
import project.ast.question.ComputedQuestion;
import project.ast.question.Question;
import project.ast.value.BooleanTypeValue;
import project.ast.value.NullTypeValue;
import project.ast.value.TypeValue;
import project.main.QuestionPopulatorVisitor;

public class TypeChecker {
	public List<String> labelsEnvironment;
	public HashMap<String, Question> questionsEnvironment = new HashMap<String,Question>();;
	public Map<String,TypeValue> TypeValueEnvironment = new HashMap<String, TypeValue>();
	public FormObject questionnaire;
	public HashSet<ErrorObject> errors = new HashSet<ErrorObject>();
	public Map<IGlobalElement,HashSet<ErrorObject>> errorri = new HashMap<IGlobalElement,HashSet<ErrorObject>>();
	public TypeChecker()
	{
		
	}

	/*
//...  operands of invalid type to operators			// (Y)  references to questions with an undefined value - how can I do it.
//  cyclic dependencies between questions
	 */

	public TypeChecker(HashSet<ErrorObject> errors) {
		this.errors = errors;
	}

	public TypeChecker(QuestionPopulatorVisitor visitor){
		this.labelsEnvironment = visitor.labelsEnvironment;// change to getter
		this.questionsEnvironment = visitor.questionsEnvironment;
		this.TypeValueEnvironment = visitor.TypeValueEnvironment;
		this.errorri = visitor.errorri;
		this.errors = visitor.errors3;
	}

	public void visit(FormObject questionnaire){
		this.questionnaire = questionnaire;
		for (GlobalBox box : questionnaire.getBoxs()){
			box.accept(this);
		}
	}
	
	public void showErrors(){
		for (ErrorObject er : errors){
			System.out.println("Message: "+er.errorMessage);
		}
	}
	
	public void visit(List<Question> questionsList){
		for (Question question : questionsList){
			question.accept(this);
		}
	}

	public void visit (ComputedQuestion question){
//		HashSet<ErrorObject> errors2 = new HashSet<ErrorObject>();
		checkDependencies(question);							//		documentDependencies(question);
		errors.addAll(question.expr.accept(new TypeCheckVisitor(TypeValueEnvironment)));
		errorri.put(question, question.expr.accept(new TypeCheckVisitor(TypeValueEnvironment)));
        if (question.expr.getType().equals(question.getType2())){
        	if (errorri.containsKey(question)){
        	errorri.get(question).add(new ErrorObject("Error: the expression of question: " + question.getQuestionText() + "seems to be of type: " + question.expr.getType() + "but was expected to be of type " + question.getType2()));
        	errors.add(new ErrorObject("Error: the expression of question: " + question.getQuestionText() + "seems to be of type: " + question.expr.getType() + "but was expected to be of type " + question.getType2()));
        	}
        	else 
        		errors.add(new ErrorObject("Error: the expression of question: " + question.getQuestionText() + "seems to be of type: " + question.expr.getType() + "but was expected to be of type " + question.getType2()));
        		errorri.put(question, errors);
        }
	}

	public void visit (BasicQuestion question){	
	}

	public void visit (IfBox ifBox){
		for (Question subQuestion : ifBox.ifTrueList){
			subQuestion.accept(this);
		}
		for (Question subQuestion : ifBox.elseList){
			subQuestion.accept(this);
		}
		errors.addAll(checkCondition(ifBox.condition));
		errorri.put(ifBox, checkCondition(ifBox.condition));

		//		if (checkCondition(ifBox.condition)) {
//			errorri.put(ifBox, new HashSet<ErrorObject>(Arrays.asList(new ErrorObject ("condition should be of type boolean but is actually of type X/Undefined"))));
//			}
		}

	public void visit(BoxObject boxObject) {
		for (Question question : boxObject.questionsList){
			question.accept(this);
		}
	}

	public void visit (IfElseBox ifElseBox){
//		documentDependencies(question);// add this to the populateEnvironments?
//		//if not null:			//					jtxt.setText("" + cq.arithmeticExpr.accept(new BooleanExpressionEvaluationVisitor(tempVarsColl2)));
//		checkDependencies(question);
//		for (Question subQuestion : question.isTrueList){
//			subQuestion.accept(this);
//		}
//		checkCondition(ifElseBox.condition);
	}

	public void checkTypeClash(Question question){
		if (questionsEnvironment.containsKey(question.getId()) && //){ if (// &
				question.getType().typeName() == 
				questionsEnvironment.get(question.getId()).getType().typeName()){
//			throw exception "type clash at: ... same question already declared as type"
		}	
	}
	
	public void checkLabelClash(Question question){
		if (labelsEnvironment.contains(question.getQuestionText())){//question.getType().typeName() == 
//			throw warning "this label is already used"
		}
	}

	public void typeCheckQuestion(Question question){
		checkTypeClash(question);
		checkLabelClash(question);
	}

	public HashSet<ErrorObject> checkCondition(Expression boolExpr){
		HashSet<ErrorObject> errors = new HashSet<ErrorObject>();
		errors.addAll(boolExpr.accept(new TypeCheckVisitor(TypeValueEnvironment)));
        if (!(boolExpr.getType().isType(new NullTypeValue()))){
			if (!(boolExpr.getType().isType(new BooleanTypeValue()))){
				errors.add(new ErrorObject("Error: the condition of this box must be of type boolean, but appears to be of type: " + boolExpr.getType()+"toString"));	
			}
		}
		return errors; 
	}
	
	public void checkDependencies(Question question){
//		HashSet<ErrorObject> errors2 = new HashSet<ErrorObject>();
		for (String idString : question.getExpressionVariables()){
			if (questionnaire.dependenciesMap.containsKey(idString)){		//				System.out.println("CALLING:: "+question.getId());				System.out.println("CALLED:: "+idString);				System.out.println("LLOOKK:: "+	questionnaire.dependenciesMap.get(idString));
				
				if (questionnaire.dependenciesMap.get(idString).equals(question.getId())){
					System.out.println("100%");
					if (errorri.containsKey(question)){
						System.out.println("size errors before: "+ (errorri.get(question)).size());
						errorri.get(question).add(new ErrorObject ("Error: Cyclic reference/n" + "variable: " + idString + "refers directly or indirectly to: " + question.getId()));
						errors.add(new ErrorObject ("Error: Cyclic reference/n" + "variable: " + idString + "refers directly or indirectly to: " + question.getId()));
						System.out.println("size errors after: "+ (errorri.get(question)).size());
//						errorri.put(question, (errorri.get(question)));
				}
					else 
//						System.out.println("errorsnumber: "+errors.size());
						errors.add(new ErrorObject ("Error: Cyclic reference/n" + "variable: " + idString + "refers directly or indirectly to: " + question.getId()));
						errors.add(new ErrorObject ("Error: Cyclic reference/n" + "variable: " + idString + "refers directly or indirectly to: " + question.getId()));
					System.out.println("errorsnumber: "+errors.size());
					errorri.put(question, errors);
					System.out.println("numbernumber: "+errorri.get(question).size());
//					errorri.put(question, new HashSet<ErrorObject>(							Arrays.asList(new ErrorObject ("Error: Cyclic reference/n" + "variable: " + idString + "refers directly or indirectly to: " + question.getId()))));
					System.out.println("Error: Cyclic reference/n" + "variable: " + idString + "refers directly or indirectly to: ");
					for (ErrorObject er : errors){
					System.out.println(er.errorMessage);//."Error: Cyclic reference/n" + "variable: " + idString + "refers directly or indirectly to: ");
					}
				}
			}
		}
//		this.errors = errors;
	}
}	
	
	
	
	
