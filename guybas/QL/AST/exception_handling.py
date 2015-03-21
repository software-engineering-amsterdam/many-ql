import sys


class ExceptionHandling:

    def __init__(self):
        self.warnings = []
        self.errors = []

    def add_warnings(self, warnings):
        self.warnings.extend(warnings)

    def add_errors(self, errors):
        self.errors.extend(errors)

    def execute(self):
        if self.errors:
            print("errors:")
            for e in self.errors:
                print(e)
            print("")
        if self.warnings:
            print("warnings:")
            for w in self.warnings:
                print(w)
        if self.errors:
            sys.exit()
