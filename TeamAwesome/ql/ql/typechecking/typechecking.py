from . import \
    CyclicQuestionDependencies,\
    TypesOfExpressions,\
    DuplicateQuestionLabels,\
    QuestionRedefinitions

from typechecking import Result

def check(ast):
    modules = [
        CyclicQuestionDependencies,
        TypesOfExpressions,
        DuplicateQuestionLabels,
        QuestionRedefinitions
    ];

    resultAlg = Result.DefaultResultAlg()

    checkers = map(lambda m: m.Checker(ast, resultAlg), modules)
    results = map(lambda c: c.visit(ast.root), checkers)
    return resultAlg.merge(list(results))
