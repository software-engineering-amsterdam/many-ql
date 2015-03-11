package nl.uva.softwcons.qls.ast.widget.type;

public class DropdownType extends WidgetType {
    private final String yes;
    private final String no;

    public DropdownType(final String yes, final String no) {
        this.yes = yes;
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public String getYes() {
        return yes;
    }

}
