from .Observable import Observable


class ObservableQuestionProperty(Observable):
    def __init__(self, question, value = None):
        super().__init__(value)
        self._question = question

    @property
    def question(self):
        return self._question


class Question:
    def __init__(self, question, visible = True, answer = None):
        self._question = question
        self._visible = ObservableQuestionProperty(self, visible)
        self._answer = ObservableQuestionProperty(self, answer)

    @property
    def question(self):
        return self._question

    @property:
    def answer(self):
        return self._answer.value

    @answer.setter:
    def answer(self, newAnswer):
        self._answer.value = newAnswer

    def observeAnswerWith(self, callback):
        self._answer.registerObserver(callback)

    @property
    def visible(self):
        return self._visible.value

    @visible.setter:
    def visible(self, newVisibility):
        self._visible.value = newVisibility

    def observeVisibilityWith(self, callback):
        self._visible.registerObserver(callback)


class ComputedQuestion(Question):
    pass

class ComputedBooleanQuestion(ComputedQuestion):
    pass

class ComputedIntegerQuestion(ComputedQuestion):
    pass

class ComputedMoneyQuestion(ComputedQuestion):
    pass

class ComputedStringQuestion(ComputedQuestion):
    pass


class InputQuestion(Question):
    pass

class InputBooleanQuestion(InputQuestion):
    pass

class InputIntegerQuestion(InputQuestion):
    pass

class InputMoneyQuestion(InputQuestion):
    pass

class InputStringQuestion(InputQuestion):
    pass


class Form:
    def __init__(self, questions):
        self._questions = questions

    @property
    def questions(self):
        return self._questions


class FormVisitor(GenericVisitor):
    def _visitForm(self, form):
        for q in self.questions:
            self.visit(q)

    def _visitComputedBooleanQuestion(self, question):
        pass

    def _visitComputedIntegerQuestion(self, question):
        pass

    def _visitComputedMoneyQuestion(self, question):
        pass

    def _visitComputedStringQuestion(self, question):
        pass

    def _visitInputBooleanQuestion(self, question):
        pass

    def _visitInputIntegerQuestion(self, question):
        pass

    def _visitInputMoneyQuestion(self, question):
        pass

    def _visitInputStringQuestion(self, question):
        pass