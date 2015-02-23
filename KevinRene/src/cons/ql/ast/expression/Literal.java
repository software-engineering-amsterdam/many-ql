package cons.ql.ast.expression;

import java.util.Arrays;

import cons.ql.ast.Expression;

@SuppressWarnings("rawtypes")
public abstract class Literal<T> extends Expression {
	private final T value;
	
	public Literal(T value) {
		super(Arrays.asList());
		this.value = value;
	}
	
	public T getValue() {
		return this.value;
	}	
	
	/**
	 * Addition
	 * 
	 * @param argument
	 * @return
	 */
	public Literal add(Literal argument) {
		return this;
	}
	
	public Literal addInteger(int argument) {
		return this;
	}
	
	public Literal addFloat(float argument) {
		return this;
	}
	
	public Literal addString(String argument) {
		return this;
	}
	
	/**
	 * Division
	 * 
	 * @param argument
	 * @return
	 */
	public Literal div(Literal argument) {
		return this;
	}
	
	public Literal divInteger(int argument) {
		return this;
	}
	
	public Literal divFloat(float argument) {
		return this;
	}
	
	/**
	 * Multiplication
	 * 
	 * @param argument
	 * @return
	 */
	public Literal mul(Literal argument) {
		return this;
	}
	
	public Literal mulInteger(int argument) {
		return this;
	}
	
	public Literal mulFloat(float argument) {
		return this;
	}
	
	/**
	 * Subtraction
	 * 
	 * @param argument
	 * @return
	 */
	public Literal sub(Literal argument) {
		return this;
	}
	
	public Literal subInteger(int argument) {
		return this;
	}
	
	public Literal subFloat(float argument) {
		return this;
	}
	
	public String toString() {
		return value.toString();
	}
}
