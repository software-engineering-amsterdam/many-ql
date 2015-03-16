# Why the vague name? We're not sure that in the future we want
# the type checker to be able to return more than simply a list
# of messages. Maybe something the evaluator can use.
# It's the Result Object pattern.

# It's also an object algebra! :)
class ResultAlg:
    def empty(self):
        pass

    def withError(self, result, error):
        pass

    def withWarning(self, result, warning):
        pass

    def merge(self, results):
        pass



# Default implementation.
# Allows you to extract a list of errors and warnings.
class DefaultResultAlg(ResultAlg):
    def empty(self):
        return DefaultResult()

    def withError(self, result, error):
        return DefaultResult(result.errors + [error], result.warnings)

    def withWarning(self, result, warning):
        return DefaultResult(result.errors, result.warnings + [warning])

    def merge(self, results):
        result = self.empty()
        for r in results:
            result = DefaultResult(
                result.errors + r.errors,
                result.warnings + r.warnings
            )
        return result

    

class DefaultResult:
    def __init__(self, errors = [], warnings = []):
        self._errors = errors
        self._warnings = warnings

    @property
    def errors(self):
        return self._errors

    @property
    def warnings(self):
        return self._warnings