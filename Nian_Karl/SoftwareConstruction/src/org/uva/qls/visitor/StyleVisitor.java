package org.uva.qls.visitor;

import org.uva.qls.ast.style.BackgroundColor;
import org.uva.qls.ast.style.Font;
import org.uva.qls.ast.style.Fontsize;
import org.uva.qls.ast.style.Height;
import org.uva.qls.ast.style.Width;
import org.uva.qls.ast.style.widget.CheckboxModel;
import org.uva.qls.ast.style.widget.RadioModel;
import org.uva.qls.ast.style.widget.SliderModel;
import org.uva.qls.ast.style.widget.SpinboxModel;
import org.uva.qls.ast.style.widget.TextboxModel;

public interface StyleVisitor<T> {

	public T visit(Height height);

	public T visit(Width width);

	public T visit(Fontsize fontsize);

	public T visit(Font font);

	public T visit(BackgroundColor color);

	public T visit(TextboxModel textboxModel);

	public T visit(SpinboxModel spinboxModel);

	public T visit(SliderModel sliderModel);

	public T visit(RadioModel radioModel);

	public T visit(CheckboxModel checkboxModel);

}
