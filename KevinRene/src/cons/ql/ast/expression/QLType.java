package cons.ql.ast.expression;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import cons.ql.ast.Expression;

public abstract class QLType extends Expression {
	protected List<Class<? extends QLType>> compatibleTypes;
	
	public QLType(List<Class<? extends QLType>> compatibleTypes) {
		super(Arrays.asList());
		this.compatibleTypes = compatibleTypes;
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
	
	public boolean compatibleWith(QLType type) {
		return this.compatibleTypes.contains(type.getClass());
	}
	
	/**
	 * @return the list of compatibilities
	 */
	public List<String> compatibilities() {
		return compatibleTypes.stream()
				.map(ct -> ct.getSimpleName())
				.collect(Collectors.toList());
	}
}