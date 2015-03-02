
class UndefinedError:
    def __init__(self, Expression=None, message=None):
        self.expression = Expression
        self.lineno     = Expression.lineNr
        self.message    = message

    def __str__(self):
        return "Undefined ID `%s` at line %s" % \
            ("test", self.lineno)
