import QL.Grammar.constants as c
import QLS.GUI.Elements.radio_button as r
import QLS.GUI.Elements.spin_box as s
import QLS.GUI.Elements.text_entry as t

# TODO fix error here
# File "C:\Users\Bas\Desktop\Development\Python\guybas\QLS\GUI\Elements\factory.py", line 11, in __init__
#     self.gui_element = r.RadioButton(statement, gui)
# TypeError: __init__() takes 1 positional argument but 3 were given


class Factory:
    def __init__(self, statement, gui):
        q_type = statement.ast.get_type()
        if q_type == c.BOOL:
            self.gui_element = r.RadioButton(statement, gui)
        elif q_type == c.NUMBER:
            self.gui_element = s.SpinBox(statement, gui)
        elif q_type == c.TEXT:
            self.gui_element = t.TextEntry(statement, gui)

    def get_gui_element(self):
        return self.gui_element