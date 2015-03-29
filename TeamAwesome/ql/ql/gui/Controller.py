class Controller(object):
	def __init__(self, questionModels, view):
		self._questionModels = questionModels
		self._view = view


	def run(self):
		for questionModel in self._questionModels:
			self._view.render(questionModel, lambda value, questionModel = questionModel : self.valueChangedCallback(questionModel, value))
		self.refresh()
		self._view.mainloop()


	def refresh(self):
		for questionModel in self._questionModels:
			self._view.update(questionModel)			


	def valueChangedCallback(self, questionModel, value):
		updateSuccess = questionModel.updateValue(value)
		
		if not updateSuccess:
			self._view.showWarning("Incorrect answer type entered in the question: " + questionModel.text)
		
		self.refresh()