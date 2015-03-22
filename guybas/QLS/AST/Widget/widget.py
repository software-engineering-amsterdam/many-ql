import QLS.AST.Widget.widget_interface as w


class Widget(w.IWidget):
    def __init__(self, widget, default_settings):
        self.widget = widget
        self.default_settings = default_settings
        self._properties = {self.widget_name(): "" }

    def string_presentation(self, level=0):
        s = "    " * level + "Widget " + self.widget.string_presentation()
        for i in self.default_settings:
            s += i.string_presentation(level + 2)
        return s

    def get_compatible(self):
        return self.widget.get_compatible()

    def set_settings(self, dictionary):
        for x in dictionary:
            self._properties[x] = dictionary[x]

    def get_settings(self):
        return self._properties

    def widget_name(self):
        return "widget"

    def widget(self):
        return self.widget

    def defaults(self):
        return self.default_settings

    def property_map(self):
        d = {}
        for i in self.default_settings:
            d[i.prop_name()] = i.prop_value()
        return d
