class Question:
    def __init__(
        self,
        question,
        visible = True,
        answer = None
    ):
        self._question = question
        self._visible = visible
        self._answer = answer
        self._observers = []

    def registerObserver(self, observer):
        self._observers.append(observer)

    @property
    def question(self):
        return self._question

    @property:
    def answer(self):
        return self._answer

    @answer.setter:
    def answer(self, newAnswer):
        oldAnswer = self.answer
        self._answer = newAnswer

        if oldAnswer != newAnswer:
            for observer in self._observers:
                observer.answerChanged(self, oldAnswer, newAnswer)

    @property
    def visible(self):
        return self._visible

    @visible.setter:
    def visible(self, newVisibility):
        oldVisibility = self.visible
        self._visible = newVisibility

        if oldAnswer != newAnswer:
            for observer in self._observers:
                observer.visibilityChanged(
                    self, oldVisibility, newVisibility
                )


class QuestionObserver:
    def answerChanged(question, oldAnswer, newAnswer):
        pass

    def visibilityChanged(question, oldVisibility, newVisibility):
        pass


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