def buildApplicationFromAST(ast):
    pass


def bindApplicationToEvaluator(application, evaluator):
    answerChangedCallback = _reEvaluateApplicationCallback(
        evaluator,
        application
    )

    for form in application.forms:
        _bindFormToEvaluator(form, evaluator, answerChangedCallback) 


def bindApplicationToGUI(application, gui):
    pass


def _bindFormToEvaluator(form, evaluator, answerChangedCallback):
    for question in form.questions:
        question.removeObservers()
        question.observeAnswerWith(answerChangedCallback)


def _reEvaluateApplicationCallback(evaluator, application):
    callback = lambda question, oldValue, newValue: \
        evaluator.addValue(question.identifier, newValue)
        _updateApplicationFromEvaluator(evaluator, application)
    return callback


def _updateApplicationFromEvaluator(evaluator, application):
    for form in application.forms:
        _updateFormFromEvaluator(evaluator, form)


def _updateFormFromEvaluator(evaluator, form):
    for question in form.questions:
        _updateQuestionFromEvaluator(evaluator, question)


def _updateQuestionFromEvaluator(evaluator, question):
    question.answer = evaluator.getValue(question.identifier)
    evaluatorQuestion = evaluator.getQuestion(question.identifier) 
    question.visible = evaluatorQuestion is not None
