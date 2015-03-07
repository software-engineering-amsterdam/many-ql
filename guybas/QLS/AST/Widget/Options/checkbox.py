import QLS.AST.Widget.widget as w


# Checkbox AST
class Checkbox(w.Widget):
    def __init__(self, options):
        self.options = options

    def pretty_print(self, level=0):
        s = "    " * level + "Checkbox "
        s += self.options.pretty_print()
        s += "\n"
        return s

    def get_compatible(self):
        raise NotImplementedError("Not implemented by sub class")