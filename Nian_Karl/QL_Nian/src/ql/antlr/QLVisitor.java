// Generated from QL.g4 by ANTLR 4.5
package ql.antlr;
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
	T visitForm(QLParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(QLParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(QLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(QLParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionType(QLParser.QuestionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#builtinType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinType(QLParser.BuiltinTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#userType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserType(QLParser.UserTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionName(QLParser.QuestionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#questionLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestionLabel(QLParser.QuestionLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(QLParser.IfstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(QLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(QLParser.LiteralContext ctx);
}