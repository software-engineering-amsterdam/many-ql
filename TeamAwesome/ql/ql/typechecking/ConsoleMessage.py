from . import Message



class ConsoleMessage:
    def __init__(self, level, scope, text):
        self._level = level
        self._scope = scope
        self._text = text


    @property
    def lineNumber(self):
        return self._scope.lineNumber


    # allows messages to be ordered
    def __lt__(self, other):
        if self.lineNumber is None:
            return False
        elif other.lineNumber is None:
            return True
        else:
            return self.lineNumber < other.lineNumber


    def __str__(self):
        prefixParts = filter(
            lambda s: s != '',
            map(str, [self._level, self._scope])
        )

        return '[%s] %s' % (' '.join(prefixParts), self._text)



# See ErrorsWarningsResult.py for the rationale of why factories are
# created this way, in short: it's the Python way of doing generics.
def factory(parser, cls = ConsoleMessage):
    class Factory(Message.Factory):
        def __init__(self, parser):
            self._parser = parser


        def duplicateLabel(self, label, lineNumber):
            return cls(
                Warning(),
                Local(lineNumber),
                'Duplicate question label `%s`' % (label)
            )


        def questionCycle(self, questionCycle, lineNumber):
            text = 'There is a question dependency cycle: %s. \
It means the calculation of `%s` requires its own \
result as input. This is not possible. Please double check \
the definitions of the questions.' % (
                    ' <- '.join(
                        ['`%s`' % (q.identifier) for q in questionCycle]
                    ),
                    questionCycle[0].identifier
                )

            return cls(
                Error(),
                Local(lineNumber),
                text
            )
            

        def questionRedefinition(
            self, question, actualType, expectedType, lineNumber
        ):
            text = 'Redefinition of question `%s` with different \
type `%s` (expected type `%s`)' % (
                    question.identifier,
                    self._parser.expressionTypeToken(actualType),
                    self._parser.expressionTypeToken(expectedType)
                )

            return cls(
                Error(),
                Local(lineNumber),
                text
            )
                

        def incompatibleExpressionType(
            self, actualType, allowedTypes, lineNumber
        ):
            actualTypeText = self._parser.expressionTypeToken(actualType)
            allowedTypesText = list(map(
                lambda t: '`%s`' % (self._parser.expressionTypeToken(t)),
                allowedTypes
            ))
            text = 'Got an expression of type `%s` which is not \
compatible with any of the following types which are \
allowed here: %s' % (
                    actualTypeText, ', '.join(allowedTypesText)
                )

            return cls(
                Error(),
                Local(lineNumber),
                text
            )


        def undeclaredIdentifier(self, identifier, lineNumber):
            return cls(
                Error(),
                Local(lineNumber),
                'Undeclared identifier `%s`' % (identifier)
            )


        def invalidOperands(self, operator, operands, lineNumber):
            text = 'Invalid operand(s) to operator `%s`: %s' % (
                self._parser.operatorToken(operator),
                ', '.join([str(operand) for operand in operands])
            )

            return cls(
                Error(),
                Local(lineNumber),
                text
            )

    return Factory(parser)



class Level:
    def __str__(self):
        raise NotImplementedError



class Error(Level):
    def __str__(self):
        return 'ERROR'



class Warning(Level):
    def __str__(self):
        return 'WARNING'



class Scope:
    @property
    def lineNumber(self):
        raise NotImplementedError


    def __str__(self):
        raise NotImplementedError



class Global(Scope):
    @property
    def lineNumber(self):
        return None
    

    def __str__(self):
        return ''



class Local(Scope):
    def __init__(self, lineNumber):
        self._lineNumber = lineNumber


    @property
    def lineNumber(self):
        return self._lineNumber
    

    def __str__(self):
        return 'line '+str(self.lineNumber)