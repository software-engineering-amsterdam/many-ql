
class Question:
    def __init__(self, text, type="boolean", label=None, function=None):
         self.text = text
         self.type = type
         self.label = label
         self.function = function

    def __repr__(self, nested=0):
        return "Question(%s: %s)" % (self.type, self.text)
