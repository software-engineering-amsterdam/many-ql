package org.nlamah.QL;

import java.util.ArrayList;
import java.util.List;
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
import org.nlamah.QBase.QBaseError;
import org.nlamah.QBase.QBaseException;
import org.nlamah.QBase.QBaseHelper;
import org.nlamah.QBase.QBaseWarning;
import org.nlamah.QL.Builders.RawFormBuilder;
import org.nlamah.QL.Model.Error.QLException;
import org.nlamah.QL.Model.Error.Parsing.AmbiguityError;
import org.nlamah.QL.Model.Error.Parsing.AttemptingFullContextError;
import org.nlamah.QL.Model.Error.Parsing.ContextSensitivityError;
import org.nlamah.QL.Model.Error.Parsing.SyntaxError;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.TypeChecker.QLTypeChecker;

public class QLInterpreter implements ANTLRErrorListener 
{	
	private Form form;
	
	private List<QBaseWarning> warnings;
	private List<QBaseError> errors;
	
	public QLInterpreter()
	{
		super();
		
		warnings = new ArrayList<QBaseWarning>();
		errors = new ArrayList<QBaseError>();
	}
	
	public Form interprete(String sourceCodePath) throws FileReadException, QLException
	{		
		String sourceCode;
		
		sourceCode = QBaseHelper.getSourceCode(sourceCodePath);
		
		ParseTree tree = this.createParseTreeFromSourceCode(sourceCode);
		
		RawFormBuilder rawFormBuilder = new RawFormBuilder();
				
		form = rawFormBuilder.buildForm(tree);
		
		errors.addAll(rawFormBuilder.errors());
		
		if (errors.size() > 0)
		{
			throw new QLException(null, errors);
		}
		
		QLTypeChecker typeChecker = new QLTypeChecker();
		
		try 
		{
			typeChecker.check(form);
		} 
		catch (QBaseException e) 
		{
			throw new QLException(typeChecker.warnings(), typeChecker.errors());
		}
		finally
		{
			warnings.addAll(typeChecker.warnings());
		}
			
		return form;
	}
	
	public List<QBaseWarning> warnings()
	{
		return warnings;
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
		errors.add(new SyntaxError(line, charPositionInLine, msg));
	}

	@Override
	public void reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) 
	{
		errors.add(new AmbiguityError(startIndex, stopIndex));
	}

	@Override
	public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) 
	{
		errors.add(new AttemptingFullContextError(startIndex, stopIndex));
	}

	@Override
	public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) 
	{
		errors.add(new ContextSensitivityError(startIndex, stopIndex));
	}   
}