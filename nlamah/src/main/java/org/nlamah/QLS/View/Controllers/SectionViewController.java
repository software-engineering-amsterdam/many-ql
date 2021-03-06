package org.nlamah.QLS.View.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.Tools.QLTools;
import org.nlamah.QL.Builders.FragmentedFormElementFinder;
import org.nlamah.QL.Model.Expression.Literal.IdentifierLiteral;
import org.nlamah.QL.Model.Form.Form;
import org.nlamah.QL.Model.Form.Abstract.FormElement;
import org.nlamah.QL.Model.Form.Abstract.FormQuestion;
import org.nlamah.QL.View.Controllers.Abstract.FormElementViewController;
import org.nlamah.QLS.Builders.QLSViewControllersFactory;
import org.nlamah.QLS.Builders.QLSViewFactory;
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

		QLSViewControllersFactory viewControllersFactory = new QLSViewControllersFactory(rootViewController());

		QLSViewFactory viewFactory = new QLSViewFactory();

		for (SectionItem sectionItem : sectionItems)
		{	
			if (sectionItem instanceof StyledQuestion)
			{
				StyledQuestion styledQuestion = (StyledQuestion) sectionItem;

				FormQuestion formQuestion = QLTools.getQuestionWithIdentifier(form.questions(), new IdentifierLiteral(styledQuestion.identifier().toString()));

				FragmentedFormElementFinder fragmentedFormElementFinder = new FragmentedFormElementFinder();

				FormElement formElement = fragmentedFormElementFinder.findFragementedFormElementForQuestion(formQuestion);

				FormElementViewController formElementViewController = viewControllersFactory.createFormElementViewController(formElement);

				formElementViewControllers.add(formElementViewController);

				view.add(viewFactory.gatherViewForFormViewController(formElementViewController, styledQuestion.styleBlock()));
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
		for (FormElementViewController formElementViewController : formElementViewControllers)
		{
			formElementViewController.evaluateViewHeight();
		}

		for (SectionViewController sectionViewController : childSectionViewControllers)
		{
			sectionViewController.neededViewHeight();
		}

		((SectionView) view).layoutView();

		return view.getPreferredSize().height;
	}
}