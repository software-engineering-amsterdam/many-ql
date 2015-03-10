import QLS.AST.Widget.widget as w
import QL.Grammar.constants as constants


class Slider(w.Widget):
    def __init__(self, min, max, default=""):
        self.min = min
        self.max = max
        self.default = default

    def pretty_print(self, level=0):
        s = "    " * level + "Slider "
        s += self.min + " " + self.max
        s += "\n"
        return s

    def get_compatible(self):
        raise NotImplementedError("Not implemented by sub class")

    def get_range(self):
        return [constants.GrammarConstants.NUMBER]

    def get_settings(self):
        raise NotImplementedError("Not implemented by sub class")

    def set_settings(self):
        raise NotImplementedError("Not implemented by sub class")