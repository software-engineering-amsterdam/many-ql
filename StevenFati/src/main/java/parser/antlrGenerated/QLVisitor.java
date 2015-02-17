// Generated from E:/development/StevenFati/src/main/antlr/grammers\QL.g4 by ANTLR 4.5
package parser.antlrGenerated;
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
	 * Visit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull QLParser.StatementContext ctx);
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
	 * Visit a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull QLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(@NotNull QLParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(@NotNull QLParser.OperatorContext ctx);
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