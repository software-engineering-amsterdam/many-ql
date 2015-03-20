package uva.sc.core.types;

public class Number implements Type {

    public java.lang.String toString() {
	return "[Type]: number";
    }

    public boolean equals(Type type) {
	if (type == null) {
	    return false;
	}
	return type.toString() == this.toString();
    }

}
