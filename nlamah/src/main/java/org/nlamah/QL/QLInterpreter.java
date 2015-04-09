package org.nlamah.QL;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.IOUtils;
import org.nlamah.QL.FormModel.Form;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormModel.Question;
import org.nlamah.QL.FormViewControllers.FormViewController;

public class QLInterpreter implements Runnable
{
	private String fileName;
	private FormViewController formViewController;
	
	public QLInterpreter(String fileName)
	{
		this.fileName = fileName;
	}
	
	public static void main( String[] args )
    {
    	String fileName = args.length > 0 ? args[0] : "source.ql";
    	
    	SwingUtilities.invokeLater(new QLInterpreter(fileName));
    }
	
	@Override
	public void run()
	{
		Form form = this.interprete();
		
    	this.formViewController = new FormViewController(form);
    	this.formViewController.showForm();
	}
	
	private Form interprete()
	{
		String sourceCode = this.getSourceCode();
		
		ParseTree tree = this.createParseTreeFromSourceCode(sourceCode);
		
		return this.createFormFromParseTree(tree);
	}
	
	private String getSourceCode()
    {
		String qlSourceCode = "";
		
		try 
		{
			InputStream fileInputStream = QLInterpreter.class.getResourceAsStream(this.fileName);
			qlSourceCode = IOUtils.toString(fileInputStream, "UTF-8");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return qlSourceCode;
    }
    
    private ParseTree createParseTreeFromSourceCode(String sourceCode)
    {
    	ANTLRInputStream input = new ANTLRInputStream(sourceCode);

		QLLexer lexer = new QLLexer(input);
		
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		
		QLParser parser = new QLParser(tokens);
		
    	return parser.form();
    }
    
    private Form createFormFromParseTree(ParseTree tree)
    {
    	Question question1 = new Question("hasSoldHouse", "boolean", "Did you sell a house in 2010?");
 		Question question2 = new Question("hasMaintLoan", "boolean", "Did you enter a loan for maintenance/reconstruction?");

 		ArrayList<FormElement> questions = new ArrayList<FormElement>(2);
 		questions.add(0, question1);
 		questions.add(1, question2);

 		Form form = new Form("test", questions);
    	
    	return form;	
    }
}
