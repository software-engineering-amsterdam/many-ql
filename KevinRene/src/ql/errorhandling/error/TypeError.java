package ql.errorhandling.error;

import java.util.List;
import java.util.stream.Collectors;

import ql.ast.QLNode;
import ql.ast.QLType;
import ql.errorhandling.Error;

public class TypeError extends Error {
	public TypeError(QLNode origin, QLType expectedType, QLType actualType) {
		super(origin, "Expected (" + expectedType + ") got (" + actualType + ").");
	}
	
	public TypeError(QLNode origin, List<QLType> expectedTypes, List<QLType> actualTypes) {		
		super(origin, "Expected (" + typesToString(expectedTypes) 
				+ ") got (" + typesToString(actualTypes) + ").");
	}
	
	private static String typesToString(List<QLType> types) {
		return types.stream()
			   .map(x -> x.toString())
			   .collect(Collectors.joining(" & "));
	}
}
