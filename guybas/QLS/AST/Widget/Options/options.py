# interface
class Options:
    def __init__(self, options):
        self.options = options

    def string_presentation(self, level=0):
        s = "("
        for x in range(0, len(self.options) - 1):
            s += self.options[x] + ", "
        s += self.options[-1] + ")"
        return s




















