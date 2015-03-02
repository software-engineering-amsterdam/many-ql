
class ParseError:
    def __init__(self, Token=None, message=None):
        # ParseError on form block
        if not Token:
            self.type   = "Form"

        else:
            self.type   = Token.type
            self.value  = Token.value
            self.lineno = Token.lineno
            self.lexpos = Token.lexpos

            self.message = message

    def __str__(self):
        return "Syntax error at line %d: %d\nNear Token(%s,%r)" % \
            (self.lineno, self.lexpos, self.type, self.value)
