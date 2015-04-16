
class ParseError(Exception):
    def __init__(self, Token=None, message=None):
        # ParseError on form block
        if not Token:
            self.type   = "Form"
            self.lineno = 0
            self.value  = ""

        else:
            self.type   = Token.type
            self.value  = Token.value
            self.lineno = Token.lineno

    def __str__(self):
        return "Syntax error at (or just before) line %d\nGiven `%r` could not identify as %s" % \
            (self.lineno, self.value, self.type)
