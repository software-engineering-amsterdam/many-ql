
class DuplicationError:
    def __init__(self, Question=None, DuplicateQuestion=None, message=None):
        self.question  = Question
        self.duplicate = DuplicateQuestion
        self.lineno    = DuplicateQuestion.lineNr
        self.message   = message

    def __str__(self):
        return "Duplicate ID `%s` with different types (%s and %s) at line %s" % \
            (self.question.ID, self.question.type, self.duplicate.type, self.lineno)
