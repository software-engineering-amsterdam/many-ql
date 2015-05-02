package org.nlamah.QL.TypeChecker;

import java.util.ArrayList;
import java.util.List;

import org.nlamah.QBase.QBaseError;
import org.nlamah.QL.Interfaces.QLNodeVisitor;

public abstract class TypeCheckerAbstract implements QLNodeVisitor
{
	protected List<QBaseError> errors;
	
	public TypeCheckerAbstract() 
	{
		errors = new ArrayList<QBaseError>();
	}
	
	public List<QBaseError>errors()
	{
		return this.errors;
	}
}
