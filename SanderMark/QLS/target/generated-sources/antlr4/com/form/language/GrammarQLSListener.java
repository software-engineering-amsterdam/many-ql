// Generated from GrammarQLS.g4 by ANTLR 4.5
package com.form.language;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarQLSParser}.
 */
public interface GrammarQLSListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarQLSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(GrammarQLSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarQLSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(GrammarQLSParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarQLSParser#pageList}.
	 * @param ctx the parse tree
	 */
	void enterPageList(GrammarQLSParser.PageListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarQLSParser#pageList}.
	 * @param ctx the parse tree
	 */
	void exitPageList(GrammarQLSParser.PageListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarQLSParser#page}.
	 * @param ctx the parse tree
	 */
	void enterPage(GrammarQLSParser.PageContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarQLSParser#page}.
	 * @param ctx the parse tree
	 */
	void exitPage(GrammarQLSParser.PageContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarQLSParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(GrammarQLSParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarQLSParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(GrammarQLSParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarQLSParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GrammarQLSParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarQLSParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GrammarQLSParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarQLSParser#sectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterSectionStatement(GrammarQLSParser.SectionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarQLSParser#sectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitSectionStatement(GrammarQLSParser.SectionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarQLSParser#questionStatement}.
	 * @param ctx the parse tree
	 */
	void enterQuestionStatement(GrammarQLSParser.QuestionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarQLSParser#questionStatement}.
	 * @param ctx the parse tree
	 */
	void exitQuestionStatement(GrammarQLSParser.QuestionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarQLSParser#defaultStatement}.
	 * @param ctx the parse tree
	 */
	void enterDefaultStatement(GrammarQLSParser.DefaultStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarQLSParser#defaultStatement}.
	 * @param ctx the parse tree
	 */
	void exitDefaultStatement(GrammarQLSParser.DefaultStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarQLSParser#styleList}.
	 * @param ctx the parse tree
	 */
	void enterStyleList(GrammarQLSParser.StyleListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarQLSParser#styleList}.
	 * @param ctx the parse tree
	 */
	void exitStyleList(GrammarQLSParser.StyleListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarQLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void enterWidget(GrammarQLSParser.WidgetContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarQLSParser#widget}.
	 * @param ctx the parse tree
	 */
	void exitWidget(GrammarQLSParser.WidgetContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarQLSParser#specificWidget}.
	 * @param ctx the parse tree
	 */
	void enterSpecificWidget(GrammarQLSParser.SpecificWidgetContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarQLSParser#specificWidget}.
	 * @param ctx the parse tree
	 */
	void exitSpecificWidget(GrammarQLSParser.SpecificWidgetContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarQLSParser#style}.
	 * @param ctx the parse tree
	 */
	void enterStyle(GrammarQLSParser.StyleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarQLSParser#style}.
	 * @param ctx the parse tree
	 */
	void exitStyle(GrammarQLSParser.StyleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarQLSParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrammarQLSParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarQLSParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarQLSParser.TypeContext ctx);
}