// Generated from TaZQL.g4 by ANTLR 4.4
package grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TaZQLParser}.
 */
public interface TaZQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void enterQuestionnaire(@NotNull TaZQLParser.QuestionnaireContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#questionnaire}.
	 * @param ctx the parse tree
	 */
	void exitQuestionnaire(@NotNull TaZQLParser.QuestionnaireContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanType}
	 * labeled alternative in {@link TaZQLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterBooleanType(@NotNull TaZQLParser.BooleanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanType}
	 * labeled alternative in {@link TaZQLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitBooleanType(@NotNull TaZQLParser.BooleanTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifelseStatement}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterIfelseStatement(@NotNull TaZQLParser.IfelseStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifelseStatement}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitIfelseStatement(@NotNull TaZQLParser.IfelseStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerType}
	 * labeled alternative in {@link TaZQLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterIntegerType(@NotNull TaZQLParser.IntegerTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerType}
	 * labeled alternative in {@link TaZQLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitIntegerType(@NotNull TaZQLParser.IntegerTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equationExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEquationExpression(@NotNull TaZQLParser.EquationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equationExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEquationExpression(@NotNull TaZQLParser.EquationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketsExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBracketsExpression(@NotNull TaZQLParser.BracketsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketsExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBracketsExpression(@NotNull TaZQLParser.BracketsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multDivExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultDivExpression(@NotNull TaZQLParser.MultDivExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multDivExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultDivExpression(@NotNull TaZQLParser.MultDivExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(@NotNull TaZQLParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(@NotNull TaZQLParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(@NotNull TaZQLParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(@NotNull TaZQLParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleQuestion}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterSimpleQuestion(@NotNull TaZQLParser.SimpleQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleQuestion}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitSimpleQuestion(@NotNull TaZQLParser.SimpleQuestionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(@NotNull TaZQLParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(@NotNull TaZQLParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber(@NotNull TaZQLParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber(@NotNull TaZQLParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparissionExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparissionExpression(@NotNull TaZQLParser.ComparissionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparissionExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparissionExpression(@NotNull TaZQLParser.ComparissionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(@NotNull TaZQLParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(@NotNull TaZQLParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code computationQuestion}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void enterComputationQuestion(@NotNull TaZQLParser.ComputationQuestionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code computationQuestion}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 */
	void exitComputationQuestion(@NotNull TaZQLParser.ComputationQuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TaZQLParser#form}.
	 * @param ctx the parse tree
	 */
	void enterForm(@NotNull TaZQLParser.FormContext ctx);
	/**
	 * Exit a parse tree produced by {@link TaZQLParser#form}.
	 * @param ctx the parse tree
	 */
	void exitForm(@NotNull TaZQLParser.FormContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpression(@NotNull TaZQLParser.AddSubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpression(@NotNull TaZQLParser.AddSubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link TaZQLParser#type}.
	 * @param ctx the parse tree
	 */
	void enterStringType(@NotNull TaZQLParser.StringTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link TaZQLParser#type}.
	 * @param ctx the parse tree
	 */
	void exitStringType(@NotNull TaZQLParser.StringTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull TaZQLParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull TaZQLParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code text}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterText(@NotNull TaZQLParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code text}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitText(@NotNull TaZQLParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(@NotNull TaZQLParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(@NotNull TaZQLParser.UnaryExpressionContext ctx);
}