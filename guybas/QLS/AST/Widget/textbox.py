import QLS.AST.Widget.widget as w
import QL.Grammar.constants as constants
import QLS.AST.Widget.default_settings as d


class Textbox(w.Widget):
    def __init__(self):
        self._properties = {self.widget_name(): d.DefaultSettings.return_settings() }

    def string_presentation(self, level=0):
        return "    " * level + "Textbox \n"

    def get_compatible(self):
        return [constants.GrammarConstants.TEXT]

    def set_settings(self, dictionary):
        for x in dictionary:
            self._properties[x] = dictionary[x]

    def get_settings(self):
        return self._properties

    def widget_name(self):
        return "textbox"
