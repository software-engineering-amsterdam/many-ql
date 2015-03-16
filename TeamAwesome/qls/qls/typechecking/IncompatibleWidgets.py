from typechecking import Message
from . import Checker

from ..ast import Visitor as ASTVisitors
from ql.typechecking.Identifier import nonNativeTypeOfIdentifier


class Checker(Checker.StatementChecker):
    def _visitDefaultStatement(self, node):
        self._errorOnIncompatibleWidget(
            node,
            node.questionType,
            _widgetType(node)
        )
        

    def _visitQuestionStatement(self, node):
        self._errorOnIncompatibleWidget(
            node,
            nonNativeTypeOfIdentifier(
                node.identifier, self._qlAst.root
            ),
            _widgetType(node)
        )


    def _errorOnIncompatibleWidget(
        self, node, questionType, widgetType
    ):
        if widgetType is not None and \
            not _isCompatible(questionType, widgetType):

            self._result = self._resultAlg.withError(
                self._result,
                Message.Error(
                    'widget type `'+widgetType+'` is not compatible '\
                   +'question type `'+questionType+'`',
                   node
                )
            )



def _widgetType(node):
    visitor = WidgetTypeVisitor()
    visitor.visit(node)
    return visitor.widgetType


def _isCompatible(questionType, widgetType):
    return widgetType in {
        'boolean' : ['yesno-radio','checkbox','yesno-dropdown'],
        'string' : ['text'],
        'integer' : ['text', 'slider', 'spinbox'],
        'money' : ['text', 'slider', 'spinbox']
    }[questionType]


class WidgetTypeVisitor(ASTVisitors.FullVisitor):
    def __init__(self):
        self._widgetType = None

    @property
    def widgetType(self):
        return self._widgetType

    def _visitWidget(self, node):
        self._widgetType = node.type