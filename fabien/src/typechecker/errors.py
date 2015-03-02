
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
        return "Syntax error at line %d: %d\nNear Token(%s,%r)" % \
            (self.lineno, self.lexpos, self.type, self.value)


class DuplicationError(Exception):
    def __init__(self, Question=None, DuplicateQuestion=None):
        self.question  = Question
        self.duplicate = DuplicateQuestion

        self.lineno   = DuplicateQuestion.lineNr

    def __str__(self):
        return "Duplicate ID `%s` with different types (%s and %s) at line %s" % \
            (self.question.ID, self.question.type, self.duplicate.type, self.lineno)


class UndefinedError(Exception):
    def __init__(self, Expression=None):
        self.expression = Expression

        self.lineno   = Expression.lineNr

    def __str__(self):
        return "Undefined ID `%s` at line %s" % \
            ("test", self.lineno)


class QLTypeError(Exception):
    def __init__(self, Node=None):
        self.node = Node

        if not Node.left:
            self.lineno = Node.lineNr
        else:
            self.lineno = Node.left.lineNr

    def __str__(self):
        return "TypeError `%s` at line %s" % \
            (self.node, self.lineno)
