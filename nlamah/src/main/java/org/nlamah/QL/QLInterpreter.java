package org.nlamah.QL;

import java.io.InputStream;
import java.util.ArrayList;
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
import org.apache.commons.io.IOUtils;
import org.nlamah.QBase.QBaseError;
import org.nlamah.QL.Model.Error.QLException;
import org.nlamah.QL.Model.Error.Parsing.AmbiguityError;
import org.nlamah.QL.Model.Error.Parsing.AttemptingFullContextError;
import org.nlamah.QL.Model.Error.Parsing.ContextSensitivityError;
import org.nlamah.QL.Model.Error.Parsing.FileReadError;
import org.nlamah.QL.Model.Error.Parsing.SyntaxError;
import org.nlamah.QL.Model.Form.Form;

public class QLInterpreter implements ANTLRErrorListener 
{
	private String qlFileName;
	
	private ArrayList<QBaseError> parsingErrors;
	
	public QLInterpreter()
	{
		super();
		
		parsingErrors = new ArrayList<QBaseError>();
	}
	
	public Form interprete(String qlFileName) throws QLException
	{
		this.qlFileName = qlFileName;
		
		String sourceCode = this.getSourceCode();
		
		ParseTree tree = this.createParseTreeFromSourceCode(sourceCode);
		
		RawFormBuilder rawFormBuilder = new RawFormBuilder(tree);
		
		Form form = null;
		
		form = rawFormBuilder.rawForm();
		
		parsingErrors.addAll(rawFormBuilder.errors());
		
		if (parsingErrors.size() > 0)
		{
			throw new QLException(parsingErrors);
		}
			
		return form;
	}
	
	private String getSourceCode() throws QLException
    {
		String qlSourceCode = "";
		
		try 
		{
			InputStream fileInputStream = QLInterpreter.class.getResourceAsStream(qlFileName);
			qlSourceCode = IOUtils.toString(fileInputStream, "UTF-8");
		} 
		catch (Exception e) 
		{	
			parsingErrors.add(new FileReadError(qlFileName));
		}
		
		return qlSourceCode;
    }
    
    private ParseTree createParseTreeFromSourceCode(String sourceCode)
    {
    	ANTLRInputStream input = new ANTLRInputStream(sourceCode);

		QLLexer lexer = new QLLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		QLParser parser = new QLParser(tokens);
		
		parser.addErrorListener(this);
		
    	return parser.form();
    }

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) 
	{
		parsingErrors.add(new SyntaxError(line, charPositionInLine, msg));
	}

	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) 
	{
		parsingErrors.add(new AmbiguityError(startIndex, stopIndex));
	}

	@Override
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) 
	{
		parsingErrors.add(new AttemptingFullContextError(startIndex, stopIndex));
	}

	@Override
	public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) 
	{
		parsingErrors.add(new ContextSensitivityError(startIndex, stopIndex));
	}   
}