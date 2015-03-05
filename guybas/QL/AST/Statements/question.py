# AST format of a question, initializing the IStatement
import QL.AST.Statements.statement as statement
import QL.Main.gui as g
import QL.Grammar.constants as constants

class Question(statement.IStatement):

    # Override
    def __init__(self, qid, qtype, label):
        self.id = qid
        self.label = label
        self.type = qtype
        self.answer = []
        self.parent_id = None
        self.order = None
        self.element = None
        self.parentCondition = None
        # self.set_element()

    # Override
    def pretty_print(self, level=0):
        s = "\n" + "   " * level + "Question\n"
        s += "   " * (level + 1) + "Question id: " + self.id + "\n"
        s += "   " * (level + 1) + "Order number: "+ str(self.order) + "\n"
        s += "   " * (level + 1) + "Question itself: " + self.label + "\n"
        s += "   " * (level + 1) + "Question type: " + str(self.type)
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

    # Override
    def return_expressions(self):
        return []

    # Override
    def get_parent_id(self):
        return self.parent_id

    # Override
    def set_parent_id(self, pid):
        self.parent_id = pid

    # Override
    def set_order(self, order_num):
        if not self.order:
            self.order = order_num
            return self.order + 1
        else:
            print("Warning: order set more than once")
        return self.order + 1

    def set_element(self, gui):
        if self.get_type() is constants.GrammarConstants.BOOL:
            self.element = g.QuestionnaireGUI.e_radio(self, gui)
        elif self.get_type() is constants.GrammarConstants.NUMBER:
            self.element = g.QuestionnaireGUI.e_spin(self, gui)
        elif self.get_type() is constants.GrammarConstants.TEXT:
            self.element = g.QuestionnaireGUI.e_entry(self, gui)
        else:
            raise g.QException("Element type does not exists")

    def set_parent_condition(self, condition):
        self.parentCondition = condition

    # Override
    def id_type_collection(self):
        return {self.id: self.type}

    # Override
    def get_order(self):
        return self.order

    # Getters of the question statement
    def get_label(self):
        return self.label

    def get_type(self):
        return self.type

    def get_id(self):
        return self.id

    def get_answer(self):
        return self.answer

    def get_element(self):
        return self.element    
        
    def get_statement_dict(self):
        return {self.id: self}

    def get_parent_condition(self):
        return self.parentCondition




