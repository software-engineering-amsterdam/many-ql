package uva.sc.qls.ast;

import uva.sc.qls.logic.*;
import uva.sc.qls.logic.fonts.Arial;
import uva.sc.qls.logic.fonts.Bazooka;
import uva.sc.qls.logic.fonts.BookAntiqua;
import uva.sc.qls.logic.fonts.Courier;
import uva.sc.qls.logic.fonts.Dialog;
import uva.sc.qls.logic.fonts.TimesNewRoman;
import uva.sc.qls.logic.fonts.UndefinedFont;
import uva.sc.qls.logic.style.DefaultStyle;
import uva.sc.qls.logic.style.StyleProperty;
import uva.sc.qls.widgetTypes.Checkbox;
import uva.sc.qls.widgetTypes.Radio;
import uva.sc.qls.widgetTypes.Spinbox;
import uva.sc.qls.widgetTypes.UnidentifiedWidget;

public interface IQLSNodeVisitor<T> {

	public T visit(Page page);

	public T visit(DefaultStyle defaultStyle);

	public T visit(Question question);

	public T visit(Section section);

	public T visit(SectionBody sectionBody);

	public T visit(StyleSheet styleSheet);

	public T visit(Widget widget);

	public T visit(StyleProperty styleProperty);

	public T visit(ID id);

	public T visit(UnidentifiedWidget unidentifiedWidget);

	public T visit(Checkbox checkbox);

	public T visit(Spinbox spinbox);

	public T visit(Radio radio);

	public T visit(Arial arial);

	public T visit(Bazooka bazooka);

	public T visit(BookAntiqua bookAntiqua);

	public T visit(Courier courier);

	public T visit(Dialog dialog);

	public T visit(TimesNewRoman timesNewRoman);

	public T visit(UndefinedFont undefinedFont);

}
