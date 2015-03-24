import QL.GUI.Elements.radio_button as r
import QL.GUI.Elements.spin_box as s
import QL.GUI.Elements.text_entry as t


class Factory:
    def __init__(self, statement, gui, frame):
        q_type = statement.ast.get_type_string()
        if q_type == bool:
            self.gui_element = r.RadioButton(statement, gui, frame)
        elif q_type == int:
            self.gui_element = s.SpinBox(statement, gui, frame)
        elif q_type == str:
            self.gui_element = t.TextEntry(statement, gui, frame)

    def get_gui_element(self):
        return self.gui_element