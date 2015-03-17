package org.uva.qls.ast.style.widget;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.uva.qls.ast.CodePosition;
import org.uva.qls.ast.literal.IntLiteral;
import org.uva.qls.ast.literal.Literal;
import org.uva.qls.visitor.StyleVisitor;

public class SpinboxModel extends WidgetType {

	private final List<IntLiteral> values;

	public SpinboxModel(List<IntLiteral> values, CodePosition position) {
		super(position);
		this.values = values;
	}

	public List<IntLiteral> getValues() {
		return values;
	}

	@Override
	public String toString() {
		return "spinbox";
	}

	@Override
	public <T> T accept(StyleVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public Literal getLiteral() {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<IntLiteral> isValid() {
		List<IntLiteral> duplicatedValues = new ArrayList<IntLiteral>();
		List<IntLiteral> newList = new ArrayList<IntLiteral>(new HashSet<IntLiteral>(values));

		for (IntLiteral intLiteral : duplicatedValues) {
			if (!newList.contains(intLiteral)) {
				newList.add(intLiteral);
				duplicatedValues.remove(intLiteral);
			}
		}
		System.out.println(duplicatedValues.size());
		return duplicatedValues;
	}
}
