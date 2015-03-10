import QLS.AST.Widget.widget as w
import QLS.AST.Widget.default_settings as d


class Spinbox(w.Widget):
    def __init__(self, min, max, default=""):
        self.min = min
        self.max = max
        self.default = default
        self._properties = {self.widget_name(): d.DefaultSettings.return_settings() }


    def pretty_print(self, level=0):
        s = "    " * level + "Spinbox "
        s += self.min + " " + self.max
        s += "\n"
        return s

    def get_compatible(self):
        raise NotImplementedError("Not implemented by sub class")

    def set_settings(self, dictionary):
        for x in dictionary:
            self._properties[x] = dictionary[x]

    def get_settings(self):
        return self._properties

    def widget_name(self):
        return "spinbox"