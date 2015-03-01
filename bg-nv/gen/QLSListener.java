// Generated from /Users/bore/Projects/SoftwareConstruction/many-ql/bg-nv/src/lang/qls/syntax/QLS.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLSParser}.
 */
public interface QLSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(@NotNull QLSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(@NotNull QLSParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(@NotNull QLSParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(@NotNull QLSParser.PageContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(@NotNull QLSParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(@NotNull QLSParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(@NotNull QLSParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(@NotNull QLSParser.QuestionContext ctx);
}