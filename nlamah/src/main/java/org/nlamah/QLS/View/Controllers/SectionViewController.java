package org.nlamah.QLS.View.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.Builders.FragementedFormElementFinder;
import org.nlamah.QL.Builders.QLViewControllersFactory;
import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.View.Controllers.Abstract.FormElementViewController;
import org.nlamah.QLS.Model.Declaration.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.View.Builders.QuestionViewFactory;
import org.nlamah.QLS.View.Stylesheet.SectionView;

public class SectionViewController extends StylesheetViewController 
{
	private Form form;
	
	private List<SectionViewController> sectionViewControllers;
	
	private Section section;
	
	public SectionViewController(RootFormViewControllerStyled rootViewController, Form form, Section section, StylesheetViewController parentViewController)
	{
		super (rootViewController, parentViewController);
		
		this.form = form;
		
		this.section = section;
		
		view = new SectionView(section);
		
		createSectionViewController(section.sections());
		
		addViewsToView();
	}
	
	private void createSectionViewController(List<Section> sections)
	{
		sectionViewControllers = new ArrayList<SectionViewController>();
		
		for (Section section : sections)
		{
			sectionViewControllers.add(new SectionViewController(rootViewController(), form, section, this));
		}
	}
	
	private void addViewsToView()
	{
		for (StyledQuestion styledQuestion : section.questionDeclarations())
		{
			FormQuestion formQuestion = QLHelper.getQuestionWithIdentifier(form.questions(), new IdentifierLiteral(styledQuestion.identifier().toString()));
			
			FragementedFormElementFinder fragmentedFormElementFinder = new FragementedFormElementFinder();
			
			FormElement formElement = fragmentedFormElementFinder.findFragementedFormElementForQuestion(formQuestion);
			
			QLViewControllersFactory viewControllersFactory = new QLViewControllersFactory(rootViewController());
			
			FormElementViewController formElementViewController = viewControllersFactory.createFormElementViewController(formElement);
			
			view.add(formElementViewController.view());
			
		}
		
		for (SectionViewController sectionViewController : sectionViewControllers)
		{
			view.add(sectionViewController.view);
		}
	}
	
	@Override
	public int neededViewHeight() 
	{
		int preferredHeight = 0;
		
		for (StyledQuestion styledQuestion : section.questionDeclarations())
		{
			FormQuestion formQuestion = QLHelper.getQuestionWithIdentifier(form.questions(), new IdentifierLiteral(styledQuestion.identifier().toString()));
			
			FragementedFormElementFinder fragmentedFormElementFinder = new FragementedFormElementFinder();
			
			FormElement formElement = fragmentedFormElementFinder.findFragementedFormElementForQuestion(formQuestion);
			
			QLViewControllersFactory viewControllersFactory = new QLViewControllersFactory(rootViewController());
			
			FormElementViewController formElementViewController = viewControllersFactory.createFormElementViewController(formElement);
			
			preferredHeight += formElementViewController.neededViewHeight();
			
		}
		
		for (SectionViewController sectionViewController : sectionViewControllers)
		{
			preferredHeight += sectionViewController.neededViewHeight();
		}
		
		return preferredHeight;
	}
}
