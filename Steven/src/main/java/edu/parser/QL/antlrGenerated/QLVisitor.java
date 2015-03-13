// Generated from E:/development/Steven/src/test/resources/antlr/grammars\QL.g4 by ANTLR 4.5
package edu.parser.QL.antlrGenerated;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link QLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link QLParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(@NotNull QLParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by the {@code questionLabel}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionLabel(@NotNull QLParser.QuestionLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if_statementLabel}
	 * labeled alternative in {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statementLabel(@NotNull QLParser.If_statementLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(@NotNull QLParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#else_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_clause(@NotNull QLParser.Else_clauseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterOrEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterOrEqual(@NotNull QLParser.GreaterOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numbersLabel}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumbersLabel(@NotNull QLParser.NumbersLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code or}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull QLParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessOrEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessOrEqual(@NotNull QLParser.LessOrEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierLabel}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierLabel(@NotNull QLParser.IdentifierLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subtraction}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubtraction(@NotNull QLParser.SubtractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notEqual}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotEqual(@NotNull QLParser.NotEqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(@NotNull QLParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code division}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(@NotNull QLParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equal}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual(@NotNull QLParser.EqualContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negationLabel}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationLabel(@NotNull QLParser.NegationLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code and}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull QLParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lessThan}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThan(@NotNull QLParser.LessThanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplication}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplication(@NotNull QLParser.MultiplicationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpressionLabel}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpressionLabel(@NotNull QLParser.BooleanExpressionLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addition}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddition(@NotNull QLParser.AdditionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greaterThan}
	 * labeled alternative in {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThan(@NotNull QLParser.GreaterThanContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(@NotNull QLParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(@NotNull QLParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(@NotNull QLParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#question_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion_expression(@NotNull QLParser.Question_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#question_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion_type(@NotNull QLParser.Question_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#question_label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion_label(@NotNull QLParser.Question_labelContext ctx);
}