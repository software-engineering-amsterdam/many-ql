package uva.sc.core.types;

public class Boolean implements Type {

    public java.lang.String toString() {
	return "[Type]: boolean";
    }

    public boolean equals(Type type) {

	if (type == null) {
	    return false;
	}
	return type.toString() == this.toString();
    }
}
