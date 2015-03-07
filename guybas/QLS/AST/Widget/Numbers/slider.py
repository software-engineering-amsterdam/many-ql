import QLS.AST.Widget.Numbers.number_widget as n


class Slider(n.NumberWidget):
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
        raise NotImplementedError("Not implemented by sub class")