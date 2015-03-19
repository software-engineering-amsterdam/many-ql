import QL.Grammar.constants as c
import QL.GUI.Elements.radio_button as r
import QL.GUI.Elements.spin_box as s
import QL.GUI.Elements.text_entry as t


class Factory:
    def __init__(self, statement, gui):
        q_type = statement.get_ast_question().get_type()
        if q_type == c.BOOL:
            self.gui_element = r.RadioButton(statement, gui)
        elif q_type == c.NUMBER:
            self.gui_element = s.SpinBox(statement, gui)
        elif q_type == c.TEXT:
            self.gui_element = t.TextEntry(statement, gui)

    def get_gui_element(self):
        return self.gui_element