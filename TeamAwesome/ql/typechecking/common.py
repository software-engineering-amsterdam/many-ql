import ASTNodes
import CustomTypes

def nativeQuestionType(questionType):
    return {
        'boolean' : bool,
        'string' : str,
        'integer' : int,
        'money' : CustomTypes.Money
    }[questionType]

def typeOfIdentifier(identifier, node):
    if isinstance(node, ASTNodes.QuestionStatement) and\
        node.identifier == identifier:
        return nativeQuestionType(node.type)

    for n in node.getChildren():
        ident = typeOfIdentifier(identifier, n)
        if ident is not None:
            return ident

    return None
    