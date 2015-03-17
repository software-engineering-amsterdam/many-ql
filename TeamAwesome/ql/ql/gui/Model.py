import decimal

class QuestionModel(object):
    def __init__(self, identifier, evaluator):
        self._identifier = identifier
        self._evaluator = evaluator

    def _getEvaluatorQuestion(self):
        return self._evaluator.getQuestion(self._identifier)

    @property
    def text(self):
        evaluatorQuestion = self._getEvaluatorQuestion()
        if evaluatorQuestion:
            return evaluatorQuestion.text

    @property
    def type(self):
        return self._evaluator.getQuestionType(self._identifier)

    @property
    def isConstant(self):
        evaluatorQuestion = self._getEvaluatorQuestion()
        return evaluatorQuestion and evaluatorQuestion.constant    

    @property
    def isVisible(self):
        return self._getEvaluatorQuestion() != None

    @property
    def value(self):
        qlVal = self._evaluator.getValue(self._identifier)
        if qlVal != None:
            return qlVal.value
        return None

    def updateValue(self, value):
        try:
            value = self.type(value)
        except (ValueError, decimal.InvalidOperation): 
            return False

        self._evaluator.addValue(self._identifier, value)
        return True