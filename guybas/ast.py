# Grammar
from pyparsing import *
from exceptions import *
         
def makeSentence(tokens):
    return ' '.join(tokens) 
       
# Answer types
class Option: 
    def __init__(self, tokens):
        if tokens[0] == "Default":
            if tokens[1] == "True":
                self.ev = True 
            else: 
                self.ev = False
            self.sentence = tokens[2]
        # Default is False
        else:   
            self.ev = False
            self.sentence = tokens[0]
    def __str__(self):
        return self.sentence + str(self.ev)
        
class Checkbox:
    def __init__(self, tokens):
        self.options = []
        for i in tokens:
            x = Option(i)
            self.options.append(x)
    def __str__(self):
        s = "Checkbox\n"
        for i in self.options:
            s += str(i) + "\n"
        return s
         
class Radiobox(Checkbox):
    def __str__(self):
        s = "Radiobox\n"
        for i in self.options:
            s += str(i) + "\n"
        return s
    def checkValid(self):
        count = 0
        for i in self.options:
            if i.ev == True:
                count += 1
        if count > 1:
            raise qException("There are too many true values!")
            
class Scale:
    def __init__(self, tokens):
        self.min = int(tokens[0])
        self.max = int(tokens[1])
        
# Questions 
class Question:
    def __init__(self, tokens):
        self.number = int(tokens[0])
        self.question = tokens[1]
        self.answer = tokens[2]
        if len(tokens) > 2:
            print(tokens[3][0])
            if tokens[3][0] == "Hint:":  
                self.hint = tokens[3][1]   
            else:
                self.hint = ""
        else:
            self.hint = ""
    def __str__(self):
        s = "Question:" + str(self.number) + "\n"
        s += self.question + "\n"
        s += str(self.answer)
        s += self.hint
        return s