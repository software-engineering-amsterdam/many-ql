// Generated from /Users/lukaszharezlak/Projects/uva_software_construction/many-ql/Fugazi/src/org/fugazi/grammar/ql.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link qlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface qlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link qlParser#form}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForm(@NotNull qlParser.FormContext ctx);
	/**
	 * Visit a parse tree produced by {@link qlParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(@NotNull qlParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link qlParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(@NotNull qlParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link qlParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(@NotNull qlParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link qlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(@NotNull qlParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link qlParser#logical_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_expression(@NotNull qlParser.Logical_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link qlParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(@NotNull qlParser.ValueContext ctx);
}