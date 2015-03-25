import QL.AST.Statements.question as ast_q
import QL.Tools.exceptions as e
import QL.GUI.Elements.factory as gui_elements_f


class Question:
    def __init__(self, ast_question, order, condition):
        # if not isinstance(ast_question, ast_q.Question):
        #     raise e.QException("Input must be an Question Object!")

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
        return self.ast.get_label()

    def get_gui_element(self):
        return self.gui_element

    def get_ast(self):
        return self.ast

    def get_condition(self):
        return self.condition

    def get_statement_dict(self):
        return {self.ast.get_id(): self}

    def get_gui_element_frame(self):
        return self.gui_element_frame