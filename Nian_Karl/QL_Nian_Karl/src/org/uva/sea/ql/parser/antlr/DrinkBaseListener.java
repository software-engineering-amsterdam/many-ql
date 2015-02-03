package org.uva.sea.ql.parser.antlr;

// Generated from Drink.g by ANTLR 4.5

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link DrinkListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class DrinkBaseListener implements DrinkListener {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDrinkSentence(DrinkParser.DrinkSentenceContext ctx) {
//		System.out.print("1. ");
		System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDrinkSentence(DrinkParser.DrinkSentenceContext ctx) {
//		System.out.print("2. ");
//		System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDrink(DrinkParser.DrinkContext ctx) {
//		System.out.print("3. ");
//		System.out.println(ctx.getText());
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDrink(DrinkParser.DrinkContext ctx) {
//		System.out.print("4. ");
//		System.out.println(ctx.getText());
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { 
//		System.out.print("5. ");
//		System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) {
//		System.out.print("6. ");
//		System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) {
		System.out.print("7. ");
		System.out.println(node.getText() );
		
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}