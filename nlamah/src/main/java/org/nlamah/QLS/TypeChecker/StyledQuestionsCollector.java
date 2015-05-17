package org.nlamah.QLS.TypeChecker;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QLS.Interfaces.QLSVisitorAbstract;
import org.nlamah.QLS.Model.Abstract.QLSNode;
import org.nlamah.QLS.Model.Abstract.SectionItem;
import org.nlamah.QLS.Model.Declaration.WidgetDeclaration;
import org.nlamah.QLS.Model.StylesheetBlock.Page;
import org.nlamah.QLS.Model.StylesheetBlock.StyledQuestion;
import org.nlamah.QLS.Model.StylesheetBlock.Stylesheet;
import org.nlamah.QLS.Model.StylesheetBlock.Section;

public class StyledQuestionsCollector extends QLSVisitorAbstract
{
	private List<StyledQuestion> questions;

	public StyledQuestionsCollector()
	{
		super();
	}

	public List<StyledQuestion> questionsForStylesheet(Stylesheet stylesheet)
	{
		questions = new ArrayList<StyledQuestion>();

		stylesheet.accept(this);

		return questions;
	}

	public List<StyledQuestion> questionsForSection(Section section)
	{
		questions = new ArrayList<StyledQuestion>();

		section.accept(this);

		return questions;
	}

	@Override
	public QLSNode visit(Stylesheet stylesheet) 
	{
		for (Page page : stylesheet.pages())
		{
			page.accept(this);
		}

		return null;
	}

	@Override
	public QLSNode visit(Page page) 
	{
		for (Section section : page.sections())
		{
			section.accept(this);
		}

		return null;
	}

	@Override
	public QLSNode visit(Section section) 
	{		
		for (SectionItem sectionItem : section.sectionItems())
		{
			sectionItem.accept(this);
		}

		return null;
	}

	@Override
	public QLSNode visit(WidgetDeclaration widgetDeclaration) 
	{
		assert(false);
		return null;
	}

	@Override
	public QLSNode visit(StyledQuestion styledQuestion) 
	{
		questions.add(styledQuestion);

		return null;
	}
}
