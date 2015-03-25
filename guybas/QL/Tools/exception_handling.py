import QL.Tools.exceptions as exceptions


class ExceptionHandling:

    def __init__(self, errors, warnings):
        self.warnings = warnings
        self.errors = errors

    def execute(self):
        if self.errors:
            message = self.make_error_string()
            raise exceptions.QException(message)
        if self.warnings:
            print("warnings:")
            for w in self.warnings:
                print(w)

    def make_error_string(self):
        message = "\n"
        print(self.errors)
        for e in self.errors:
            message += e + "\n"
        return message
