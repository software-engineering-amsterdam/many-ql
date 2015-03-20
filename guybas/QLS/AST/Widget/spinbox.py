import QLS.AST.Widget.widget as w
import QLS.AST.Widget.default_settings as d
import QL.Grammar.constants as constants


class Spinbox(w.Widget):
    def __init__(self, min, max, default=""):
        self.min = min
        self.max = max
        self.default = default
        self._properties = {self.widget_name(): d.DefaultSettings.return_settings() }


    def string_presentation(self, level=0):
        s = "    " * level + "Spinbox "
        s += self.min + " " + self.max
        s += "\n"
        return s

    def get_compatible(self):
        return [constants.NUMBER]

    def set_settings(self, dictionary):
        for x in dictionary:
            self._properties[x] = dictionary[x]

    def get_settings(self):
        return self._properties

    def widget_name(self):
        return "spinbox"