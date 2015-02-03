// Generated from /Users/bore/Projects/SoftwareConstruction/many-ql/bg-nv/src/QL.g4 by ANTLR 4.5
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link QLParser}.
 */
public interface QLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link QLParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(@NotNull QLParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link QLParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(@NotNull QLParser.RContext ctx);
}