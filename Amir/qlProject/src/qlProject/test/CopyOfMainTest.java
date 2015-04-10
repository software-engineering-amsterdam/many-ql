////hasSoldHouse "Did you SELL a house in 2014?" boolean
////if (hasSoldHouse) {
////money4 "mon4 txt" integer
////money5 "mon5 txt" integer
////}
////hasBoughtHouse "Did you BUY a house in 2014?" boolean
////money1 "mon1 txt" integer
////if (3 > 1) {
////money2 "mon2 txt" integer
////money3 "mon3 txt" integer
////}
////testingLabels "label test" integer ( money1 + 5)
////testingLabels2 "label test3" integer ( money1 + money2)
//
////money4 "mon4 txt" integer (money2 > false)
//// Things I could test:      	      transitive closure function		//add to question: is nested
//
//
////hasSoldHouse "Did you SELL a house in 2014?" boolean
////if (hasSoldHouse) {
////money4 "mon4 txt" integer
////money5 "mon5 txt" integer
////}
////hasBoughtHouse "Did you BUY a house in 2014?" boolean
////money1 "mon1 txt" integer
////if (3 > 1) {
////money2 "mon2 txt" integer
////money3 "mon3 txt" integer
////}
////testingLabels "label test" integer ( money1 + 5)
////testingLabels2 "label test3" integer ( money1 + money2)
//
//
////money2 "mon2 txt" integer (money2)
////hasSoldHouse "Did you SELL a house in 2014?" 
////boolean
////if (3 + 1) {
////money2 "mon2 txt" boolean 
////}
////hasSoldHouse "Did you SELL a house in 2014?" 
////boolean
////if (hasSoldHouse2) {
////money4 "mon4 txt" integer (money2 + hasSoldHouse)
////money4 "mon4 txt" boolean
////}
////hasBoughtHouse "Did you BUY a house in 2014?" boolean
////money1 "mon1 txt" integer
//
//package qlProject.test;
//
//
//
////money4 "mon4 txt" integer (money2 > false)
//// Things I could test:      	      transitive closure function		//add to question: is nested
//import static org.junit.Assert.*;
//
//import java.util.Set;
//
//import org.junit.Test;
//
//import qlProject.ast.Questionnaire;
//import qlProject.ast.statement.assignment.DirectAssignment;
//import qlProject.ast.statement.assignment.ComputedAssignment;
//import qlProject.ast.statement.if_statement.IfStatement;
//import qlProject.ast.statement.if_statement.IIfStatement;
//import qlProject.grammar.ParserToASTVisitor;
//import qlProject.grammar.qlGrammarLexer;
//import qlProject.grammar.qlGrammarParser;
//import qlProject.typeChecking.typeCheckVisitors.EnvironmentsLoadingVisitor;
//import qlProject.typeChecking.typeCheckVisitors.StatementsTypeCheckVisitor;
//import qlProject.util.QuestionnaireStorageElement;
//
//import java.io.File;
//
//import org.antlr.v4.runtime.ANTLRInputStream;
//import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.tree.ParseTree;
//import org.apache.commons.io.FileUtils;
//
//public class CopyOfMainTest {
//
//	public static QuestionnaireStorageElement dataStorage;
//
//	static public String tmp = "";
//
//	private CopyOfMainTest()
//	{
//	}
//
//	static void populateQuestions(){
//		EnvironmentsLoadingVisitor questionsPopulator = new EnvironmentsLoadingVisitor(dataStorage);
//		for (IIfStatement block : dataStorage.getQuestionnaire().getNestedStatements()){
//			block.accept(questionsPopulator);
//		}
//		questionsPopulator.ExtractTransitiveClosureDependencies();
//	}
//
//	static void typeCheck(){
//		StatementsTypeCheckVisitor checker = new StatementsTypeCheckVisitor(dataStorage);
//		for (IIfStatement block : dataStorage.getQuestionnaire().getNestedStatements()){
//			block.accept(checker);
//		}
//		checker.showComplaints();
//	}
//
//	public static Questionnaire createQuestionnaireFromInput(String input){
//		dataStorage = new QuestionnaireStorageElement();
//		ANTLRInputStream bb = new ANTLRInputStream(input);
//		qlGrammarLexer lexer = new qlGrammarLexer(bb);
//		CommonTokenStream tokens = new CommonTokenStream( lexer );
//		qlGrammarParser parser = new qlGrammarParser( tokens );
//		ParseTree tree = parser.form() ;
//		System.out.println(tree.toStringTree(parser));
//		ParserToASTVisitor formBuilder = new ParserToASTVisitor();
//		return (Questionnaire)formBuilder.visit(tree);
//	}
//
//	public static void main(String[] args) {
//		try
//		{
//			File input = new File("E:/tstst.txt");//		QuestionnaireBuilderVisitor formBuilder = new QuestionnaireBuilderVisitor();
//			String str = FileUtils.readFileToString(input);
//			Questionnaire questionnaire = createQuestionnaireFromInput(str);
//			dataStorage.setQuestionnaire(questionnaire);
//			populateQuestions();
//			typeCheck();
//			//    FormGUI.main(questionnaire);
//		} 
//		catch (Exception exc) {
//			System.err.println(exc.getMessage());
//		}
//	}
//
//	@Test 
//	public void getComputedExpressionVariablesTest(){
//		String testInput = "basicId1 \"txt1\" integer\n" +
//				"basicId2 \"txt2\" integer\n" +//***
//				"computedId3 \"txt3\" integer (basicId1 + basicId2)";
//		if (!dataStorage.getNestedStatements().containsKey("computedId3")){
//			createQuestionnaireFromInput(testInput);
//			ComputedAssignment question = (ComputedAssignment)dataStorage.getNestedStatements().get("computedId3");
//			Set<String> vars = question.getExpressionVariables();
//			assertTrue(vars.contains("basicId1"));
//			assertTrue(vars.contains("basicId2"));
//		}
//	}
//
//	@Test
//	public void documentComputationVariablesTest(){
//		String testInput = "basicId1 \"txt1\" integer\n" +
//				"basicId2 \"txt2\" integer\n" +
//				"computedId3 \"txt3\" integer (basicId1 + basicId2)";
//		if (!dataStorage.getNestedStatements().containsKey("computedId3")){
//			assertFalse (dataStorage.getDependencies2().containsKey("computedId3"));
//			assertFalse (dataStorage.getDependencies2().get("computedId3").contains("basicId1"));
//			assertFalse (dataStorage.getDependencies2().get("computedId3").contains("basicId2"));
//			createQuestionnaireFromInput(testInput);
//			populateQuestions();
//			ComputedAssignment question = (ComputedAssignment)dataStorage.getNestedStatements().get("computedId3");
//			question.documentExpressionVariables(dataStorage.getDependencies2());
//			assertTrue (dataStorage.getDependencies2().containsKey("computedId3"));
//			assertTrue (dataStorage.getDependencies2().get("computedId3").contains("basicId1"));
//			assertTrue (dataStorage.getDependencies2().get("computedId3").contains("basicId2"));
//		}
//	}
//
//	@Test 
//	public void getConditionVariablesTest(){
//		String testInput = "basicId1 \"txt1\" boolean\n" +
//				"if (basicId1) {\n" +
//				"basicId2 \"txt2\" integer\n" +
//				"basicId3 \"txt3\" integer\n"+
//				"}";
//		if (!dataStorage.getNestedStatements().containsKey("computedId3")){
//			Questionnaire questionnaire = createQuestionnaireFromInput(testInput);
//			IfStatement list = ((IfStatement)questionnaire.getStatements().get(1));
//			Set<String> vars = list.getExpressionVariables();
//			assertTrue(vars.contains("basicId1"));
//			assertTrue(vars.contains("basicId2"));
//		}
//	}
//
//	@Test
//	public void documentConditionVariablesTest(){
//		String testInput = "basicId1 \"txt1\" boolean\n" +
//				"if (basicId1) {\n" +
//				"basicId2 \"txt2\" integer\n" +
//				"basicId3 \"txt3\" integer\n"+
//				"}";
//
//		if (!dataStorage.getNestedStatements().containsKey("computedId3")){
//			assertFalse (dataStorage.getDependencies2().containsKey("basicId2"));
//			assertFalse (dataStorage.getDependencies2().get("computedId3").contains("basicId2"));
//			assertFalse (dataStorage.getDependencies2().get("computedId3").contains("basicId3"));
//			Questionnaire questionnaire = createQuestionnaireFromInput(testInput);
//			populateQuestions();
//			IfStatement list = ((IfStatement)questionnaire.getStatements().get(1));
//			list.documentExpressionVariables(dataStorage.getDependencies2());
//				assertTrue (dataStorage.getDependencies2().containsKey("basicId2"));
//				assertTrue (dataStorage.getDependencies2().get("computedId3").contains("basicId2"));
//				assertTrue (dataStorage.getDependencies2().get("computedId3").contains("basicId3"));
//			}
//		}
//
//	@Test
//	public void basicQuestionEqualsTest()
//	{
//		DirectAssignment question = new DirectAssignment( null, null, null, null );
//		DirectAssignment question2 = new DirectAssignment( null, null, null, null );
//		assertTrue( question.equals( question2 ) );
//	}
//
//	public void questionPopulatorVisitorTest(){
//		EnvironmentsLoadingVisitor visitor = new EnvironmentsLoadingVisitor(null);
//		visitor.ExtractTransitiveClosureDependencies();
//	}
//
//	public void updateEnvironmentTest(){
//
//	}
//
//	public void populateQuestionsTest(){
//
//	}
//
//	public void typeCheckTest(){
//
//	}
//
//	public void astBuilderTest(){
//
//	}
//
//	public void conditionIsBooleanTypeCheckTest(){
//
//	}
//
//	public void operationsOperandsMatchingCheckTest(){
//
//	}
//
//	public void duplicateLabelCheckTest(){
//
//	}
//
//	public void duplicatesTypeClashCheckTest(){
//
//	}
//
//	public void cyclicReferenceCheckTest(){
//
//	}
//
//	public void undefinedIdentifierCheckTest(){
//
//	}
//
//}