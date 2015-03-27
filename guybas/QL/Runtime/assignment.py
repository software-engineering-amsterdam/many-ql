import QL.Runtime.question as question


class Assignment(question.Question):
    def set_gui_element(self, gui, frame):
        pass

    def get_id(self):
        return self.ast.get_id()

    def evaluate_expression(self, answer_map):
        return self.ast.evaluate_expression(answer_map)