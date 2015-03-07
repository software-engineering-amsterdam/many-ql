import QLS.AST.Widget.widget as w


class Radio(w.Widget):
    def __init__(self, options, default=""):
        self.options = options
        self.default = default

    def pretty_print(self, level=0):
        s = "    " * level + "Radio "
        s += self.options.pretty_print()
        s += "\n"
        return s

    def get_compatible(self):
        raise NotImplementedError("Not implemented by sub class")