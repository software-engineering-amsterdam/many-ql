package org.nlamah.QL.TypeChecker;

import java.util.ArrayList;

import org.nlamah.QBase.QBaseError;

public abstract class TypeCheckerAbstract 
{
	protected ArrayList<QBaseError > errors;
	
	public TypeCheckerAbstract() 
	{
		errors = new ArrayList<QBaseError>();
	}
	
	public ArrayList<QBaseError>errors()
	{
		return this.errors;
	}
}
