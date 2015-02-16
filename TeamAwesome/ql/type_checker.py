import ASTNodes

def check(ast):
    """
    Type checks the AST.

    Returns an instance of TypeCheckResult

    Language features:
    - No nested form statements
    - No else statements

    - Unary and binary arithmetic can only be performed on numeric
      type
    - Logical negation can only be performed on boolean type
    - Less-than and greater-than comparison can only be performed on
      numeric type
    - Equality and inequality comparison can be performed on
      boolean, numeric and string type
    - Logical AND and OR can only be performed on boolean type

    Numeric types: integer, money

    Detailed features implemented:

    *Statements*
    - root can only contain form statements
      (should be caught by parser)
    - form statements can only contain if and question statements
    - if statements can only contain if and question statements
    - assigned default values of question_type statements must match
      the type

    *Expressions*
    - (See Language features)
    """
    result = TypeCheckResult()
    check_Dispatch(result, ast.root)
    return result

def check_Dispatch(result, node):
    c = node.__class__.__name__
    procedure = 'check_' + c
    if procedure not in globals():
        result.addMessage(TypeCheckErrorMessage(
            'cannot check '+c+': procedure '+procedure\
           +' does not exist in type checker'
        ))
    else:
        globals()[procedure](result, node)

def check_RootNode(result, node):
    for s in node.statements:
        if not isinstance(s, ASTNodes.FormStatementNode):
            result.addMessage(TypeCheckErrorMessage(
                'expected a form statement',
                lineNumber(s)
            ))
        check_Dispatch(result, s)

def check_FormStatementNode(result, node):
    for s in node.statements:
        if not isinstance(s, ASTNodes.IfStatementNode) \
            and not isinstance(s, ASTNodes.QuestionStatementNode):
            result.addMessage(TypeCheckErrorMessage(
                'expected an if statement or question statement',
                lineNumber(s)
            ))
        check_Dispatch(result, s)

def check_IfStatementNode(result, node):
    for s in node.statements:
        if not isinstance(s, ASTNodes.IfStatementNode) \
            and not isinstance(s, ASTNodes.QuestionStatementNode):
            result.addMessage(TypeCheckErrorMessage(
                'expected an if statement or question statement',
                lineNumber(s)
            ))
        check_Dispatch(result, s)
    # TODO: typecheck expression

def check_QuestionStatementNode(result, node):
    pass

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
    def __init__(self):
        self.__messages = []

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
        self.__messages.append(message)

    @property
    def success(self):
        return (self.errors) == 0