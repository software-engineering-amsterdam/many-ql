import QLS.AST.Properties.property as p


class FontColor(p.Property):
    def __init__(self, color):
        self._color = color

    def prop_name(self):
        return "font-color"

    def prop_value(self):
        return self._color

    def pretty_print(self, level=0):
        return "    " * level + "font-color :" + self._color + "\n"


# TODO: check if font exists
class Font(p.Property):
    def __init__(self, font):
        self._font = font

    def prop_name(self):
        return "font-family"

    def prop_value(self):
        return self._font

    def pretty_print(self, level=0):
        return "    " * level + "font-family :" + self._font + "\n"


class FontSize(p.Property):
    def __init__(self, number):
        self._number = number

    def prop_name(self):
        return "font-size"

    def prop_value(self):
        return self._number

    def pretty_print(self, level=0):
        return "    " * level + "font-size :" + self._number + "\n"