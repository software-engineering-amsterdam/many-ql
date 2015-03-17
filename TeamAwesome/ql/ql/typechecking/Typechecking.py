from .checkers import \
    CyclicQuestionDependencies,\
    TypesOfExpressions,\
    DuplicateQuestionLabels,\
    QuestionRedefinitions

from typechecking import Result



def check(questionnaire):
    modules = (
        CyclicQuestionDependencies,
        TypesOfExpressions,
        DuplicateQuestionLabels,
        QuestionRedefinitions
    );

    resultAlgebra = Result.ErrorsWarningsResultAlgebra()

    checkers = map(
        lambda module: module.Checker(resultAlgebra),
        modules
    )
    results = map(
        lambda checker: questionnaire.accept(checker),
        checkers
    )

    return resultAlgebra.merge(list(results))
