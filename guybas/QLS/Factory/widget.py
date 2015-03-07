import QLS.AST.Widget.Options.options as op
import QLS.AST.Widget.Options.radio as r
import QLS.AST.Widget.Options.checkbox as c
import QLS.AST.Widget.Options.drop_down as d
import QLS.AST.Widget.Numbers.spinbox as s
import QLS.AST.Widget.Numbers.slider as sl
import QLS.AST.Widget.textbox as t


class WidgetFactory:
    @staticmethod
    def make_option(tokens):
        return op.Options(tokens)

    @staticmethod
    def make_radio(tokens):
        options = tokens[0]
        if len(tokens) > 1:
            default = tokens[1]
        else:
            default = ""
        return r.Radio(options, default)

    @staticmethod
    def make_checkbox(tokens):
        options = tokens[0]
        return c.Checkbox(options)

    @staticmethod
    def make_drop_down(tokens):
        options = tokens[0]
        if len(tokens) > 1:
            default = tokens[1]
        else:
            default = ""
        return d.DropDown(options)

    @staticmethod
    def make_spinbox(tokens):
        if len(tokens) > 1:
            default = tokens[1]
        else:
            default = ""
        return s.Spinbox(tokens[0], tokens[1], default)

    @staticmethod
    def make_slider(tokens):
        if len(tokens) > 1:
            default = tokens[1]
        else:
            default = ""
        return sl.Slider(tokens[0], tokens[1])

    @staticmethod
    def make_textbox(tokens):
        return t.Textbox()
