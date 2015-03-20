import QL.Runtime.question as ql_question
import QLS.GUI.Elements.factory as gui_elements_f


class Question(ql_question.Question):
    def set_gui_element(self, gui, frame):
        e_factory = gui_elements_f.Factory(self, gui, frame)
        el = e_factory.get_gui_element()
        self.gui_element = el.get_row()