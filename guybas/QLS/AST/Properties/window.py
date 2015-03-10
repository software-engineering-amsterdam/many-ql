import QLS.AST.Properties.property as p


class Width(p.Property):
    def __init__(self, width):
        self._width = width

    def prop_name(self):
        return "widget-width"

    def prop_value(self):
        return self._width

    def pretty_print(self, level=0):
        return "    " * level + "widget-width :" + self._width + "\n"


class Height(p.Property):
    def __init__(self, height):
        self._height = height

    def prop_name(self):
        return "widget-height"

    def prop_value(self):
        return self._height

    def pretty_print(self, level=0):
        return "    " * level + "widget-height :" + self._height + "\n"