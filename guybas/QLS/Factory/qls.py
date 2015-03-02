from QLS.AST.option import *
from QLS.AST.sheet import *

class WidgetFactory:
    @staticmethod
    def make_radio(tokens):
        if tokens[1] == "Default":
            default = tokens[2]
        else:
            default = ""
        return Radio(tokens[0], default)


    @staticmethod
    def make_checkbox(tokens):
        return Checkbox(tokens)

    @staticmethod
    def make_spinbox(tokens):
        return Spinbox(tokens[0], tokens[1])

    @staticmethod
    def make_slider(tokens):
        pass

    @staticmethod
    def make_textbox(tokens):
        pass

    @staticmethod
    def make_dropdown(tokens):
        pass

    @staticmethod
    def make_widget(tokens):
        pass


class QLSFactory:
    @staticmethod
    def make_font(tokens):
        pass

    @staticmethod
    def make_question_style(tokens):
        pass

    @staticmethod
    def make_section(tokens):
        pass

    @staticmethod
    def make_default(tokens):
        pass

    @staticmethod
    def make_page(tokens):
        pass

    @staticmethod
    def make_sheet(tokens):
        pass