from . import Result



class Factory(Result.Factory):
    def empty(self):
        return ErrorsWarningsResult()


    def withError(self, result, error):
        return ErrorsWarningsResult(
            result.errors + [error], result.warnings
        )


    def withWarning(self, result, warning):
        return ErrorsWarningsResult(
            result.errors, result.warnings + [warning]
        )


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
