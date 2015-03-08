// Generated from nl\u005Cuva\bromance\parsers\QLS.g4 by ANTLR 4.5
package nl.uva.bromance.parsers;
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
	void enterStylesheet(QLSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(QLSParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(QLSParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(QLSParser.PageContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#pageBody}.
	 * @param ctx the parse tree
	 */
	void enterPageBody(QLSParser.PageBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#pageBody}.
	 * @param ctx the parse tree
	 */
	void exitPageBody(QLSParser.PageBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(QLSParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(QLSParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#sectionBody}.
	 * @param ctx the parse tree
	 */
	void enterSectionBody(QLSParser.SectionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#sectionBody}.
	 * @param ctx the parse tree
	 */
	void exitSectionBody(QLSParser.SectionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(QLSParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(QLSParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link QLSParser#questionBody}.
	 * @param ctx the parse tree
	 */
	void enterQuestionBody(QLSParser.QuestionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLSParser#questionBody}.
	 * @param ctx the parse tree
	 */
	void exitQuestionBody(QLSParser.QuestionBodyContext ctx);
}