import QLS.AST.Widget.widget as w
import QL.Grammar.constants as constants


class Spinbox(w.Widget):
    def __init__(self, min, max, default=""):
        self.min = min
        self.max = max
        self.default = default

    def pretty_print(self, level=0):
        s = "    " * level + "Spinbox "
        s += self.min + " " + self.max
        s += "\n"
        return s

    def get_compatible(self):
        raise NotImplementedError("Not implemented by sub class")