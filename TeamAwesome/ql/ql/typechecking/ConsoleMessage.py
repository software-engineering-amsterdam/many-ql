from . import Message



class Factory(Message.Factory):
    def __init__(self, parser):
        self._parser = parser


    def duplicateLabel(self, label, lineNumber):
        return ConsoleMessage(
            Warning(),
            Local(lineNumber),
            'Duplicate question label `%s`' % (label)
        )

    def questionCycle(self, questionCycle, lineNumber):
        text = 'There is a question dependency cycle: %s. \
It means the calculation of the answer requires its own \
result as input. This is not possible. Please double check \
the definitions of the questions.' % (
               ' <- '.join([str(q.identifier) for q in questionCycle])
            )

        return ConsoleMessage(
            Error(),
            Local(lineNumber),
            text
        )

    def questionRedefinition(
        self, question, actualType, expectedType, lineNumber
    ):
        text = 'duplicate definition of question `%s` with different \
type `%s` (expected type `%s`)' % (
                question.identifier,
                self._parser.expressionTypeToken(actualType),
                self._parser.expressionTypeToken(expectedType)
            )

        return ConsoleMessage(
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
        text = 'got an expression of type `%s` which is not \
compatible with any of the following types which are \
allowed here: %s' % (
                actualTypeText, ', '.join(allowedTypesText)
            )

        return ConsoleMessage(
            Error(),
            Local(lineNumber),
            text
        )


    def undeclaredIdentifier(self, identifier, lineNumber):
        return ConsoleMessage(
            Error(),
            Local(lineNumber),
            'undeclared identifier `%s`' % (identifier)
        )


    def invalidOperands(self, operator, operands, lineNumber):
        text = 'invalid operand(s) to operator `%s`: %s' % (
            self._parser.operatorToken(operator),
            ', '.join([str(operand) for operand in operands])
        )

        return ConsoleMessage(
            Error(),
            Local(lineNumber),
            text
        )



class ConsoleMessage:
    def __init__(self, level, scope, text):
        self._level = level
        self._scope = scope
        self._text = text


    def __str__(self):
        prefixParts = filter(
            lambda s: s != '',
            map(str, [self._level, self._scope])
        )

        return '[%s] %s' % (' '.join(prefixParts), self._text)



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
    def __str__(self):
        raise NotImplementedError



class Global(Scope):
    def __str__(self):
        return ''



class Local(Scope):
    def __init__(self, lineNumber):
        self._lineNumber = lineNumber

    def __str__(self):
        return 'line '+str(self._lineNumber)