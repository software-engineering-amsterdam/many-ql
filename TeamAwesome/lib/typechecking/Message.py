class Message:
    def __init__(self, text, nodeOrLine = None):
        self._text = text
        self._line = getattr(nodeOrLine, 'lineNumber', nodeOrLine)

    @property
    def text(self):
        return self._text

    @property
    def line(self):
        return self._line

    def __str__(self):
        if self.line is None:
            return self.text
        else:
            return 'line '+str(self.line)+': '+self.text


class Warning(Message):
    def __str__(self):
        return '[WARNING] '+super().__str__()


class Error(Message):
    def __str__(self):
        return '[ERROR] '+super().__str__()
