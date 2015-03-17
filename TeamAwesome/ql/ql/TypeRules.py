import operator
from .QLTypes import *

class OperatorTable:
    def __init__(self):
        self._binaryPythonOperators = {
            '+'  : operator.add,
            '-'  : operator.sub,
            '/'  : lambda l, r : l / r,
            '*'  : operator.mul,
            '^'  : operator.pow,
            '%'  : operator.mod,
            '>'  : operator.gt,
            '<'  : operator.lt,
            '>=' : operator.ge,
            '<=' : operator.le,
            '==' : operator.eq,
            '!=' : operator.ne,
            '&&' : lambda l, r : l and r,
            '||' : lambda l, r : l or r
        }

        self._unaryPythonOperators = {
            '+' : lambda l : +l,
            '-' : operator.neg,
            '!' : operator.not_
        }

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

    def _getBinaryPythonOperator(self, op):
        return self._binaryPythonOperators[op]

    def _getUnaryPythonOperator(self, op):
        return self._unaryPythonOperators[op]

    def _createRules(self):
        return {
            ('-', QLInteger)    :   (QLInteger, lambda v : QLInteger(-v.value)),
            ('-', QLMoney)      :   (QLMoney,   lambda v : QLMoney(-v.value)),
            ('+', QLInteger)    :   (QLInteger, lambda v : QLInteger(+v.value)),
            ('+', QLMoney)      :   (QLMoney,   lambda v : QLMoney(+v.value)),
        
            ('!', QLBoolean)    :   (QLBoolean, lambda v : QLBoolean(!v.value)),

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

            ('*', QLString, QLInteger)      :   (QLString,  lambda l, r : QLString(l.value * r.value)),
            ('*', QLInteger, QLString)      :   (QLString,  lambda l, r : QLString(l.value * r.value)),
            
            ('+', QLString, QLInteger)      :   (QLString,  lambda l, r : QLString(l.value + str(r.value))),
            ('+', QLInteger, QLString)      :   (QLString,  lambda l, r : QLString(str(l.value) + r.value)),
            ('+', QLString, QLString)       :   (QLString,  lambda l, r : QLString(l.value + r.value)),
            ('+', QLString, QLString)       :   (QLString,  lambda l, r : QLString(l.value + r.value)),
            ('+', QLString, QLMoney)        :   (QLString,  lambda l, r : QLString(l.value + str(r.value))),
            ('+', QLMoney, QLString)        :   (QLString,  lambda l, r : QLString(str(l.value) + r.value)),
            ('+', QLString, QLBoolean)      :   (QLString,  lambda l, r : QLString(l.value + str(r.value))),
            ('+', QLBoolean, QLString)      :   (QLString,  lambda l, r : QLString(str(l.value) + r.value)),

            ('<', QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
            ('<', QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
            ('<', QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
            ('<', QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
            ('<', QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
            ('<', QLInteger, QLInteger)     :   (QLBoolean,  lambda l, r : QLBoolean(l.value < r.value)),
        }

    def _booleanBinaryOperatorRules(self):
        rules = {}

        for op in ('<','<=','>','>='):
            pyOp = self._getBinaryPythonOperator(op)
            rules.update({ 
                (op, int, int) : (bool, lambda l, r, pyOp = pyOp : pyOp(l, r)),
                (op, int, Money) : (bool, lambda l, r, pyOp = pyOp : pyOp(l, r)),
                (op, Money, int) : (bool, lambda l, r, pyOp = pyOp : pyOp(l, r)),
                (op, Money, Money) : (bool, lambda l, r, pyOp = pyOp : pyOp(l, r)),
                (op, str, str) : (bool, lambda l, r, pyOp = pyOp : pyOp(len(l), len(r)))
            })

        for op in ('==','!='):
            pyOp = self._getBinaryPythonOperator(op)
            rules.update({
                (op, int, int) : (bool, lambda l, r, pyOp = pyOp : pyOp(l, r)),
                (op, int, Money) : (bool, lambda l, r, pyOp = pyOp : pyOp(l, r)),
                (op, Money, int) : (bool, lambda l, r, pyOp = pyOp : pyOp(l, r)),
                (op, Money, Money) : (bool, lambda l, r, pyOp = pyOp : pyOp(l, r)),
                (op, str, str) : (bool, lambda l, r, pyOp = pyOp : pyOp(l, r)),
                (op, bool, bool) : (bool, lambda l, r, pyOp = pyOp : pyOp(l, r))
            })

        pyOpAnd = self._getBinaryPythonOperator('&&')
        pyOpOr = self._getBinaryPythonOperator('||') 

        rules.update({
            ('&&', bool, bool) : (bool, lambda l, r, pyOp = pyOpAnd : pyOp(l, r)),
            ('||', bool, bool) : (bool, lambda l, r, pyOp = pyOpOr : pyOp(l, r))    
        })

        return rules


def nativeQuestionType(questionType):
    return {
        'boolean' : QLBoolean,
        'string' : QLString,
        'integer' : QLInteger,
        'money' : QLMoney
    }[questionType]
