from . import \
    statementNesting,\
    cyclicQuestionDependencies,\
    typesOfExpressions,\
    duplicateQuestionLabels,\
    questionRedefinitions

from .Result import Result


def check(ast):
    modules = [
        statementNesting,
        cyclicQuestionDependencies,
        typesOfExpressions,
        duplicateQuestionLabels,
        questionRedefinitions
    ];

    checkers = map(lambda m: m.Checker(ast), modules)
    results = map(lambda c: c.visit(ast.root), checkers)
    return Result.merge(list(results))
