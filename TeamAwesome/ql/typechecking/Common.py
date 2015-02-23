from ..ast import Nodes
from ..TypeRules import nativeQuestionType

def questionIdentifiedBy(identifier, node):
    if isinstance(node, Nodes.QuestionStatement) and \
        node.identifier == identifier:
        return node

    for n in node.getChildren():
        question = questionIdentifiedBy(identifier, n)
        if question is not None:
            return question

    return None

def typeOfIdentifier(identifier, node):
    question = questionIdentifiedBy(identifier, node)
    if question is None:
        return None
    return nativeQuestionType(question.type)