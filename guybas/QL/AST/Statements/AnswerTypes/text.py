import QL.GUI.Elements.text_entry as t
import QL.Grammar.constants as constants


class Text:
    def __init__(self):
        pass

    def pretty_print(self, level = 0):
        return "    " * level + constants.TEXT

    def get_gui_element(self, statement, gui):
        return t.TextEntry(statement, gui)