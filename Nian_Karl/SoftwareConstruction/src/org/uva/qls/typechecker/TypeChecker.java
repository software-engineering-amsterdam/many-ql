package org.uva.qls.typechecker;

import java.util.ArrayList;

import org.uva.qls.ast.literal.BoolLiteral;
import org.uva.qls.ast.literal.ColorLiteral;
import org.uva.qls.ast.literal.IdentifierLiteral;
import org.uva.qls.ast.literal.IntLiteral;
import org.uva.qls.ast.literal.StrLiteral;
import org.uva.qls.ast.sheet.Page;
import org.uva.qls.ast.sheet.Question;
import org.uva.qls.ast.sheet.Section;
import org.uva.qls.ast.sheet.Sheet;
import org.uva.qls.ast.sheet.Style;
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
import org.uva.qls.visitor.LiteralVisitor;
import org.uva.qls.visitor.SheetVisitor;
import org.uva.qls.visitor.StyleVisitor;
import org.uva.util.message.MessageManager;
import org.uva.util.message.Warning;
import org.uva.util.message.Warning.Type;

public class TypeChecker implements LiteralVisitor<Boolean>, StyleVisitor<Boolean>, SheetVisitor<Boolean> {

	private MessageManager manager;

	public TypeChecker() {
		manager = new MessageManager();
	}

	@Override
	public Boolean visit(Height height) {
		if (height.isValid()) {
			return true;
		}
		manager.addWarning(new Warning(Type.INVALID_INPUT, height.getPosition().getStartLine(), height.toString()));
		return false;
	}

	@Override
	public Boolean visit(Width width) {
		if (width.isValid()) {
			return true;
		}
		manager.addWarning(new Warning(Type.BELOW_ZERO, width.getPosition().getStartLine(), width.toString()));
		return false;
	}

	@Override
	public Boolean visit(Fontsize fontsize) {
		if (fontsize.isValid()) {
			return true;
		}
		manager.addWarning(new Warning(Type.BELOW_ZERO, fontsize.getPosition().getStartLine(), fontsize.toString()));
		return false;
	}

	@Override
	public Boolean visit(Font font) {
		if (font.isValid()) {
			return true;
		}
		manager.addWarning(new Warning(Type.BELOW_ZERO, font.getPosition().getStartLine(), font.toString()));
		return false;
	}

	@Override
	public Boolean visit(BackgroundColor color) {
		if (color.isValid()) {
			return true;
		}
		manager.addWarning(new Warning(Type.INVALID_INPUT, color.getPosition().getStartLine(), color.toString()));
		return false;
	}

	@Override
	public Boolean visit(TextboxModel textboxModel) {
		if (textboxModel.isValid()) {
			return true;
		}
		manager.addWarning(new Warning(Type.INVALID_INPUT, textboxModel.getPosition().getStartLine(), textboxModel
				.toString()));
		return false;
	}

	@Override
	public Boolean visit(SpinboxModel spinboxModel) {
		ArrayList<IntLiteral> duplicatedValues = spinboxModel.isValid();
		if (duplicatedValues.isEmpty()) {
			return true;
		}
		for (IntLiteral intLiteral : duplicatedValues) {
			manager.addWarning(new Warning(Type.DUPLICATED_VALUES, spinboxModel.getPosition().getStartLine(),
					intLiteral.toString()));
		}
		return false;
	}

	@Override
	public Boolean visit(SliderModel sliderModel) {
		if (sliderModel.getMin().accept(this) && sliderModel.getMax().accept(this)) {
			if (sliderModel.isValid()) {
				return true;
			} else {
				manager.addWarning(new Warning(Type.INVALID_INPUT, sliderModel.getPosition().getStartLine(),
						sliderModel.toString()));
			}
		}
		return false;
	}

	@Override
	public Boolean visit(RadioModel radioModel) {
		if (radioModel.getFirst().accept(this) && radioModel.getSecond().accept(this)) {
			if (radioModel.isValid()) {
				return true;
			} else {
				manager.addWarning(new Warning(Type.INVALID_INPUT, radioModel.getPosition().getStartLine(), radioModel
						.toString()));
			}
		}
		return false;
	}

	@Override
	public Boolean visit(CheckboxModel checkboxModel) {
		return checkboxModel.isValid();
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		if (node.getValue().isDefined()) {
			return true;
		}
		manager.addWarning(new Warning(Type.UNDEFINED, node.getPosition().getStartLine(), node.toString()));
		return false;
	}

	@Override
	public Boolean visit(IntLiteral node) {
		if (node.getValue().isDefined()) {
			return true;
		}
		manager.addWarning(new Warning(Type.UNDEFINED, node.getPosition().getStartLine(), node.toString()));
		return false;
	}

	@Override
	public Boolean visit(StrLiteral node) {
		if (node.getValue().isDefined()) {
			return true;
		}
		manager.addWarning(new Warning(Type.UNDEFINED, node.getPosition().getStartLine(), node.toString()));
		return false;
	}

	@Override
	public Boolean visit(ColorLiteral node) {
		if (node.getValue().isDefined()) {
			return true;
		}
		manager.addWarning(new Warning(Type.UNDEFINED, node.getPosition().getStartLine(), node.toString()));
		return false;
	}

	@Override
	public Boolean visit(IdentifierLiteral node) {
		if (node.getValue().isDefined()) {
			return true;
		}
		manager.addWarning(new Warning(Type.UNDEFINED, node.getPosition().getStartLine(), node.toString()));
		return false;
	}

	@Override
	public Boolean visit(Page page) {
		return true;
	}

	@Override
	public Boolean visit(Question question) {
		return true;
	}

	@Override
	public Boolean visit(Section section) {
		return true;
	}

	@Override
	public Boolean visit(Sheet sheet) {
		return true;
	}

	@Override
	public Boolean visit(Style style) {
		return true;
	}

}