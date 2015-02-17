package cons.ql.ast.expression;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import cons.ql.ast.Expression;

@SuppressWarnings("rawtypes")
public abstract class QLType extends Expression {
	
	protected boolean defined;
	protected List<Class<? extends QLType>> compatibleTypes;
	
	public QLType(List<Class<? extends QLType>> ct) {
		this.compatibleTypes = ct;
	}
	
	public String getName() {
		return this.getClass().getSimpleName();
	}
	
	public boolean compatibleWith(QLType type) {
		return this.compatibleTypes.contains(type.getClass());
	}
	
	/**
	 * 
	 * @return the list of compatibilities
	 */
	public List<String> compatibilities() {
		return compatibleTypes.
				stream().
				map(ct -> ct.getSimpleName()).
				collect(Collectors.toList());
	}
}