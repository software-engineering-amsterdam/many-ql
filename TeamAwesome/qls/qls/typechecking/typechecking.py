from . import \
    UndefinedQuestions

from typechecking import Result

def check(qlAst, qlsAst, resultAlg = Result.DefaultResult()):
    modules = [
        UndefinedQuestions
    ];

    checkers = map(
        lambda m: m.Checker(qlAst, qlsAst, resultAlg),
        modules
    )
    results = map(lambda c: c.visit(qlsAst.qls), checkers)
    return resultAlg.merge(list(results))
