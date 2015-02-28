class Form:
    def __init__(self, questions):
        self._questions = questions

    @property
    def questions(self):
        return self._questions
