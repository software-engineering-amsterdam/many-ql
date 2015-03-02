# interface


class Options:
    def __init__(self, options):
        self.options = options

    def pretty_print(self, level=0):
        s = "("
        for x in range(0, len(self.options) - 1):
            s += self.options[x] + ", "
        s += self.options[-1] + ")"
        return s


class NumberWidget:
    pass


class Radio:
    def __init__(self, options, default=""):
        self.options = options
        self.default = default

    def pretty_print(self, level=0):
        s = "    " * level + "Radio "
        s += self.options.pretty_print()
        s += "\n"
        return s


class Checkbox:
    def __init__(self, options):
        self.options = options

    def pretty_print(self, level=0):
        s = "    " * level + "Checkbox "
        s += self.options.pretty_print()
        s += "\n"
        return s


class Spinbox(NumberWidget):
    def __init__(self, min, max, default=""):
        self.min = min
        self.max = max
        self.default = default

    def pretty_print(self, level=0):
        s = "    " * level + "Spinbox "
        s += self.min + " " + self.max
        return s


class Textbox:
    def __init__(self):
        pass

    def pretty_print(self, level=0):
        return "    " * level + "Textbox \n"


class Slider(NumberWidget):
    def __init__(self, min, max, default=""):
        self.min = min
        self.max = max
        self.default = default

    def pretty_print(self, level=0):
        s = "    " * level + "Slider "
        s += self.min + " " + self.max
        s += "\n"
        return s


class DropDown(Options):
    def __init__(self, options, default=""):
        self.options = options
        self.default = default

    def pretty_print(self, level=0):
        s = "    " * level + "Drop down "
        s += self.options.pretty_print()
        return s


class Widget:
    def __init__(self, widget):
        self.widget = widget

    def pretty_print(self, level=0):
        x = self.widget
        return x.pretty_print(level)