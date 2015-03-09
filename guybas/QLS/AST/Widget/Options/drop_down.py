import QLS.AST.Widget.widget as w
import QL.Grammar.constants as constants


class DropDown(w.Widget):
    def __init__(self, options, default=""):
        self.options = options
        self.default = default

    def pretty_print(self, level=0):
        s = "    " * level + "Drop down "
        s += self.options.pretty_print()
        return s

    def get_compatible(self):
        return [constants.GrammarConstants.BOOL, constants.GrammarConstants.NUMBER]