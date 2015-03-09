# AST format of a question, initializing the IStatement
import QL.AST.Statements.statement as statement
import QL.Grammar.constants as constants
# import QL.GUI.Elements.text_entry as e_text_entry
import QL.Exceptions.exceptions as exceptions
from QL.GUI.Elements import *


class Question(statement.IStatement):

    # Override
    def __init__(self, qid, qtype, label):
        self._id = qid
        self._label = label
        self._type = qtype
        self._parent_id = None
        self._order = None
        self.element = None
        self.parentCondition = None

    # Override
    def pretty_print(self, level=0):
        s = "\n" + "   " * level + "Question\n"
        s += "   " * (level + 1) + "Question _id: " + self._id + "\n"
        s += "   " * (level + 1) + "Order number: "+ str(self._order) + "\n"
        s += "   " * (level + 1) + "Question itself: " + self._label + "\n"
        s += "   " * (level + 1) + "Question _type: " + str(self._type)
        s += "\n"
        return s

    # Override
    def id_collection(self):
        return [self._id]

    # Override
    def label_collection(self):
        return [self._label]

    # Override
    def is_conditional(self):
        return False

    # Override
    def get_dependency_collection(self, dependencies):
        if self._id not in dependencies:
            dependencies[self._id] = []
        return dependencies

    # Override
    def return_expressions(self):
        return []

    # Override
    def get_parent_id(self):
        return self._parent_id

    # Override
    def set_parent_id(self, pid):
        self._parent_id = pid

    # Override
    def set_order(self, order_num):
        if not self._order:
            self._order = order_num
            return self._order + 1
        else:
            print("Warning: _order set more than once")
        return self._order + 1

    # set gui _element
    def set_element(self, gui):
        if self.get_type() is constants.GrammarConstants.BOOL:
            # self.element = g.GUI.e_radio(self, gui)
            e = radio_button.RadioButton(self, gui)
        elif self.get_type() is constants.GrammarConstants.NUMBER:
            # self.element = g.GUI.e_spin(self, gui)
            e = spin_box.SpinBox(self, gui)
        elif self.get_type() is constants.GrammarConstants.TEXT:
            # self.element = g.GUI.e_entry(self, gui)
            e = text_entry.TextEntry(self, gui)
        else:
            raise exceptions.QException("Element _type does not exists")
        self.element = e.get_row()

    def set_parent_condition(self, condition):
        self.parentCondition = condition

    # Override
    def get_id_type_collection(self):
        return {self._id: self._type}

    # Override
    def get_order(self):
        return self._order

    # Getters of the question statement
    def get_label(self):
        return self._label

    def get_type(self):
        return self._type

    def get_id(self):
        return self._id

    def get_element(self):
        return self.element
        
    def get_statement_dict(self):
        return {self._id: self}

    def get_parent_condition(self):
        return self.parentCondition




