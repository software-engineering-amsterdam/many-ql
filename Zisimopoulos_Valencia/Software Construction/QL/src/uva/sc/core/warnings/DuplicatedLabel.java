package uva.sc.core.warnings;

public class DuplicatedLabel implements IWarning {

    String value;

    public DuplicatedLabel(String v) {
	value = v;
    }

    public String toString() {
	return "Duplicate question label <" + value + ">";
    }

}
