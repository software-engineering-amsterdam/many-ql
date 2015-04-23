package org.nlamah.QL.ViewControllers.Form;

import java.awt.Dimension;

import org.nlamah.QL.Helper.QLHelper;
import org.nlamah.QL.Interfaces.QLFormElementViewControllerVisitor;
import org.nlamah.QL.Model.Form.ElseThenBlock;
import org.nlamah.QL.ViewControllers.Form.Abstract.DeclaringFormElementViewController;
import org.nlamah.QL.Views.Builders.FormHeightAdjuster;
import org.nlamah.QL.Views.Form.ElseThenBlockView;

public class ElseThenBlockViewController extends DeclaringFormElementViewController 
{
	private ElseThenBlockView elseThenBlockView;
	
	public ElseThenBlockViewController(ElseThenBlock elseThenBlock) 
	{
		super(elseThenBlock);
		
		elseThenBlockView  = new ElseThenBlockView(this);
		
		view = elseThenBlockView;
	}
	
	@Override
	public void accept(QLFormElementViewControllerVisitor visitor) 
	{
		visitor.visit(this);
	}
	
	@Override
	public int neededViewHeight() 
	{
		FormHeightAdjuster heightCalculator = new FormHeightAdjuster();
		
		int neededHeight = heightCalculator.getPreferredHeight(childViewControllers());
		
		elseThenBlockView.setPreferredSize(new Dimension(QLHelper.contentWidth(), neededHeight));
		
		return neededHeight;
	}

}
