from . import Message
from ..Visitor import Visitor as GenericVisitor


# Why the vague name? We're not sure that in the future we want
# the type checker to be able to return more than simply a list
# of messages. Maybe something the evaluator can use.
# It's the Result Object pattern.

# It's also an algebraic data type :)
class ResultAlg:
    def empty(self):
        pass

    def withError(self, error):
        pass

    def withWarning(self, warning):
        pass

    def merge(self, results):
        pass


# Primary implementation
class Result(ResultAlg):
    def empty(self):
        return Result()

    @property
    def errors(self):
        return self._errors

    @property
    def warnings(self):
        return self._warnings

    def withError(self, error):
        return Result(self.errors + [error], self.warnings)

    def withWarning(self, warning):
        return Result(self.errors, self.warnings + [warning])

    def merge(self, results):
        result = self.empty()
        for r in results:
            result = Result(
                result.errors + r.errors,
                result.warnings + r.warnings
            )
        return result

    def __init__(self, errors = [], warnings = []):
        self._errors = errors
        self._warnings = warnings