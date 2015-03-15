import QL.GUI.Elements.radio_button as r
import QL.Grammar.constants as constants


class Bool:
    def __init__(self):
        pass

    def pretty_print(self, level=0):
        return "    " * level + constants.BOOL

    def get_gui_element(self, statement, gui):
        return r.RadioButton(statement, gui)