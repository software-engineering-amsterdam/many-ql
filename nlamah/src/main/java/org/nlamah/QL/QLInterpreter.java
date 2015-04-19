package org.nlamah.QL;

import java.io.IOException;
import java.io.InputStream;

import javax.swing.SwingUtilities;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.IOUtils;
import org.nlamah.QL.Error.QLErrorViewController;
import org.nlamah.QL.Helper.Helper;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.ViewControllers.Form.FormRootViewController;
import org.nlamah.QL.Visitors.MyQLVisitor;

public class QLInterpreter implements Runnable
{
	private String fileName;
	
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
		
		if (Helper.arrayExistsAndHasElements(form.errors()))
		{
			QLErrorViewController errorViewController = new QLErrorViewController(form.errors());
			
			errorViewController.showErrors();
		}
		else
		{
			FormRootViewController rootViewController = new FormRootViewController(form);
			
			rootViewController.showForm();
		}
	}
	
	private Form interprete()
	{
		String sourceCode = this.getSourceCode();
		
		ParseTree tree = this.createParseTreeFromSourceCode(sourceCode);
		
		return buildForm(tree);
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
    
    private Form buildForm(ParseTree tree)
    {  	
    	Form form = (Form)tree.accept(new MyQLVisitor());
    	
    	form  = QLTypeChecker.check(form);
    	
    	return form;
    }   
}


