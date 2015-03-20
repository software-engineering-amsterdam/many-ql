import QLS.AST.Widget.widget as w
import QL.Grammar.constants as constants


class Slider(w.Widget):
    def __init__(self, min_value, max_value, default=""):
        self.min = min_value
        self.max = max_value
        self.default = default
        self._properties = {self.widget_name(): ""}

    def string_presentation(self, level=0):
        s = "    " * level + "Slider "
        s += self.min + " " + self.max
        s += "\n"
        return s

    def get_compatible(self):
        raise NotImplementedError("Not implemented by sub class")

    def get_range(self):
        return [constants.GrammarConstants.NUMBER]

    def get_settings(self):
        return self._properties

    def set_settings(self, dictionary):
        for x in dictionary:
            self._properties[x] = dictionary[x]

    def widget_name(self):
        return "slider"