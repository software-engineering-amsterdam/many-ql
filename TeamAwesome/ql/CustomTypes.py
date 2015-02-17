from decimal import *

class Money(Decimal):
    pass

class Identifier(str):
    def __new__(cls, string, lineNumber):
        obj = str.__new__(cls, string)
        obj.lineNumber = lineNumber
        return obj