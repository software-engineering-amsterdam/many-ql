from .Visitor import Visitor
from . import Message

import ASTNodes

def check(ast):
    return StatementNestingVisitor(ast).visit(ast.root)

class StatementNestingVisitor(Visitor):
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
                Message.Error(
                    'got a statement of type '\
                   +node.__class__.__name__\
                   +' but only these statement types are allowed '\
                   +'here: '+str([a.__name__ for a in allowedTypes]),
                   node
               )
            )
