# Grammar
from pyparsing import *
from exceptions import *
         
def makeSentence(tokens):
    return ' '.join(tokens) 
        
# Questions 
class Question:
    def __init__(self, tokens):
        self.number = int(tokens[0])
        self.question = tokens[1]
        self.answer = tokens[2]
    def __str__(self):
        s = "Question:" + str(self.number) + "\n"
        s += self.question + "\n"
        s += str(self.answer)
        s += "\n"
        return s
        
class Conditional_Questions:
    def __init__(self, tokens):
        self.condition = tokens[0]
        self.questions = []
        for i in range(1, len(tokens)):
            self.questions.append(tokens[i])
    def __str__(self):
        s = "Condition: Question " + makeSentence(self.condition) + "\n"
        for i in self.questions:
            s += str(i)
        return s
        
class Form:
    def __init__(self, tokens):
        self.name = tokens[0]
        self.questions = []
        for i in range(1,len(tokens)):
            self.questions.append(tokens[i])
    def __str__(self):
        s = self.name + "\n"
        for i in self.questions:
            s += str(i)
        return s