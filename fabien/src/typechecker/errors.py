
class ParseError(Exception):
    def __init__(self, Token=None):
        # ParseError on form block
        if not Token:
            self.type   = "Form"

        else:
            self.type   = Token.type
            self.value  = Token.value
            self.lineno = Token.lineno
            self.lexpos = Token.lexpos

    def __str__(self):
        return "LexToken(%s,%r,%d,%d)" % (self.type,self.value,self.lineno,self.lexpos)
