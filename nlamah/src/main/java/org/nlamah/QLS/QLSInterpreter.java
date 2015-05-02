package org.nlamah.QLS;

import java.util.BitSet;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.nlamah.QBase.FileReadException;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QLS.Builders.RawStyleSheetBuilder;
import org.nlamah.QLS.Model.StylesheetBlock.QLStylesheet;

public class QLSInterpreter implements ANTLRErrorListener 
{
	public QLStylesheet interprete(String qlsFileName, Form form) throws FileReadException, QLSException
	{
		String qlsSourceCode;

		qlsSourceCode = QBaseHelper.getSourceCode(qlsFileName);

		ParseTree tree = createParseTreeFromSourceCode(qlsSourceCode);
		
		RawStyleSheetBuilder rawStylesheetBuilder = new RawStyleSheetBuilder();
		QLStylesheet stylesheet = rawStylesheetBuilder.build(tree);
		
		//QLSTypeChecker qlsTypeChecker = new QLSTypeChecker();
		//qlsTypeChecker.check(form, stylesheet);

		return stylesheet;
	}

	private ParseTree createParseTreeFromSourceCode(String sourceCode)
	{
		ANTLRInputStream input = new ANTLRInputStream(sourceCode);

		QLSLexer lexer = new QLSLexer(input);

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		QLSParser parser = new QLSParser(tokens);

		parser.addErrorListener(this);

		return parser.stylesheet();
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) 
	{
		// TODO Auto-generated method stub	
	}

	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) 
	{
		// TODO Auto-generated method stub	
	}
}
