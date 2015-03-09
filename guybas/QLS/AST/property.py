import QLS.AST.Sheet as s

class Property:
    def __init__(self):
        raise NotImplementedError("Not implemented by sub class")

    def prop_name(self):
        raise NotImplementedError("Not implemented by sub class")

    def pretty_print(self, level=0):
        raise NotImplementedError("Not implemented by sub class")


class FontSize(Property):
    def __init__(self, number):
        self._number = number


    def prop_name(self):
        return "font-size"

    def pretty_print(self, level=0):
        return "    " * level + "font-size :" + self._number + "\n"


class Width(Property):
    def __init__(self, width):
        self._width = width

    def prop_name(self):
        return "widget-width"

    def pretty_print(self, level=0):
        return "    " * level + "widget-width :" + self._width + "\n"


class Height(Property):
    def __init__(self, height):
        self._height = height

    def prop_name(self):
        return "widget-height"

    def pretty_print(self, level=0):
        return "    " * level + "widget-height :" + self._height + "\n"


class Color(Property):
    def __init__(self, color):
        self._color = color

    def prop_name(self):
        return "font-color"

    def pretty_print(self, level=0):
        return "    " * level + "font-color :" + self._color + "\n"


# TODO: check if font exists
class Font(Property):
    def __init__(self, font):
        self._font = font

    def prop_name(self):
        return "font-family"

    def pretty_print(self, level=0):
        return "    " * level + "font-family :" + self._font + "\n"
