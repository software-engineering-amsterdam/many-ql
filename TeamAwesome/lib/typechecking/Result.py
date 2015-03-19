# Why the vague name? We're not sure that in the future we want
# the type checker to be able to return more than simply a list
# of messages. Maybe something the evaluator can use.
# It's the Result Object pattern.

# It's also an object algebra! :)
class ResultAlgebra:
    def empty(self):
        pass

    def withError(self, result, error):
        pass

    def withWarning(self, result, warning):
        pass

    def merge(self, results):
        pass



class ErrorsWarningsResultAlgebra(ResultAlgebra):
    def empty(self):
        return ErrorsWarningsResult()

    def withError(self, result, error):
        return ErrorsWarningsResult(result.errors + [error], result.warnings)

    def withWarning(self, result, warning):
        return ErrorsWarningsResult(result.errors, result.warnings + [warning])

    def merge(self, results):
        result = self.empty()
        for r in results:
            result = ErrorsWarningsResult(
                result.errors + r.errors,
                result.warnings + r.warnings
            )
        return result

    

class ErrorsWarningsResult:
    def __init__(self, errors = [], warnings = []):
        self._errors = errors
        self._warnings = warnings

    @property
    def errors(self):
        return self._errors

    @property
    def warnings(self):
        return self._warnings