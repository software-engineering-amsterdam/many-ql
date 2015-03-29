
import Tkinter as tk

import Widgets

class FormBuilder():
    def __init__(self, Frame, AST=None):
        self.Frame = Frame

        self.formList = []
        if AST:
          self.formList = AST.children


    def nextQuestion(self):
      if not self.formList:
          return None

      node = self.formList.pop(0)

      if node.NodeType == "Question":
        # Type should be checked and safe to use
        widgetName = node.type.capitalize()
        return getattr(Widgets, widgetName)(self.Frame, node)


      if node.NodeType == "Branch":
        # Evaluate expression -> place questions on
        print node

      return None


class BooleanWidget():
    pass

