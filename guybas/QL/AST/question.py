# AST format of a question, initializing the IStatement
from AST.statement import *


class Question(IStatement):

    # Override
    def __init__(self, qid, qtype, label):
        self.id = qid
        self.label = label
        self.type = qtype
        self.answer = []
        self.parent_id = None

    # Override
    def pretty_print(self, level=0):
        s = "\n" + "   " * level + "Question:" + self.id + "\n"
        s += "   " * (level + 1) + self.label + "\n"
        s += "   " * (level + 1) + str(self.type)
        s += "\n"
        return s

    # Override
    def id_collection(self):
        return [self.id]

    # Override
    def label_collection(self):
        return [self.label]

    # Override
    def is_conditional(self):
        return False

    # Override
    def dependency_collection(self, dependencies):
        if self.id not in dependencies:
            dependencies[self.id] = []
        return dependencies

    # Getters
    def get_label(self):
        return self.label

    def get_type(self):
        return self.type

    def get_id(self):
        return self.id

    def get_answer(self):
        return self.answer

    def get_parent_id(self):
        return self.parent_id

    def set_parent_id(self, pid):
        self.parent_id = pid

