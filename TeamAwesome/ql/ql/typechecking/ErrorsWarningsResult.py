from . import Result



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



# Python does not have generics, but we want to create one factory for
# a family of classes. i.e. we want to have one factory for
# ErrorsWarningsResult objects but also for objects of subclasses of
# ErrorsWarningsResult that are constructed in the same way (i.e. 
# OrderedErrorsWarningsResult). This increases the complexity of the
# code a little bit but it eliminates some duplication. Now
# OrderedErrorsWarningsResult can reuse the factory instead of duplicating
# its code. That duplication could become problematic when there needs
# be a change in the way ErrorsWarningsResult objects (and objects of
# its subclasses) are constructed for whatever reason.
#
# Therefore the factory itself is parameterized over the concrete
# class of the objects that we want to create.
def factory(cls = ErrorsWarningsResult):
    class Factory(Result.Factory):
        def empty(self):
            return cls()


        def withError(self, result, error):
            return cls(
                result.errors + [error], result.warnings
            )


        def withWarning(self, result, warning):
            return cls(
                result.errors, result.warnings + [warning]
            )


        def merge(self, results):
            result = self.empty()
            for r in results:
                result = cls(
                    result.errors + r.errors,
                    result.warnings + r.warnings
                )
            return result

    return Factory()