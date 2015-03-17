package uva.sc.core.types;

public class String implements Type {

    public java.lang.String toString() {
	return "[Type]: string";
    }

    public boolean equals(Type type) {
	if (type == null) {
	    return false;
	}
	return type.toString() == this.toString();
    }
    
}
