package uva.sc.core.errors;


public class DuplicatedID implements IError {

    String id;

    public DuplicatedID(String i) {
	id = i;
    }

    public String toString() {
	return "Duplicated identifier" + id;
    }

}
