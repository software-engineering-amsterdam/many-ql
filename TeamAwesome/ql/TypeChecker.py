import ASTNodes
import OperatorTypes
import CustomTypes

def check(ast):
    return TypeChecker().check(ast) 

# The actual typechecking happens in a class method
# because we want some internal state so we don't have to
# change argument signatures in our methods every time
# we add something to the type checker.
class TypeChecker:
    def check(self, ast):
        self._ast = ast
        self._operatorTable = OperatorTypes.Table()
        self._result = TypeCheckResult()
        self._dispatchCheck(ast.root)
        return self._result

    def _dispatchCheck(self, node):
        method = getattr(self, '_check' + node.__class__.__name__)
        if method is None:
            raise AssertionError('method %s not found' % (method))
        method(node)

    def _checkRoot(self, node):
        for s in node.statements:
            self._dispatchCheck(s)
            self._allowStatement(
                [ASTNodes.FormStatement],
                s
            )

    def _checkFormStatement(self, node):
        self._formIfCommonCheck(node)

    def _checkIfStatement(self, node):
        errorsBefore = len(self._result.errors)
        self._dispatchCheck(node.expr)
        errorsAfter = len(self._result.errors)

        # No errors while type checking expression.
        # So expression has some type. Now we take it into
        # consideration. Why not do the same for statements?
        # Because statements are potentially huge and we like
        # to inform the user of any errors even if the statement
        # is nested wrongly. Expressions are not really like that.
        if errorsBefore == errorsAfter:
            self._allowExpression(
                [bool],
                node.expr
            )

        self._formIfCommonCheck(node)

    def _checkQuestionStatement(self, node):
        if node.expr is not None:
            errorsBefore = len(self._result.errors)
            self._dispatchCheck(node.expr)
            errorsAfter = len(self._result.errors)

            if errorsBefore != errorsAfter:
                return

            self._allowExpression([node.type], node.expr) 

    def _formIfCommonCheck(self, node):
        for s in node.statements:
            self._dispatchCheck(s)
            self._allowStatement(
                [ASTNodes.IfStatement,
                 ASTNodes.QuestionStatement],
                s
            )

    def _allowStatement(self, allowed, statement):
        isAllowed = any(map(
            lambda a: isinstance(statement, a),
            allowed
        ))
        if not isAllowed:
            self._result = self._result.addMessage(
                TypeCheckErrorMessage(
                    'got a statement of type '\
                   +statement.__class__.__name__\
                   +' but only these statement types are allowed '\
                   +'here: '+str([a.__name__ for a in allowed]),
                   TypeChecker._lineNumber(statement)
               )
            )

    def _checkAtomicExpression(self, node):
        if isinstance(node.left, CustomTypes.Identifier) and\
            not self._identifierDefined(node.left, self._ast.root):

            self._result = self._result.addMessage(
                TypeCheckErrorMessage(
                    'undefined identifier '+node.left,
                    TypeChecker._lineNumber(node)
                )
            ) 

    def _identifierDefined(self, identifier, node):
        if isinstance(node, ASTNodes.QuestionStatement):
            return identifier == node.identifier
        for c in node.getChildren():
            if self._identifierDefined(identifier, c):
                return True
        return False

    def _checkUnaryExpression(self, node):
        errorsBefore = len(self._result.errors)
        self._dispatchCheck(node.right)
        errorsAfter = len(self._result.errors)

        if errorsBefore != errorsAfter:
            return 

        if self._typeOf(node) is None:
            self._result = self._result.addMessage(TypeCheckErrorMessage(
                'invalid operands to unary operator `'+node.op\
               +'`: '+str(node.right),
                TypeChecker._lineNumber(node)
            ))

    def _checkBinaryExpression(self, node):
        errorsBefore = len(self._result.errors)
        self._dispatchCheck(node.left)
        self._dispatchCheck(node.right)
        errorsAfter = len(self._result.errors)

        if errorsBefore != errorsAfter:
            return 

        if self._typeOf(node) is None:
            self._result = self._result.addMessage(TypeCheckErrorMessage(
                'invalid operands to binary operator `'+node.op\
               +'`: ('+str(node.left)+','+str(node.right)+')',
                TypeChecker._lineNumber(node)
            ))

    def _allowExpression(self, allowed, expr):
        exprType = self._typeOf(expr)
        if exprType not in allowed:
            self._result = self._result.addMessage(
                TypeCheckErrorMessage(
                    'got an expression of type `'+str(exprType)\
                   +'` but only these expression types are allowed '\
                   +'here: '+str(allowed),
                    TypeChecker._lineNumber(expr)
                )
            )

    def _typeOf(self, expr):
        return self._dispatchTypeOf(expr)

    def _dispatchTypeOf(self, expr):
        method = getattr(self, '_typeOf' + expr.__class__.__name__)
        if method is None:
            raise AssertionError('method %s not found' % (method))
        return method(expr)

    def _typeOfAtomicExpression(self, expr):
        if isinstance(expr.left, CustomTypes.Identifier):
            # At this point we know the identifier is defined.
            # We just need the type.
            return self._typeOfIdentifier(expr.left, self._ast.root)
        else:
            return type(expr.left)

    def _typeOfIdentifier(self, identifier, node):
        if isinstance(node, ASTNodes.QuestionStatement) and\
            node.identifier == identifier:
            return {
                'boolean' : bool,
                'string' : str,
                'integer' : int,
                'money' : CustomTypes.Money
            }[node.type]

        for c in node.getChildren():
            ident = self._typeOfIdentifier(identifier, c)
            if ident is not None:
                return ident

        return None


    def _typeOfUnaryExpression(self, expr):
        return self._operatorTable.unaryOperationType(
            expr.op,
            self._typeOf(expr.right)
        )

    def _typeOfBinaryExpression(self, expr):
        return self._operatorTable.binaryOperationType(
            expr.op,
            self._typeOf(expr.left),
            self._typeOf(expr.right)
        )

    @staticmethod
    def _lineNumber(entity):
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
        return [
            m for m in self.messages
            if isinstance(m, TypeCheckErrorMessage)
        ]

    def addMessage(self, message):
        return TypeCheckResult(self.__messages + [message])

    @property
    def success(self):
        return (self.errors) == 0


