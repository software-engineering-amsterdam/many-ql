from . import \
    CyclicQuestionDependencies,\
    TypesOfExpressions,\
    DuplicateQuestionLabels,\
    QuestionRedefinitions

from .Result import Result


def check(ast):
    modules = [
        CyclicQuestionDependencies,
        TypesOfExpressions,
        DuplicateQuestionLabels,
        QuestionRedefinitions
    ];

    checkers = map(lambda m: m.Checker(ast), modules)
    results = map(lambda c: c.visit(ast.root), checkers)
    return Result.merge(list(results))
