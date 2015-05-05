package org.nlamah.QLS.View.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QL.Builders.FragementedFormElementFinder;
import org.nlamah.QL.Builders.QLViewControllersFactory;
import org.nlamah.QL.Builders.QLViewFactory;
import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.View.Controllers.Abstract.FormElementViewController;
import org.nlamah.QLS.Model.Declaration.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.View.Stylesheet.SectionView;

public class SectionViewController extends StylesheetViewController 
{
	private Form form;
	
	private List<FormElementViewController> formElementViewControllers;
	
	private List<SectionViewController> sectionViewControllers;
	
	private Section section;
	
	public SectionViewController(RootFormViewControllerStyled rootViewController, Form form, Section section, StylesheetViewController parentViewController)
	{
		super (rootViewController, parentViewController);
		
		this.form = form;
		
		this.section = section;
		
		view = new SectionView(section);
		
		createSectionViewControllers(section.sections());
		
		addViewsToView();
	}
	
	private void createSectionViewControllers(List<Section> sections)
	{
		sectionViewControllers = new ArrayList<SectionViewController>();
		
		for (Section section : sections)
		{	
			sectionViewControllers.add(new SectionViewController(rootViewController(), form, section, this));
		}
	}
	
	private void addViewsToView()
	{
		QLViewFactory viewFactory = new QLViewFactory();
		
		formElementViewControllers = new ArrayList<FormElementViewController>();
		
		for (StyledQuestion styledQuestion : section.questionDeclarations())
		{
			FormQuestion formQuestion = QLHelper.getQuestionWithIdentifier(form.questions(), new IdentifierLiteral(styledQuestion.identifier().toString()));
			
			FragementedFormElementFinder fragmentedFormElementFinder = new FragementedFormElementFinder();
			
			FormElement formElement = fragmentedFormElementFinder.findFragementedFormElementForQuestion(formQuestion);
			
			QLViewControllersFactory viewControllersFactory = new QLViewControllersFactory(rootViewController());
			
			FormElementViewController formElementViewController = viewControllersFactory.createFormElementViewController(formElement);
			
			formElementViewControllers.add(formElementViewController);
			
			view.add(viewFactory.gatherViewForFormViewController(formElementViewController));
			
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
		
		for (FormElementViewController formElementViewController : formElementViewControllers)
		{	
			preferredHeight += formElementViewController.neededViewHeight();	
		}
		
		for (SectionViewController sectionViewController : sectionViewControllers)
		{
			preferredHeight += sectionViewController.neededViewHeight();
		}
		
		return preferredHeight;
	}
}
