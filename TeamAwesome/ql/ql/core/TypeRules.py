import operator

from .QLTypes import *
from .QLOperators import *



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


    # The rules contain type information and evaluation information
    # for operators applied to various types of operands.
    #
    # It is a map of (operator, operand_type..)  :  (return_type, evaluation_function)
    def _createRules(self):
        return {
            (QLUnaryMinus, QLInteger)    :   (QLInteger, lambda v : QLInteger(-v.value)),
            (QLUnaryMinus, QLMoney)      :   (QLMoney,   lambda v : QLMoney(-v.value)),
            (QLUnaryPlus, QLInteger)    :   (QLInteger, lambda v : QLInteger(+v.value)),
            (QLUnaryPlus, QLMoney)      :   (QLMoney,   lambda v : QLMoney(+v.value)),
        
            (QLLogicalNot, QLBoolean)    :   (QLBoolean, lambda v : QLBoolean(not v.value)),

            (QLExponentiation, QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value**r.value)),
            (QLExponentiation, QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value**r.value)),
            (QLExponentiation, QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value**r.value)),
            (QLExponentiation, QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value**r.value)),

            (QLMultiplication, QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value * r.value)),
            (QLMultiplication, QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value * r.value)),
            (QLMultiplication, QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value * r.value)),
            (QLMultiplication, QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value * r.value)),

            (QLDivision, QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value / r.value)),
            (QLDivision, QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value / r.value)),
            (QLDivision, QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value / r.value)),
            (QLDivision, QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value / r.value)),
            
            (QLDivision, QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value / r.value)),
            (QLDivision, QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value / r.value)),
            (QLDivision, QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value / r.value)),
            (QLDivision, QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value / r.value)),
            
            (QLModulo, QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value % r.value)),
            (QLModulo, QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value % r.value)),
            (QLModulo, QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value % r.value)),
            (QLModulo, QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value % r.value)),
        
            (QLSubtraction, QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value - r.value)),
            (QLSubtraction, QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value - r.value)),
            (QLSubtraction, QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value - r.value)),
            (QLSubtraction, QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value - r.value)),
            
            (QLAddition, QLInteger, QLInteger)     :   (QLInteger, lambda l, r : QLInteger(l.value + r.value)),
            (QLAddition, QLInteger, QLMoney)       :   (QLMoney,   lambda l, r : QLMoney(l.value + r.value)),
            (QLAddition, QLMoney, QLInteger)       :   (QLMoney,   lambda l, r : QLMoney(l.value + r.value)),
            (QLAddition, QLMoney, QLMoney)         :   (QLMoney,   lambda l, r : QLMoney(l.value + r.value)),
            (QLAddition, QLString, QLInteger)      :   (QLString,  lambda l, r : QLString(l.value + str(r.value))),
            (QLAddition, QLInteger, QLString)      :   (QLString,  lambda l, r : QLString(str(l.value) + r.value)),
            (QLAddition, QLString, QLString)       :   (QLString,  lambda l, r : QLString(l.value + r.value)),
            (QLAddition, QLString, QLString)       :   (QLString,  lambda l, r : QLString(l.value + r.value)),
            (QLAddition, QLString, QLMoney)        :   (QLString,  lambda l, r : QLString(l.value + str(r.value))),
            (QLAddition, QLMoney, QLString)        :   (QLString,  lambda l, r : QLString(str(l.value) + r.value)),
            (QLAddition, QLString, QLBoolean)      :   (QLString,  lambda l, r : QLString(l.value + str(r.value))),
            (QLAddition, QLBoolean, QLString)      :   (QLString,  lambda l, r : QLString(str(l.value) + r.value)),

            (QLMultiplication, QLString, QLInteger)      :   (QLString,  lambda l, r : QLString(l.value * r.value)),
            (QLMultiplication, QLInteger, QLString)      :   (QLString,  lambda l, r : QLString(l.value * r.value)),
            
            (QLLess, QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
            (QLLess, QLInteger, QLMoney)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
            (QLLess, QLMoney, QLInteger)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
            (QLLess, QLMoney, QLMoney)         :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
            (QLLess, QLString, QLString)       :   (QLBoolean,  lambda l, r : QLBoolean(len(l.value) < len(r.value))),

            (QLLessEquals, QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value <= r.value)),
            (QLLessEquals, QLInteger, QLMoney)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value <= r.value)),
            (QLLessEquals, QLMoney, QLInteger)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value <= r.value)),
            (QLLessEquals, QLMoney, QLMoney)         :   (QLBoolean,  lambda l, r : QLBoolean(l.value <= r.value)),
            (QLLessEquals, QLString, QLString)       :   (QLBoolean,  lambda l, r : QLBoolean(len(l.value) <= len(r.value))),
  
            (QLGreater, QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value > r.value)),
            (QLGreater, QLInteger, QLMoney)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value > r.value)),
            (QLGreater, QLMoney, QLInteger)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value > r.value)),
            (QLGreater, QLMoney, QLMoney)         :   (QLBoolean,  lambda l, r : QLBoolean(l.value > r.value)),
            (QLGreater, QLString, QLString)       :   (QLBoolean,  lambda l, r : QLBoolean(len(l.value) > len(r.value))),
 
            (QLGreaterEquals, QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value >= r.value)),
            (QLGreaterEquals, QLInteger, QLMoney)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value >= r.value)),
            (QLGreaterEquals, QLMoney, QLInteger)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value >= r.value)),
            (QLGreaterEquals, QLMoney, QLMoney)         :   (QLBoolean,  lambda l, r : QLBoolean(l.value >= r.value)),
            (QLGreaterEquals, QLString, QLString)       :   (QLBoolean,  lambda l, r : QLBoolean(len(l.value) >= len(r.value))),
        
            (QLEquals, QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value == r.value)),
            (QLEquals, QLInteger, QLMoney)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value == r.value)),
            (QLEquals, QLMoney, QLInteger)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value == r.value)),
            (QLEquals, QLMoney, QLMoney)         :   (QLBoolean,  lambda l, r : QLBoolean(l.value == r.value)),
            (QLEquals, QLString, QLString)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value == r.value)),
            (QLEquals, QLBoolean, QLBoolean)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value == r.value)),

            (QLNotEquals, QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value != r.value)),
            (QLNotEquals, QLInteger, QLMoney)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value != r.value)),
            (QLNotEquals, QLMoney, QLInteger)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value != r.value)),
            (QLNotEquals, QLMoney, QLMoney)         :   (QLBoolean,  lambda l, r : QLBoolean(l.value != r.value)),
            (QLNotEquals, QLString, QLString)       :   (QLBoolean,  lambda l, r : QLBoolean(l.value != r.value)),
            (QLNotEquals, QLBoolean, QLBoolean)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value != r.value)),

            (QLLogicalAnd, QLBoolean, QLBoolean)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value and r.value)),

            (QLLogicalOr, QLBoolean, QLBoolean)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value or r.value)),
        }
