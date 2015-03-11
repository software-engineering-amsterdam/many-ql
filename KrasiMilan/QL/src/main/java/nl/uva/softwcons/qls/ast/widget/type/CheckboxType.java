package nl.uva.softwcons.qls.ast.widget.type;

public class CheckboxType extends WidgetType {
    private final String yes;

    public CheckboxType(final String yes) {
        this.yes = yes;
    }

    public String getYes() {
        return yes;
    }

}
