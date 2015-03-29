import QL.Runtime.question as ql_question
import QLS.GUI.Elements.factory as gui_elements_f


class Question(ql_question.Question):
    def __init__(self, ast_question, order, condition):
        ql_question.Question.__init__(self, ast_question, order, condition)
        self.bg_color = None
        self.fg_color = None
        self.font_style = None

    def set_gui_element(self, gui, frame):
        e_factory = gui_elements_f.Factory(self, gui, frame)
        self.gui_element = e_factory.get_gui_element()

        self.gui_element.set_bg_colour(self.bg_color)
        self.gui_element.set_fg_colour(self.fg_color)
        self.gui_element.set_font_style(self.font_style)

        # self.gui_element = el.get_row()

    def set_bg_color(self, color):
        self.bg_color = color

    def set_fg_color(self, color):
        self.fg_color = color

    def set_font_style(self, style):
        self.font_style = style