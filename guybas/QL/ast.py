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

    def get_label(self):
        return self.label

    def get_answertype(self):
        return self.answertype

    def get_number(self):
        return self.number

class ConditionalQuestions:
    def __init__(self, condition, questions):
        self.condition = condition
        self.questions = questions
        self.else_questions = []

    def add_else(self, questions):
        self.else_questions = questions

    def __str__(self):
        s = "Condition: Question " + make_sentence(self.condition) + "\n"
        for i in self.questions:
            s += str(i)
        return s

    def get_conditional_q(self):
        return self.questions


class Form:
    def __init__(self, name, questions):
        self.name = name 
        self.questions = questions

    def __str__(self):
        s = self.name + "\n"
        for i in self.questions:
            s += str(i)
        return s

    def get_questions(self):
        return self.questions