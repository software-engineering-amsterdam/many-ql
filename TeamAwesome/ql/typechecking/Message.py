from ..ast import Nodes

class Message:
    def __init__(self, message, nodeOrLine = None):
        self._message = message
        self._line = getattr(nodeOrLine, 'lineNumber', nodeOrLine)

    @property
    def message(self):
        return self._message

    @property
    def line(self):
        return self._line

    def __str__(self):
        if self.line is None:
            return self.message
        else:
            return 'line '+str(self.line)+': '+self.message

class Warning(Message):
    def __str__(self):
        return '[WARNING] '+super().__str__()

class Error(Message):
    def __str__(self):
        return '[ERROR] '+super().__str__()
