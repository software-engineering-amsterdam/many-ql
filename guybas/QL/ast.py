def make_sentence(tokens):
    return ' '.join(tokens) 


# Questions 
class Question:
    def __init__(self, id, answertype, label):
        self.number = id
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

    def get_id(self):
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
    def __init__(self, name, introduction, questions):
        self.name = name 
        self.questions = questions
        self.introduction = introduction

    def __str__(self):
        s = self.name + "\n"
        for i in self.questions:
            s += str(i)
        return s

    def get_questions(self):
        return self.questions

    def get_name(self):
        return self.name

    def get_introduction(self):
        return self.introduction