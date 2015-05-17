package org.nlamah.QLS.View.Controllers;

import javax.swing.JPanel;

public abstract class StylesheetViewController
{
	protected JPanel view;

	private RootFormViewControllerStyled rootViewController;
	private StylesheetViewController parentViewController;

	public StylesheetViewController(RootFormViewControllerStyled rootViewController, StylesheetViewController parentViewController)
	{
		super();

		this.rootViewController = rootViewController;
		this.parentViewController = parentViewController;
	}

	public StylesheetViewController()
	{
		this(null, null);
	}

	StylesheetViewController parentViewController()
	{
		return parentViewController;
	}

	public RootFormViewControllerStyled rootViewController()
	{
		return rootViewController;
	}

	abstract public int neededViewHeight();
}
