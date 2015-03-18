package nl.uva.sc.encoders.qls.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nl.uva.sc.encoders.qls.ast.Page;

public class TypeChecker {

	// private static final String DUPLICATE_LABEL = "duplicateLabel";
	// private static final String REFERENCE_BEFORE_STATED =
	// "referenceBeforeStated";
	// private static final String UNDEFINED_PAGE = "undefinedPage";
	// private static final String UNDEFINED_SECTION = "undefinedSection";

	private final Set<String> pageLabels = new HashSet<>();

	private final Set<String> pageNames = new HashSet<String>();

	private final List<TypeValidation> validations = new ArrayList<>();

	private final Page page;

	public TypeChecker(Page page) {
		this.page = page;
	}

}
