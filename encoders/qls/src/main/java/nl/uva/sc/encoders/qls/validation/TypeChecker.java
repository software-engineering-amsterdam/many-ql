package nl.uva.sc.encoders.qls.validation;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.validation.TypeValidation;
import nl.uva.sc.encoders.qls.ast.Stylesheet;

public class TypeChecker {

	private final List<TypeValidation> validations = new ArrayList<>();

	private final Stylesheet stylesheet;

	public TypeChecker(Stylesheet stylesheet) {
		this.stylesheet = stylesheet;
	}

	public List<TypeValidation> checkTypes() {
		// TODO Auto-generated method stub
		return null;
	}

}
