package org.nlamah.QL;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.IOUtils;
import org.nlamah.QL.FormModel.ComputedQuestion;
import org.nlamah.QL.FormModel.ConditionalBlock;
import org.nlamah.QL.FormModel.Form;
import org.nlamah.QL.FormModel.FormElement;
import org.nlamah.QL.FormModel.BooleanQuestion;
import org.nlamah.QL.FormModel.IfThenBlock;
import org.nlamah.QL.FormModel.LogicalExpressionStub;
import org.nlamah.QL.FormModel.Question;
import org.nlamah.QL.FormViewControllers.FormRootViewController;

public class QLInterpreter implements Runnable
{
	private String fileName;
	private FormRootViewController formViewController;
	
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
		
    	this.formViewController = new FormRootViewController(form);
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
//    	BooleanQuestion question1 = new BooleanQuestion("hasSoldHouse", "boolean", "Did you sell a house in 2010?");
// 		BooleanQuestion question2 = new BooleanQuestion("hasMaintLoan", "boolean", "Did you enter a loan for maintenance/reconstruction?");
//
// 		ArrayList<FormElement> questions = new ArrayList<FormElement>(2);
// 		questions.add(0, question1);
// 		questions.add(1, question2);

 		ArrayList<FormElement> formElements = new ArrayList<FormElement>(80);
		
		FormElement formElement;
		
		for (int i = 0; i < 80; i++)
		{
			if (i % 3 == 0)
			{
				formElement = new BooleanQuestion(Integer.toString(i + 1) + ".", Integer.toString(i+1) + "th question", "BOOL");	
			}
			else if (i % 3 == 1)
			{
				formElement = new ComputedQuestion(Integer.toString(i+1) + ".", Integer.toString(i+1) + "th question", "Computed", Integer.toString(i * i));
			}
			else
			{
				
				ArrayList<FormElement> dummyQuestions = createConditionalDummyQuestions(i, "if then");
				
				IfThenBlock ifThenBlock = new IfThenBlock(new LogicalExpressionStub(), dummyQuestions);
				
				formElement = new ConditionalBlock(ifThenBlock, null, null);
			}
			
			formElements.add(formElement);
		}
 		
 		Form form = new Form("test", formElements);
    	
    	return form;	
    }
		
	private ArrayList<FormElement> createConditionalDummyQuestions(int number, String type)
	{
		ArrayList<FormElement> conditionalQuestions = new ArrayList<FormElement>(3);
		
		for (int i = 0; i < 3; i++)
		{
			conditionalQuestions.add(new BooleanQuestion(number + "." + i, i + "th " + type + " quesiton", "boolean"));
		}
			
		return conditionalQuestions;
	}
}


