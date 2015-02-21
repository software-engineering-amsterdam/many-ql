import ASTNodes
import CustomTypes

def nativeQuestionType(questionType):
    return {
        'boolean' : bool,
        'string' : str,
        'integer' : int,
        'money' : CustomTypes.Money
    }[questionType]

def questionIdentifiedBy(identifier, node):
    if isinstance(node, ASTNodes.QuestionStatement) and \
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