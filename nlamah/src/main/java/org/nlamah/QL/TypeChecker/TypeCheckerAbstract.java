package org.nlamah.QL.TypeChecker;

import java.util.ArrayList;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QL.Interfaces.QLNodeVisitor;

public abstract class TypeCheckerAbstract implements QLNodeVisitor
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
