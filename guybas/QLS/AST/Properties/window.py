import QLS.AST.Properties.property as p


class Width(p.Property):
    def __init__(self, width):
        self._width = width

    def prop_name(self):
        return "get_widget-width"

    def prop_value(self):
        return self._width

    def string_presentation(self, level=0):
        return "    " * level + "get_widget-width : " + self._width + "\n"


class Height(p.Property):
    def __init__(self, height):
        self._height = height

    def prop_name(self):
        return "get_widget-height"

    def prop_value(self):
        return self._height

    def string_presentation(self, level=0):
        return "    " * level + "get_widget-height : " + self._height + "\n"