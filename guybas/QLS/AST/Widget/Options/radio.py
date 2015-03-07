import QLS.AST.Widget.widget as w
import QL.Grammar.constants as constants


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
        return [constants.GrammarConstants.BOOL, constants.GrammarConstants.NUMBER]