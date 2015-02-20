from . import \
    statementNesting,\
    cyclicQuestionDependencies,\
    typesOfExpressions,\
    duplicateQuestionLabels,\
    questionRedefinitions

from .Result import Result

def check(ast):
    checkers = [
        statementNesting,
        cyclicQuestionDependencies,
        typesOfExpressions,
        duplicateQuestionLabels,
        questionRedefinitions
    ];

    results = map(lambda c: c.check(ast), checkers)

    return Result.merge(list(results))
