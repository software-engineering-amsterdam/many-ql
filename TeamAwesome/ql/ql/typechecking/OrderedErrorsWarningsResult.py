from . import ErrorsWarningsResult



# Works only with Messages that have the __lt__ (less than) operator
# implemented.
class OrderedErrorsWarningsResult(ErrorsWarningsResult.ErrorsWarningsResult):
    @property
    def messages(self):
        return sorted(self.errors + self.warnings)



def factory(cls = OrderedErrorsWarningsResult):
    return ErrorsWarningsResult.factory(cls)
