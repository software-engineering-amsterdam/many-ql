import ASTNodes
import OperatorTypes
import CustomTypes
from ASTVisitor import ASTVisitor

def check(ast):
    return TypeChecker().check(ast) 

# The actual typechecking happens in a class method
# because we want some internal state so we don't have to
# change argument signatures in our methods every time
# we add something to the type checker.
class TypeChecker:
    def check(self, ast):
        self._ast = ast

        return TypeCheckResult.merge([
            self._checkStatementNesting(),
            self._checkQuestionRedefinitions(),
            self._checkCyclicQuestionDependencies(),
            self._checkTypesOfExpressions(),
            self._checkDuplicateQuestionLabels()
        ])

    def _checkStatementNesting(self):
        visitor = StatementNestingVisitor()
        return visitor.visit(self._ast.root)

    def _checkQuestionRedefinitions(self):
        # TODO
        return TypeCheckResult()

    def _checkCyclicQuestionDependencies(self):
        # TODO
        return TypeCheckResult()

    # Includes checking for undefined identifiers
    def _checkTypesOfExpressions(self):
        visitor = TypesOfExpressionsVisitor(self._ast.root)
        return visitor.visit(self._ast.root)

    def _checkDuplicateQuestionLabels(self):
        visitor = DuplicateQuestionLabelsVisitor()
        return visitor.visit(self._ast.root)


class TypeCheckingVisitor(ASTVisitor):
    def __init__(self):
        # You can add any type check result
        # to this variable here. It is returned
        # by _visitRoot by default. 
        # To save you from typing of some 'return's
        self._result = TypeCheckResult()

    def _visitRoot(self, node):
        super()._visitRoot(node)
        return self._result

class StatementNestingVisitor(TypeCheckingVisitor):
    def _visitRoot(self, node):
        for n in node.getChildren():
            self._allowStatement(
                [ASTNodes.FormStatement],
                n
            )
        return super()._visitRoot(node)

    def _visitFormStatement(self, node):
        for n in node.getChildren():
            self._allowStatement(
                [ASTNodes.IfStatement,
                 ASTNodes.QuestionStatement],
                n
            )
        super()._visitFormStatement(node)

    def _visitIfStatement(self, node):
        for n in node.getChildren():
            self._allowStatement(
                [ASTNodes.IfStatement,
                 ASTNodes.QuestionStatement],
                n
            )
        super()._visitIfStatement(node)

    def _allowStatement(self, allowedTypes, node):
        isAllowed = any(map(
            lambda a: isinstance(node, a),
            allowedTypes
        ))
        if not isAllowed:
            self._result = self._result.withMessage(
                TypeCheckErrorMessage(
                    'got a statement of type '\
                   +node.__class__.__name__\
                   +' but only these statement types are allowed '\
                   +'here: '+str([a.__name__ for a in allowedTypes]),
                   node
               )
            )

class TypesOfExpressionsVisitor(TypeCheckingVisitor):
    def __init__(self, astRoot):
        super().__init__()
        self._astRoot = astRoot
        self._operatorTable = OperatorTypes.Table()

        # The type of the last WELL-TYPED expression.
        # i.e. if the last checked expression was for some reason
        # invalid then this variable remains what it was before
        # that check happened.
        # So don't rely on this after you encounter an error
        # in a sub expression.
        self._lastExprType = None

    def _visitIfStatement(self, node):
        errorsBefore = len(self._result.errors)
        self.visit(node.expr)
        errorsAfter = len(self._result.errors)

        if errorsBefore == errorsAfter:
            self._allowExpression(
                [bool],
                self._lastExprType,
                node.expr
            )

        for n in node.getChildren():
            self.visit(n)

    def _visitQuestionStatement(self, node):
        if node.expr is not None:
            errorsBefore = len(self._result.errors)
            self.visit(node.expr)
            errorsAfter = len(self._result.errors)

            if errorsBefore == errorsAfter:
                self._allowExpression(
                    [self._typeOfIdentifier(node.identifier, node)],
                    self._lastExprType,
                    node.expr
                ) 

        for n in node.getChildren():
            self.visit(n)

    def _visitAtomicExpression(self, node):
        if isinstance(node.left, CustomTypes.Identifier):
            identType = self._typeOfIdentifier(
                node.left,
                self._astRoot
            )
            if identType is None:
                self._result = self._result.withMessage(
                    TypeCheckErrorMessage(
                        'undefined identifier '+node.left,
                        node
                    )
                )
            else:
                self._lastExprType = identType
        else:
            self._lastExprType = type(node.left)

    def _visitUnaryExpression(self, node):
        errorsBefore = len(self._result.errors)
        self.visit(node.right)
        errorsAfter = len(self._result.errors)

        if errorsBefore != errorsAfter:
            return

        opType = \
            self._operatorTable.unaryOperationType(
                node.op,
                self._lastExprType
            )

        if opType is None:
            self._result = self._result.withMessage(
                TypeCheckErrorMessage(
                    'invalid operands to unary operator `'+node.op\
                   +'`: '+str(node.right),
                   node
                )
            )
        else:
            self._lastExprType = opType

    def _visitBinaryExpression(self, node):
        errorsBefore = len(self._result.errors)
        self.visit(node.left)
        errorsAfter = len(self._result.errors)

        if errorsBefore != errorsAfter:
            return

        leftType = self._lastExprType

        errorsBefore = errorsAfter
        self.visit(node.right)
        errorsAfter = len(self._result.errors)

        if errorsBefore != errorsAfter:
            return

        rightType = self._lastExprType

        opType = \
            self._operatorTable.binaryOperationType(
                node.op,
                leftType,
                rightType
            )

        if opType is None: 
            self._result = self._result.withMessage(
                TypeCheckErrorMessage(
                    'invalid operands to binary operator `'+node.op\
                   +'`: ('+str(node.left)+','+str(node.right)+')',
                    node
                )
            )
        else:
            self._lastExprType = opType


    def _allowExpression(self, allowedTypes, exprType, node):
        if exprType not in allowedTypes:
            self._result = self._result.withMessage(
                TypeCheckErrorMessage(
                    'got an expression of type `'+str(exprType)\
                   +'` but only these expression types are allowed '\
                   +'here: '+str(allowedTypes),
                   node
                )
            )

    def _typeOfIdentifier(self, identifier, node):
        if isinstance(node, ASTNodes.QuestionStatement) and\
            node.identifier == identifier:
            return {
                'boolean' : bool,
                'string' : str,
                'integer' : int,
                'money' : CustomTypes.Money
            }[node.type]

        for n in node.getChildren():
            ident = self._typeOfIdentifier(identifier, n)
            if ident is not None:
                return ident

        return None

class DuplicateQuestionLabelsVisitor(TypeCheckingVisitor):
    def __init__(self):
        super().__init__()
        self._labels = {}

    def _visitRoot(self, node):
        super()._visitRoot(node)

        for text, lines in self._labels.items():
            if len(lines) > 1:
                self._result = self._result.withMessage(
                    TypeCheckWarningMessage(
                        'duplicate question label `'+text\
                       +'` on lines: '+str(lines)
                    )
                )

        return self._result


    def _visitQuestionStatement(self, node):
        if node.text not in self._labels:
            self._labels[node.text] = []
        self._labels[node.text].append(node.lineNumber)

class TypeCheckMessage:
    def __init__(self, message, node = None):
        self.__message = message
        self._node = node

    @property
    def message(self):
        return self.__message

    @property
    def line(self):
        if getattr(self._node, 'lineNumber', None) is not None:
            return self._node.lineNumber
        else:
            return None

    def __str__(self):
        if self.line is None:
            return self.message
        else:
            return 'line '+str(self.line)+': '+self.message

class TypeCheckWarningMessage(TypeCheckMessage):
    def __str__(self):
        return '[WARNING] '+super().__str__()

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

    def withMessage(self, message):
        return TypeCheckResult(self.__messages + [message])

    @staticmethod
    def merge(typeCheckResults):
        result = TypeCheckResult()
        for r in typeCheckResults:
            result = TypeCheckResult(result.messages + r.messages)
        return result

    @property
    def success(self):
        return (self.errors) == 0