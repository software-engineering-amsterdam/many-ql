from QLS.AST.Widget import *


def make_radio(tokens):
    option1 = tokens[0]
    option2 = tokens[1]
    if len(tokens) > 2:
        default = tokens[2]
    else:
        default = ""
    return radio.Radio(option1, option2, default)


def make_checkbox(tokens):
    return checkbox.Checkbox()


def make_drop_down(tokens):
    option1 = tokens[0]
    option2 = tokens[1]
    if len(tokens) > 2:
        default = tokens[2]
    else:
        default = ""
    return drop_down.DropDown(option1, option2, default)


def make_spinbox(tokens):
    min_value = tokens[0]
    max_value = tokens[1]
    if len(tokens) > 2:
        default = tokens[2]
    else:
        default = ""
    return spinbox.Spinbox(min_value, max_value, default)


def make_slider(tokens):
    min_value = tokens[0]
    max_value = tokens[1]
    if len(tokens) > 2:
        default = tokens[2]
    else:
        default = ""
    return slider.Slider(min_value, max_value, default)


def make_textbox(tokens):
    return textbox.Textbox()


def make_widget(tokens):
    actual_widget = tokens[0]
    if len(tokens) > 1:
        properties = tokens[1]
    else:
        properties = []
    return widget.Widget(actual_widget, properties)