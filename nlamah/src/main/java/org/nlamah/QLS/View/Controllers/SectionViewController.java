package org.nlamah.QLS.View.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.nlamah.QL.Builders.FragementedFormElementFinder;
import org.nlamah.QL.Builders.QLViewControllersFactory;
import org.nlamah.QL.Builders.QLViewFactory;
import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.View.Controllers.Abstract.FormElementViewController;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.StylesheetBlock.Section;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.View.Stylesheet.SectionView;

public class SectionViewController extends StylesheetViewController 
{
	private Form form;
	
	private List<FormElementViewController> formElementViewControllers;
	
	private List<SectionViewController> childSectionViewControllers;
	
	public SectionViewController(RootFormViewControllerStyled rootViewController, Form form, Section section, StylesheetViewController parentViewController)
	{
		super (rootViewController, parentViewController);
		
		this.form = form;
		
		view = new SectionView(section);
		
		createChildViewsAndControllers(section.sectionItems());
	}
	
	private void createChildViewsAndControllers(List<? extends SectionItem> sectionItems)
	{
		childSectionViewControllers = new ArrayList<SectionViewController>();
		formElementViewControllers = new ArrayList<FormElementViewController>();
		
		QLViewFactory viewFactory = new QLViewFactory();
		
		for (SectionItem sectionItem : sectionItems)
		{	
			if (sectionItem instanceof StyledQuestion)
			{
				StyledQuestion styledQuestion = (StyledQuestion) sectionItem;
				
				FormQuestion formQuestion = QLHelper.getQuestionWithIdentifier(form.questions(), new IdentifierLiteral(styledQuestion.identifier().toString()));
				
				FragementedFormElementFinder fragmentedFormElementFinder = new FragementedFormElementFinder();
				
				FormElement formElement = fragmentedFormElementFinder.findFragementedFormElementForQuestion(formQuestion);
				
				QLViewControllersFactory viewControllersFactory = new QLViewControllersFactory(rootViewController());
				
				FormElementViewController formElementViewController = viewControllersFactory.createFormElementViewController(formElement);
				
				formElementViewControllers.add(formElementViewController);
				
				JPanel gatheredView = viewFactory.gatherViewForFormViewController(formElementViewController);
				
				view.add(gatheredView);
			}
			else if (sectionItem instanceof Section)
			{	
				SectionViewController sectionViewController = new SectionViewController(rootViewController(), form, (Section)sectionItem, this);
				
				childSectionViewControllers.add(sectionViewController);
				
				view.add(sectionViewController.view);
			}
			else
			{
				assert(false);
			}
		}
	}
	
	@Override
	public int neededViewHeight() 
	{	
		int preferredHeight = 0;
		
		((SectionView) view).redrawBorder();
		
		for (FormElementViewController formElementViewController : formElementViewControllers)
		{	
			preferredHeight += formElementViewController.neededViewHeight();	
		}
		
		for (SectionViewController sectionViewController : childSectionViewControllers)
		{
			preferredHeight += sectionViewController.neededViewHeight();
		}
		
		return preferredHeight;
	}
}
