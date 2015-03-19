import QLS.AST.Widget.Options.options as op
import QLS.AST.Widget.Options.radio as r
import QLS.AST.Widget.Options.checkbox as c
import QLS.AST.Widget.Options.drop_down as d
import QLS.AST.Widget.spinbox as s
import QLS.AST.Widget.slider as sl
import QLS.AST.Widget.textbox as t


def make_option(tokens):
    return op.Options(tokens)


def make_radio(tokens):
    options = tokens[0]
    if len(tokens) > 1:
        default = tokens[1]
    else:
        default = ""
    return r.Radio(options, default)


def make_checkbox(tokens):
    options = tokens[0]
    return c.Checkbox(options)


def make_drop_down(tokens):
    options = tokens[0]
    if len(tokens) > 1:
        default = tokens[1]
    else:
        default = ""
    return d.DropDown(options, default)


def make_spinbox(tokens):
    min_value = tokens[0]
    max_value = tokens[1]
    if len(tokens) > 2:
        default = tokens[2]
    else:
        default = ""
    return s.Spinbox(min_value, max_value, default)


def make_slider(tokens):
    min_value = tokens[0]
    max_value = tokens[1]
    if len(tokens) > 2:
        default = tokens[2]
    else:
        default = ""
    return sl.Slider(min_value, max_value, default)


def make_textbox(tokens):
    return t.Textbox()
