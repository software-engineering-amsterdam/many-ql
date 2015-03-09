package uva.sc.qls.ast;

import uva.sc.qls.atom.ID;
import uva.sc.qls.logic.*;
import uva.sc.qls.types.Unidentified;
import uva.sc.qls.types.Boolean;
import uva.sc.qls.types.Number;
import uva.sc.qls.types.String;
import uva.sc.qls.widgetTypes.Checkbox;
import uva.sc.qls.widgetTypes.Radio;
import uva.sc.qls.widgetTypes.Spinbox;
import uva.sc.qls.widgetTypes.UnidentifiedWidget;

public interface INodeVisitor<T> {
	
	public T visit(Page page);

	public T visit(DefaultStyle defaultStyle);

	public T visit(Question question);

	public T visit(Section section);

	public T visit(SectionBody sectionBody);

	public T visit(StyleSheet styleSheet);

	public T visit(Widget widget);
	
	public T visit(StyleProperty styleProperty);

	public T visit(Boolean bool);
	
	public T visit(String str);

	public T visit(Number number);

	public T visit(Unidentified unidentified);

	public T visit(ID id);

	public T visit(UnidentifiedWidget unidentifiedWidget);

	public T visit(Checkbox checkbox);

	public T visit(Spinbox spinbox);

	public T visit(Radio radio);
	
}
