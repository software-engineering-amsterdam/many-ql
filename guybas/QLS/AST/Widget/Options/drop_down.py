import QLS.AST.Widget.widget as w
import QL.Grammar.constants as constants


class DropDown(w.Widget):
    def __init__(self, options, default=""):
        self.options = options
        self.default = default
        self._properties = {self.widget_name(): "" }

    def string_presentation(self, level=0):
        s = "    " * level + "Drop down "
        s += self.options.string_presentation()
        return s

    def get_compatible(self):
        return [constants.GrammarConstants.BOOL, constants.GrammarConstants.NUMBER]

    def get_settings(self):
        return self._properties

    def set_settings(self, dictionary):
        for x in dictionary:
            self._properties[x] = dictionary[x]

    def widget_name(self):
        return "dropdown"