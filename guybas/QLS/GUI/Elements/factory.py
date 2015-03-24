import QL.Grammar.constants as c
import QLS.GUI.Elements.radio_button as r
import QLS.GUI.Elements.spin_box as s
import QLS.GUI.Elements.text_entry as t


class Factory:
    def __init__(self, statement, gui, frame):
        q_type = statement.ast.get_type_string()
        if q_type == c.BOOL:
            self.gui_element = r.RadioButton(statement, gui, frame)
        elif q_type == c.NUMBER:
            self.gui_element = s.SpinBox(statement, gui, frame)
        elif q_type == c.TEXT:
            self.gui_element = t.TextEntry(statement, gui, frame)

    def get_gui_element(self):
        return self.gui_element