package uva.sc.core.types;

public class Undefined implements Type {

    public java.lang.String toString() {
	return "[Type]: undefined";
    }

    public boolean equals(Type type) {
	if (type == null) {
	    return false;
	}
	return type.toString() == this.toString();
    }
}
