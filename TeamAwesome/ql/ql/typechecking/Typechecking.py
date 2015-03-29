from .checkers import \
    CyclicQuestionDependencies,\
    TypesOfExpressions,\
    DuplicateQuestionLabels,\
    QuestionRedefinitions



def check(
    questionnaire, resultFactory, messageFactory,
    modules = [
        CyclicQuestionDependencies,
        TypesOfExpressions,
        DuplicateQuestionLabels,
        QuestionRedefinitions
    ]
):
    checkers = map(
        lambda module: module.Checker(resultFactory, messageFactory),
        modules
    )
    results = map(
        lambda checker: questionnaire.accept(checker),
        checkers
    )

    return resultFactory.merge(list(results))
