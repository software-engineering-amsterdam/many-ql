from QLS.AST.options import *
from QLS.AST.sheet import *


class WidgetFactory:
    @staticmethod
    def make_option(tokens):
        return Options(tokens)

    @staticmethod
    def make_radio(tokens):
        if len(tokens) > 1:
            default = tokens[1]
        else:
            default = ""
        return Radio(tokens[0], default)

    @staticmethod
    def make_checkbox(tokens):
        return Checkbox(tokens[0])

    @staticmethod
    def make_spinbox(tokens):
        if len(tokens) > 1:
            default = tokens[1]
        else:
            default = ""
        return Spinbox(tokens[0], tokens[1], default)

    @staticmethod
    def make_slider(tokens):
        if len(tokens) > 1:
            default = tokens[1]
        else:
            default = ""
        return Slider(tokens[0], tokens[1])

    @staticmethod
    def make_textbox(tokens):
        return Textbox()

    @staticmethod
    def make_dropdown(tokens):
        if len(tokens) > 1:
            default = tokens[1]
        else:
            default = ""
        return DropDown(tokens[0])

    @staticmethod
    def make_widget(tokens):
        return Widget(tokens)


class QLSFactory:
    @staticmethod
    def make_font(tokens):
        pass

    @staticmethod
    def make_question_style(tokens):
        if len(tokens) > 1:
            widget = tokens[1]
        else:
            widget = None
        return QuestionStyle(tokens[0], widget)

    @staticmethod
    def make_section(tokens):
        return Section(tokens[0], tokens[1])

    @staticmethod
    def make_default(tokens):
        pass

    @staticmethod
    def make_page(tokens):
        return Page(tokens[0], tokens[1])

    @staticmethod
    def make_sheet(tokens):
        return Sheet(tokens[0], tokens[1])