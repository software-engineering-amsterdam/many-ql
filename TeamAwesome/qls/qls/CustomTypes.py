from decimal import *

class Identifier(str):
    def __new__(cls, string, lineNumber = None):
        obj = str.__new__(cls, string)
        obj._lineNumber = lineNumber
        return obj

    @property
    def lineNumber(self):
        return self._lineNumber