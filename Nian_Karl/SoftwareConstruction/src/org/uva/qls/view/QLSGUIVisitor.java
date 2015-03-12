package org.uva.qls.view;

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
import org.uva.qls.visitor.StyleVisitor;

public class QLSGUIVisitor implements StyleVisitor<Void> {

	@Override
	public Void visit(Height height) {
		return null;
	}

	@Override
	public Void visit(Width width) {
		return null;
	}

	@Override
	public Void visit(Fontsize fontsize) {
		return null;
	}

	@Override
	public Void visit(Font font) {
		return null;
	}

	@Override
	public Void visit(BackgroundColor color) {
		return null;
	}

	@Override
	public Void visit(TextboxModel textboxModel) {
		return null;
	}

	@Override
	public Void visit(SpinboxModel spinboxModel) {
		return null;
	}

	@Override
	public Void visit(SliderModel sliderModel) {
		return null;
	}

	@Override
	public Void visit(RadioModel radioModel) {
		return null;
	}

	@Override
	public Void visit(CheckboxModel checkboxModel) {
		return null;
	}

}
