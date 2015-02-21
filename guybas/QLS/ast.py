# Grammar

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
        return self.sentence + str(self.ev) +"\n"
        
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
            s += str(i)
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
        self.props = []
        for i in range(3, len(tokens)):
            self.props += tokens[i]
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