package org.nlamah.QL.Interfaces;

import org.nlamah.QL.Model.Form.Abstract.FormElement;

public interface FormElementListener 
{
	public void modelStateChanged(FormElement formElement);
	public void viewNeedsUpdate();
}
