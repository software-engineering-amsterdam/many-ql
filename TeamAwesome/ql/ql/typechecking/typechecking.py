from . import \
    CyclicQuestionDependencies,\
    TypesOfExpressions,\
    DuplicateQuestionLabels,\
    QuestionRedefinitions

from . import Result

def check(ast, resultAlg = Result.DefaultResult()):
    modules = [
        CyclicQuestionDependencies,
        TypesOfExpressions,
        DuplicateQuestionLabels,
        QuestionRedefinitions
    ];

    checkers = map(lambda m: m.Checker(ast, resultAlg), modules)
    results = map(lambda c: c.visit(ast.root), checkers)
    return resultAlg.merge(list(results))
