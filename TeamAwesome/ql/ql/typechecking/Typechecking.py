from .checkers import \
    CyclicQuestionDependencies,\
    TypesOfExpressions,\
    DuplicateQuestionLabels,\
    QuestionRedefinitions

from typechecking import Result



# The type checker depends on the parser because it uses the parser
# to generate error messages using tokens from the QL language for
# example for operators. So instead of spitting out a message with
# 'QLAddition' the type checker can say '+' (in case of the ANTLR parser)
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
