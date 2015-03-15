import QL.GUI.Elements.spin_box as s
import QL.Grammar.constants as constants


class Number:
    def __init__(self):
        pass

    def pretty_print(self, level = 0):
        return "    " * level + constants.NUMBER

    def get_gui_element(self, statement, gui):
        return s.SpinBox(statement, gui)