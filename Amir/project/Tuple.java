package project;

import project.ast.value.TypeValue;
import project.ast.values.Value;

	public class Tuple {

		    public String id;
		    public String text;
		    public TypeValue type;
		    public Value value;
		    
		    public Tuple(String id, String text, TypeValue type, Value value) {
		      this.id = id;
		      this.text = text;
		      this.type = type;
		      this.value = value;
		    }

//		    @Override
//		    public String toString() {
//		      return String.format("(%s, %s)", integerPart, decimalPart);
//		    }
//		  }

//		  private static Tuple split(Double x) {
//		    int integerPart = x.intValue();
//		    return new Tuple(integerPart, x - integerPart);
//		  };

//		  public static void main(String[] args) {
//		    System.out.println(split(5.3));
//		    System.out.println(split(-2.7));
//		  }
		}

