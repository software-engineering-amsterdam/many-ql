import QLS.AST.Widget.widget as w
import QL.Grammar.constants as constants

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
        return [constants.GrammarConstants.BOOL, constants.GrammarConstants.NUMBER]