class ExceptionHandling:

    def __init__(self):
        self.warnings = []
        self.errors = []

    def add_warnings(self, warnings):
        self.warnings.extend(warnings)

    def add_errors(self, errors):
        self.errors.extend(errors)

    def exceptions(self):
        return self.errors, self.warnings