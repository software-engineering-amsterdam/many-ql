import QLS.AST.Widget.widget_interface as w
from QL.AST.Expressions.Types import *


# Checkbox AST
class Checkbox(w.IWidget):
    def __init__(self):
        self._properties = {self.widget_name(): "" }

    def string_presentation(self, level=0):
        s = "    " * level + "Checkbox\n"
        return s

    def get_compatible(self):
        return [bool_type.Bool()]

    def get_settings(self):
        return self._properties

    def set_settings(self, dictionary):
        for x in dictionary:
            self._properties[x] = dictionary[x]

    def widget_name(self):
        return "checkbox"