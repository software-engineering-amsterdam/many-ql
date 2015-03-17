from .checkers import \
    CyclicQuestionDependencies,\
    TypesOfExpressions,\
    DuplicateQuestionLabels,\
    QuestionRedefinitions

from typechecking import Result



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
