import QLS.AST.Widget.widget as w
import QL.Grammar.constants as constants
import QLS.AST.Widget.default_settings as d


# Checkbox AST
class Checkbox(w.Widget):
    def __init__(self, options):
        self.options = options
        self._properties = {self.widget_name(): d.DefaultSettings.return_settings() }

    def pretty_print(self, level=0):
        s = "    " * level + "Checkbox "
        s += self.options.pretty_print()
        s += "\n"
        return s

    def get_compatible(self):
        return [constants.BOOL]

    def get_settings(self):
        return self._properties

    def set_settings(self, dictionary):
        for x in dictionary:
            self._properties[x] = dictionary[x]

    def widget_name(self):
        return "checkbox"