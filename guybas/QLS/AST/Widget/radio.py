import QLS.AST.Widget.widget_interface as w
import QL.Grammar.constants as constants


class Radio(w.IWidget):
    def __init__(self, option1, option2, default=""):
        self.option1 = option1
        self.option2 = option2
        self.default = default
        self._properties = {self.widget_name(): ""}

    def string_presentation(self, level=0):
        s = "    " * level + "Radio "
        s += "(" + self.option1 + ", " + self.option2 + ")\n"
        return s

    def get_compatible(self):
        return [constants.BOOL, constants.NUMBER]

    def get_settings(self):
        return self._properties

    def set_settings(self, dictionary):
        for x in dictionary:
            self._properties[x] = dictionary[x]

    def widget_name(self):
        return "radiobox"