import ASTNodes

def check(ast):
    return checkDispatch(TypeCheckResult(), ast.root)

# Dynamic dispatch like thing in python
def checkDispatch(result, node):
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
        if not isinstance(s, ASTNodes.FormStatementNode):
            result = result.addMessage(TypeCheckErrorMessage(
                'expected a form statement',
                lineNumber(s)
            ))
        result = checkDispatch(result, s)
    return result

def checkFormStatementNode(result, node):
    for s in node.statements:
        if not isinstance(s, ASTNodes.IfStatementNode) \
            and not isinstance(s, ASTNodes.QuestionStatementNode):
            result = result.addMessage(TypeCheckErrorMessage(
                'expected an if statement or question statement',
                lineNumber(s)
            ))
        result = checkDispatch(result, s)
    return result

def checkIfStatementNode(result, node):
    for s in node.statements:
        if not isinstance(s, ASTNodes.IfStatementNode) \
            and not isinstance(s, ASTNodes.QuestionStatementNode):
            result = result.addMessage(TypeCheckErrorMessage(
                'expected an if statement or question statement',
                lineNumber(s)
            ))
        result = checkDispatch(result, s)
    return result
    # TODO: typecheck expression

def checkQuestionStatementNode(result, node):
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