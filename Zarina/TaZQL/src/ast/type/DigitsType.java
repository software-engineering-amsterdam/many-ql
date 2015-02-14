package ast.type;

public abstract class DigitsType extends Type<Integer> {
		

		public String getValue() {
			return "digits";
		}
		
		
		@Override
		public String toString() {
			return "digits";
		}

}
