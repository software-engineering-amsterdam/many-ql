import QLS.AST.Widget.widget_interface as w
import QL.Grammar.constants as constants


# Checkbox AST
class Checkbox(w.IWidget):
    def __init__(self):
        self._properties = {self.widget_name(): "" }

    def string_presentation(self, level=0):
        s = "    " * level + "Checkbox\n"
        return s

    def get_compatible(self):
        return [constants.BOOL]

    def get_settings(self):
        return self._properties

    def set_settings(self, dictionary):
        for x in dictionary:
            self._properties[x] = dictionary[x]

    def widget_name(self):
        return "checkbox"