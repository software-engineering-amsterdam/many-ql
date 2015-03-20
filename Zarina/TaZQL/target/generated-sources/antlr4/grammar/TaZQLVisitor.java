// Generated from TaZQL.g4 by ANTLR 4.4
package grammar;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TaZQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TaZQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#questionnaire}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionnaire(@NotNull TaZQLParser.QuestionnaireContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanType}
	 * labeled alternative in {@link TaZQLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanType(@NotNull TaZQLParser.BooleanTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifelseStatement}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfelseStatement(@NotNull TaZQLParser.IfelseStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerType}
	 * labeled alternative in {@link TaZQLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerType(@NotNull TaZQLParser.IntegerTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equationExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquationExpression(@NotNull TaZQLParser.EquationExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketsExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketsExpression(@NotNull TaZQLParser.BracketsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDivExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivExpression(@NotNull TaZQLParser.MultDivExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(@NotNull TaZQLParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(@NotNull TaZQLParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpleQuestion}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleQuestion(@NotNull TaZQLParser.SimpleQuestionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrExpression(@NotNull TaZQLParser.OrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull TaZQLParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparissionExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparissionExpression(@NotNull TaZQLParser.ComparissionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndExpression(@NotNull TaZQLParser.AndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code computationQuestion}
	 * labeled alternative in {@link TaZQLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputationQuestion(@NotNull TaZQLParser.ComputationQuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TaZQLParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(@NotNull TaZQLParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpression(@NotNull TaZQLParser.AddSubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringType}
	 * labeled alternative in {@link TaZQLParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringType(@NotNull TaZQLParser.StringTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull TaZQLParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code text}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(@NotNull TaZQLParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link TaZQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(@NotNull TaZQLParser.UnaryExpressionContext ctx);
}