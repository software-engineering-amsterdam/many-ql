import operator
from .QLTypes import *

class OperatorTable:
    def __init__(self):
        self._rules = self._createRules()

    def unaryOperationType(self, op, typeRight):
        rule = self._rules.get((op, typeRight), None)
        if rule:
            return rule[0]

    def binaryOperationType(self, op, typeLeft, typeRight):
        rule = self._rules.get((op, typeLeft, typeRight), None)
        if rule:
            return rule[0]

    def getUnaryOperator(self, op, valueType):
        rule = self._rules.get((op, valueType), None)
        if rule:
            return rule[1]

    def getBinaryOperator(self, op, leftType, rightType):
        rule = self._rules.get((op, leftType, rightType), None)
        if rule:
            return rule[1]

    def _createRules(self):
        return {
            ('-', QLInteger)    :   (QLInteger, lambda v : QLInteger(-v.value)),
            ('-', QLMoney)      :   (QLMoney,   lambda v : QLMoney(-v.value)),
            ('+', QLInteger)    :   (QLInteger, lambda v : QLInteger(+v.value)),
            ('+', QLMoney)      :   (QLMoney,   lambda v : QLMoney(+v.value)),
        
            ('!', QLBoolean)    :   (QLBoolean, lambda v : QLBoolean(not v.value)),

            ('^', QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value**r.value)),
            ('^', QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value**r.value)),
            ('^', QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value**r.value)),
            ('^', QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value**r.value)),

            ('*', QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value * r.value)),
            ('*', QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value * r.value)),
            ('*', QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value * r.value)),
            ('*', QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value * r.value)),

            ('/', QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value / r.value)),
            ('/', QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value / r.value)),
            ('/', QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value / r.value)),
            ('/', QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value / r.value)),
            
            ('/', QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value / r.value)),
            ('/', QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value / r.value)),
            ('/', QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value / r.value)),
            ('/', QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value / r.value)),
            
            ('%', QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value % r.value)),
            ('%', QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value % r.value)),
            ('%', QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value % r.value)),
            ('%', QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value % r.value)),
        
            ('-', QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value - r.value)),
            ('-', QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value - r.value)),
            ('-', QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value - r.value)),
            ('-', QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value - r.value)),
            
            ('+', QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value + r.value)),
            ('+', QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value + r.value)),
            ('+', QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value + r.value)),
            ('+', QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value + r.value)),
            ('+', QLString, QLInteger)      :   (QLString,  lambda l, r : QLString(l.value + str(r.value))),
            ('+', QLInteger, QLString)      :   (QLString,  lambda l, r : QLString(str(l.value) + r.value)),
            ('+', QLString, QLString)       :   (QLString,  lambda l, r : QLString(l.value + r.value)),
            ('+', QLString, QLString)       :   (QLString,  lambda l, r : QLString(l.value + r.value)),
            ('+', QLString, QLMoney)        :   (QLString,  lambda l, r : QLString(l.value + str(r.value))),
            ('+', QLMoney, QLString)        :   (QLString,  lambda l, r : QLString(str(l.value) + r.value)),
            ('+', QLString, QLBoolean)      :   (QLString,  lambda l, r : QLString(l.value + str(r.value))),
            ('+', QLBoolean, QLString)      :   (QLString,  lambda l, r : QLString(str(l.value) + r.value)),

            ('*', QLString, QLInteger)      :   (QLString,  lambda l, r : QLString(l.value * r.value)),
            ('*', QLInteger, QLString)      :   (QLString,  lambda l, r : QLString(l.value * r.value)),
            
            ('<', QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
            ('<', QLInteger, QLMoney)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
            ('<', QLMoney, QLInteger)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
            ('<', QLMoney, QLMoney)         :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
            ('<', QLString, QLString)       :   (QLBoolean,  lambda l, r : QLBoolean(len(l.value) < len(r.value))),

            ('<=', QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value <= r.value)),
            ('<=', QLInteger, QLMoney)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value <= r.value)),
            ('<=', QLMoney, QLInteger)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value <= r.value)),
            ('<=', QLMoney, QLMoney)         :   (QLBoolean,  lambda l, r : QLBoolean(l.value <= r.value)),
            ('<=', QLString, QLString)       :   (QLBoolean,  lambda l, r : QLBoolean(len(l.value) <= len(r.value))),
  
            ('>', QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value > r.value)),
            ('>', QLInteger, QLMoney)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value > r.value)),
            ('>', QLMoney, QLInteger)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value > r.value)),
            ('>', QLMoney, QLMoney)         :   (QLBoolean,  lambda l, r : QLBoolean(l.value > r.value)),
            ('>', QLString, QLString)       :   (QLBoolean,  lambda l, r : QLBoolean(len(l.value) > len(r.value))),
 
            ('>=', QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value >= r.value)),
            ('>=', QLInteger, QLMoney)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value >= r.value)),
            ('>=', QLMoney, QLInteger)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value >= r.value)),
            ('>=', QLMoney, QLMoney)         :   (QLBoolean,  lambda l, r : QLBoolean(l.value >= r.value)),
            ('>=', QLString, QLString)       :   (QLBoolean,  lambda l, r : QLBoolean(len(l.value) >= len(r.value))),
        
            ('==', QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value == r.value)),
            ('==', QLInteger, QLMoney)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value == r.value)),
            ('==', QLMoney, QLInteger)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value == r.value)),
            ('==', QLMoney, QLMoney)         :   (QLBoolean,  lambda l, r : QLBoolean(l.value == r.value)),
            ('==', QLString, QLString)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value == r.value)),
            ('==', QLBoolean, QLBoolean)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value == r.value)),

            ('!=', QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value != r.value)),
            ('!=', QLInteger, QLMoney)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value != r.value)),
            ('!=', QLMoney, QLInteger)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value != r.value)),
            ('!=', QLMoney, QLMoney)         :   (QLBoolean,  lambda l, r : QLBoolean(l.value != r.value)),
            ('!=', QLString, QLString)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value != r.value)),
            ('!=', QLBoolean, QLBoolean)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value != r.value)),

            ('&&', QLBoolean, QLBoolean)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value and r.value)),

            ('||', QLBoolean, QLBoolean)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value or r.value)),
        }

def nativeQuestionType(questionType):
    return {
        'boolean' : QLBoolean,
        'string' : QLString,
        'integer' : QLInteger,
        'money' : QLMoney
    }[questionType]
