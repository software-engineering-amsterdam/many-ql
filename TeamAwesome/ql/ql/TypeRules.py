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
        rules = {}
        rules.update(self._numericalUnaryOperatorRules())
        #rules.update(self._booleanUnaryOperatorRules())
        #rules.update(self._numericalBinaryOperatorRules())
        #rules.update(self._stringBinaryOperatorRules())
        #rules.update(self._booleanBinaryOperatorRules())
        return rules

    def _numericalUnaryOperatorRules(self):
        rules = {}
        for op in ('-','+'):
            pyOp = self._getUnaryPythonOperator(op)

            rules.update({
                (op, QLInteger) : (QLInteger, lambda r, pyOp = pyOp : QLInteger(pyOp(r.value))),
                (op, QLMoney) : (QLMoney, lambda r, pyOp = pyOp : QLMoney(pyOp(r.value)))
            })
        return rules

    def _booleanUnaryOperatorRules(self):
        pyOp = self._getUnaryPythonOperator('!')
        
        return {
            ('!', bool) : (bool, lambda r, pyOp = pyOp : pyOp(r))
        }

    def _numericalBinaryOperatorRules(self):
        rules = {}
        for op in ('^','*','/','%','-','+'):
            pyOp = self._getBinaryPythonOperator(op)

            rules.update({
                (op, int, int) : (int, lambda l, r, pyOp = pyOp : int(pyOp(l, r))),
                (op, int, Money) : (Money, lambda l, r, pyOp = pyOp : Money(pyOp(l, r))),
                (op, Money, int) : (Money, lambda l, r, pyOp = pyOp : Money(pyOp(l, r))),
                (op, Money, Money) : (Money, lambda l, r, pyOp = pyOp : Money(pyOp(l, r))) # Money, money money!
            })

        return rules

    def _stringBinaryOperatorRules(self):
        pyOp = self._getBinaryPythonOperator('*')
        rules = {
            ('*', str, int) : (str, lambda l, r, pyOp = pyOp : pyOp(l, r)),
            ('*', int, str) : (str, lambda l, r, pyOp = pyOp : pyOp(l, r))
        }

        pyOp = self._getBinaryPythonOperator('+')
        for t in (str,int,Money,bool):
            rules.update({
                ('+', str, t) : (str, lambda l, r, pyOp = pyOp : pyOp(l, str(r))),
                ('+', t, str) : (str, lambda l, r, pyOp = pyOp : pyOp(str(l), r)),
            })
        return rules

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
        'boolean' : bool,
        'string' : str,
        'integer' : int,
        'money' : Money
    }[questionType]
