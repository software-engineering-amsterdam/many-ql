import QL.AST.Statements.question as ast_q
import QL.Tools.exceptions as e
import QL.GUI.Elements.factory as gui_elements_f


class Question:
    def __init__(self, ast_question, order, condition):
        self.order_number = order
        self.gui_element = None
        self.ast_question = ast_question
        self.condition = condition

    def set_gui_element(self, gui):
        e_factory = gui_elements_f.Factory(self, gui)
        el = e_factory.get_gui_element()
        self.gui_element = el.get_row()

    def get_order_number(self):
        return self.order_number

    def get_label(self):
        return self.ast_question.get_label()

    def get_gui_element(self):
        return self.gui_element

    def get_ast_question(self):
        return self.ast_question

    def get_condition(self):
        return self.condition

    def get_statement_dict(self):
        return {self.ast_question.get_id(): self}