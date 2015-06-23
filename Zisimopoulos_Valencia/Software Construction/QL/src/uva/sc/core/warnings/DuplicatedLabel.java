package uva.sc.core.warnings;

public class DuplicatedLabel implements IWarning {

    private String label;

    public DuplicatedLabel(String label) {
	this.label = label;
    }

    public String toString() {
	return "Duplicate question label <" + label + ">";
    }

}
