package org.nlamah.QL;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;

import javax.swing.SwingUtilities;

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
import org.nlamah.QL.Error.Abstract.QLError;
import org.nlamah.QL.Error.Abstract.QLWarning;
import org.nlamah.QL.Error.Parsing.AmbiguityError;
import org.nlamah.QL.Error.Parsing.AttemptingFullContextError;
import org.nlamah.QL.Error.Parsing.ContextSensitivityError;
import org.nlamah.QL.Error.Parsing.FileReadError;
import org.nlamah.QL.Error.Parsing.SyntaxError;
import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.ViewControllers.Form.FormRootViewController;
import org.nlamah.QL.Views.Error.QLErrorViewController;

public class QLInterpreter implements Runnable, ANTLRErrorListener
{
	private String fileName;
	
	private ArrayList<QLError> parsingErrors;
	
	public QLInterpreter(String fileName)
	{
		super();
		
		this.fileName = fileName;
		
		parsingErrors = new ArrayList<QLError>();
	}
	
	public static void main( String[] args )
    {
    	String fileName = args.length > 0 ? args[0] : "source.ql";
    	
    	SwingUtilities.invokeLater(new QLInterpreter(fileName));
    }
	
	private void showErrorViewController(ArrayList<QLError> errors, ArrayList<QLWarning> warnings)
	{
		QLErrorViewController errorViewController = new QLErrorViewController(errors, warnings);
		
		errorViewController.showErrors();
	}
	
	private void showForm(Form form)
	{
		FormRootViewController rootViewController = new FormRootViewController(form);
		
		rootViewController.showForm();
	}
	
	@Override
	public void run()
	{
		Form form = this.interprete();
		
		if (!parsingIsFreeOfBlockingErrors())
		{
			return;
		}
		
		QLTypeChecker typeChecker = new QLTypeChecker(form);
		
		if (QLHelper.arrayExistsAndHasElements(typeChecker.errors()))
		{
			showErrorViewController(typeChecker.errors(), typeChecker.warnings());
		}
		else
		{
			if (QLHelper.arrayExistsAndHasElements(typeChecker.warnings()))
			{
				showErrorViewController(null, typeChecker.warnings());
			}
			
			showForm(form);
		}
	}
	
	private boolean parsingIsFreeOfBlockingErrors()
	{		
		if (parsingErrors.size() > 0)
		{
			showErrorViewController(parsingErrors, null);
			
			return false;
		}
		
		return true;
	}
	
	private Form interprete()
	{
		String sourceCode = this.getSourceCode();
		
		ParseTree tree = this.createParseTreeFromSourceCode(sourceCode);
		
		return (Form)tree.accept(new RawFormTreeBuilder());
	}
	
	private String getSourceCode()
    {
		String qlSourceCode = "";
		
		try 
		{
			InputStream fileInputStream = QLInterpreter.class.getResourceAsStream(fileName);
			qlSourceCode = IOUtils.toString(fileInputStream, "UTF-8");
		} 
		catch (Exception e) 
		{	
			parsingErrors.add(new FileReadError(fileName));
			
			showErrorViewController(parsingErrors, null);
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