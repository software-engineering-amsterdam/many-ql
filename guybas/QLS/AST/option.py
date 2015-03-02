# interface


class Option:
    def __init__(self, options):
        pass


class NumberWidget:
    pass


class Radio(Option):
    def __init__(self, options, default=""):
        self.options = options
        self.default = default


class Checkbox(Option):
    def __init__(self, options):
        self.options = options


class Spinbox(NumberWidget):
    def __init__(self, min, max):
        self.min = min
        self.max = max


class Textbox:
    def __init__(self):
        pass


class Slider(NumberWidget):
    def __init__(self, min, max):
        self.min = min 
        self.max = max


class DropDown:
    pass