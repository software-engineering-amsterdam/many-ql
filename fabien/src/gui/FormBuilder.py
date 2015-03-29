
from copy import copy

import Tkinter as tk
import Widgets

class FormBuilder():
    def __init__(self, Frame, AST=None):
        self.Frame = Frame
        self.AST   = AST

        self._resetFormList()
        self.questionIndex = 0

    def nextQuestion(self):
      node = self._next()
      self._incrementCounter()

      return self._handleNode(node, True)


    def prevQuestion(self):
      self._decrementCounter(2)
      node = self._prev()
      self._incrementCounter()

      return self._handleNode(node, False)


    def _handleNode(self, node=None, forward=True):
      if not node:
          return None

      if node.NodeType == "Question":
          # Type should be checked and safe to use
          widgetName = node.type.capitalize()
          return getattr(Widgets, widgetName)(self.Frame, node)

      if node.NodeType == "Branch" and forward:
          # Evaluate expression -> render either the "if" or "else" block
          self._extendFormList(node.ifChildren)
          return self.nextQuestion()

      if node.NodeType == "Branch" and not forward:
          self._resetFormList()
          return self.prevQuestion()

      return None

    def _extendFormList(self, items):
        self.formList[self.questionIndex : len(items)] = items

    def _resetFormList(self):
        # Use copy, or it extends the original AST
        self.formList = copy(self.AST.children)

    def _incrementCounter(self, num=1):
        self.questionIndex += num

    def _decrementCounter(self, num=1):
        self.questionIndex -= num

    def _next(self):
      if self.formList and self.questionIndex < len(self.formList):
        return self.formList[self.questionIndex]

      return None

    def _prev(self):
        if self.formList and self.questionIndex >= 0:
            return self.formList[self.questionIndex]

        return None
