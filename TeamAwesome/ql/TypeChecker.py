import ASTNodes
from enum import Enum

def check(ast):
    return dispatchCheck(TypeCheckResult(), ast.root)

# Dynamic dispatch like thing in python
def dispatchCheck(result, node):
    c = node.__class__.__name__
    procedure = 'check' + c
    if procedure not in globals():
        return result.addMessage(TypeCheckErrorMessage(
            'cannot check '+c+': procedure '+procedure\
           +' does not exist in type checker'
        ))
    else:
        return globals()[procedure](result, node)

def checkRootNode(result, node):
    for s in node.statements:
        result = dispatchCheck(result, s)
        result = allowStatement(
            result,
            [ASTNodes.FormStatementNode],
            s
        )
    return result

def checkFormStatementNode(result, node):
    return formIfCommonCheck(result, node)

def checkIfStatementNode(result, node):
    errorsBefore = len(result.errors)
    result = dispatchCheck(result, node.expr)
    errorsAfter = len(result.errors)

    # No errors while type checking expression.
    # So expression has some type. Now we take it into
    # consideration. Why not do the same for statements?
    # Because statements are potentially huge and we like
    # to inform the user of any errors even if the statement
    # is nested wrongly. Expressions are not really like that.
    if(errorsBefore == errorsAfter):
        result = allowExpression(
            result,
            [ExpressionType.BOOLEAN],
            node.expr
        )

    return formIfCommonCheck(result, node)

def checkQuestionStatementNode(result, node):
    return result

def formIfCommonCheck(result, node):
    for s in node.statements:
        result = dispatchCheck(result, s)
        result = allowStatement(
            result,
            [ASTNodes.IfStatementNode,
             ASTNodes.QuestionStatementNode],
            s
        )
    return result

def allowStatement(result, allowed, statement):
    isAllowed = any(map(
        lambda a: isinstance(statement, a),
        allowed
    ))
    if not isAllowed:
        return result.addMessage(TypeCheckErrorMessage(
            'got a statement of type '+statement.__class__.__name__\
           +' but only these statement types are allowed here: '\
           +str(map(lambda a: a.__name__, allowed)),
           lineNumber(statement)
        ))
    else:
        return result

def allowExpression(result, allowed, expr):
    exprType = expressionType(expr)
    if exprType not in allowed:
        return result.addMessage(TypeCheckErrorMessage(
            'got an expression of type '+exprType\
           +' but only these expression types are allowed here: '\
           +str(allowed)
        ))
    else:
        return result

def lineNumber(entity):
    if hasattr(entity, 'lineNumber'):
        return entity.lineNumber
    else:
        return None


class TypeCheckMessage:
    def __init__(self, message, line = None):
        self.__message = message
        self.__line = line

    @property
    def message(self):
        return self.__message

    @property
    def line(self):
        return self.__line

    def __str__(self):
        if self.line is None:
            return self.message
        else:
            return 'line '+str(self.line)+': '+self.message


class TypeCheckErrorMessage(TypeCheckMessage):
    def __str__(self):
        return '[ERROR] '+super().__str__()


class TypeCheckResult:
    def __init__(self, messages = []):
        self.__messages = messages

    @property
    def messages(self):
        return self.__messages

    @property
    def errors(self):
        return filter(
            lambda m: isinstance(m, TypeCheckErrorMessage),
            self.messages
        )

    def addMessage(self, message):
        return TypeCheckResult(self.__messages + [message])

    @property
    def success(self):
        return (self.errors) == 0


class ExpressionType(Enum):
    BOOLEAN = 1
    INTEGER = 2
    MONEY = 3
    STRING = 4