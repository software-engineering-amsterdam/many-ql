from .Observable import Observable


class ObservableQuestionProperty(Observable):
    def __init__(self, question, value = None):
        super().__init__(value)
        self._question = question

    @property
    def question(self):
        return self._question


class Question:
    def __init__(
        self,
        identifier,
        text,
        visible = True,
        answer = None
    ):
        self._identifier = identifier
        self._text = text
        self._visible = ObservableQuestionProperty(self, visible)
        self._answer = ObservableQuestionProperty(self, answer)

    @property
    def identifier(self):
        return self._identifier

    @property
    def text(self):
        return self._text

    @property:
    def answer(self):
        return self._answer.value

    @answer.setter:
    def answer(self, newAnswer):
        self._answer.value = newAnswer

    def observeAnswerWith(self, callback):
        self._answer.addObserver(callback)

    @property
    def visible(self):
        return self._visible.value

    @visible.setter:
    def visible(self, newVisibility):
        self._visible.value = newVisibility

    def observeVisibilityWith(self, callback):
        self._visible.addObserver(callback)

    def removeObservers(self):
        self._answer.removeObservers()
        self._visible.removeObservers()


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
