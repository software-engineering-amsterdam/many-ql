from . import ErrorsWarningsResult



class OrderedErrorsWarningsResult(ErrorsWarningsResult.ErrorsWarningsResult):
    @property
    def messages(self):
        return sorted(self.errors + self.warnings)



def factory(cls = OrderedErrorsWarningsResult):
    return ErrorsWarningsResult.factory(cls)
