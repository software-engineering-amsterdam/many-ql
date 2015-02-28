package org.uva.sea.ql.encoders.ast;

import java.util.ArrayList;
import java.util.List;

/**
 * Store type errors in List, to be used in UI.
 */
public class TypeErrorLogger {
	
	List<TypeError> typeErrors = new ArrayList<TypeError>();
	
	public void addTypeError(TypeError typeError) {
		typeErrors.add(typeError);
	}
	
	public List<TypeError> getTypeErrors() {
		return typeErrors;
	}
}
