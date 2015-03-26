from .checkers import \
    CyclicQuestionDependencies,\
    TypesOfExpressions,\
    DuplicateQuestionLabels,\
    QuestionRedefinitions

from . import Result



# The type checker depends on the parser because it uses the parser
# to generate error messages using the syntax of the QL language for
# example for question types. So instead of spitting out a message saying
# 'QLBoolean' the type checker can say 'boolean' (in case of the ANTLR
# parser). This way users don't become confused about the error messages.
def check(parser):
    modules = (
        CyclicQuestionDependencies,
        TypesOfExpressions,
        DuplicateQuestionLabels,
        QuestionRedefinitions
    );

    resultAlgebra = Result.ErrorsWarningsResultAlgebra()

    checkers = map(
        lambda module: module.Checker(parser, resultAlgebra),
        modules
    )
    results = map(
        lambda checker: parser.questionnaire.accept(checker),
        checkers
    )

    return resultAlgebra.merge(list(results))
