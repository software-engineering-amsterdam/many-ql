import QLS.AST.Widget.Options.radio as r
import QLS.AST.Widget.Options.checkbox as c
import QLS.AST.Widget.Options.drop_down as d
import QLS.AST.Widget.spinbox as s
import QLS.AST.Widget.slider as sl
import QLS.AST.Widget.textbox as t


def make_radio(tokens):
    option1 = tokens[0]
    option2 = tokens[1]
    if len(tokens) > 2:
        default = tokens[2]
    else:
        default = ""
    return r.Radio(option1, option2, default)


def make_checkbox(tokens):
    return c.Checkbox()


def make_drop_down(tokens):
    option1 = tokens[0]
    option2 = tokens[1]
    if len(tokens) > 2:
        default = tokens[2]
    else:
        default = ""
    return d.DropDown(option1, option2, default)


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
