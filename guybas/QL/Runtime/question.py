import QL.AST.Statements.question as ast_q
import QL.Tools.exceptions as e
import QL.GUI.Elements.factory as gui_elements_f


class Question:
    def __init__(self, ast_question, order, condition):
        self.order = order
        self.gui_element = None
        self.gui_element_frame = None
        self.ast = ast_question
        self.condition = condition

    def set_gui_element(self, gui, frame):
        e_factory = gui_elements_f.Factory(self, gui, frame)
        el = e_factory.get_gui_element()
        self.gui_element = el.get_row()
        self.gui_element_frame = frame

    def get_order(self):
        return self.order

    def get_label(self):
        return self.ast.labels()[0]

    def get_gui_element(self):
        return self.gui_element

    def get_ast(self):
        return self.ast

    def get_condition(self):
        return self.condition

    def id_statement_map(self):
        return {self.ast.ids()[0]: self}

    def get_gui_element_frame(self):
        return self.gui_element_frame