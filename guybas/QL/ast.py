# Grammar
from pyparsing import *
from exceptions import *
        
def make_sentence(tokens):
    return ' '.join(tokens) 
    
# Questions 
class Question:
    def __init__(self, number, label, answertype):
        self.number = number
        self.label = label
        self.answertype = answertype
    def __str__(self):
        s = "Question:" + str(self.number) + "\n"
        s += self.label + "\n"
        s += str(self.answertype)
        s += "\n"
        return s
        
class Conditional_Questions:
    def __init__(self, condition, questions):
        self.condition = condition
        self.questions = questions
    def add_else(questions):
        self.else_questions = questions
    def __str__(self):
        s = "Condition: Question " + make_sentence(self.condition) + "\n"
        for i in self.questions:
            s += str(i)
        return s
        
class Form:
    def __init__(self, name, questions):
        self.name = name 
        self.questions = questions
    def __str__(self):
        s = self.name + "\n"
        for i in self.questions:
            s += str(i)
        return s