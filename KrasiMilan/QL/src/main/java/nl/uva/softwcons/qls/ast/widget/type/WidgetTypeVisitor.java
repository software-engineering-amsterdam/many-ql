package nl.uva.softwcons.qls.ast.widget.type;


public interface WidgetTypeVisitor<T> {

    T visit(CheckboxType type);

    T visit(DropdownType type);

    T visit(RadioButtonType type);

    T visit(SliderType type);

    T visit(SpinboxType type);

    T visit(TextType type);

}
