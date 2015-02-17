from CustomTypes import *

class Table:
    def __init__(self):
        self._rules = Table._createRules()

    def unaryOperationType(self, op, typeRight):
        return self._rules.get((op, typeRight), None)

    def binaryOperationType(self, op, typeLeft, typeRight):
        return self._rules.get((op, typeLeft, typeRight), None)

    @staticmethod
    def _createRules():
        rules = {}
        rules.update(Table._numericalUnaryOperatorRules())
        rules.update(Table._booleanUnaryOperatorRules())
        rules.update(Table._numericalBinaryOperatorRules())
        rules.update(Table._stringBinaryOperatorRules())
        rules.update(Table._booleanBinaryOperatorRules())
        return rules

    @staticmethod
    def _numericalUnaryOperatorRules():
        rules = {}
        for op in ('-','+'):
            rules.update({
                (op, int) : int,
                (op, Money) : Money
            })
        return rules

    @staticmethod
    def _booleanUnaryOperatorRules():
        return {
            ('!', bool) : bool
        }

    @staticmethod
    def _numericalBinaryOperatorRules():
        rules = {}
        for op in ('^','*','/','%','+','-'):
            rules.update({
                (op, int, int) : int,
                (op, int, Money) : Money,
                (op, Money, int) : Money,
                (op, Money, Money) : Money # Money, money money!
            })
        return rules

    @staticmethod
    def _stringBinaryOperatorRules():
        rules = {
            ('*', str, int) : str,
            ('*', int, str) : str
        }
        for t in (str,int,Money,bool):
            rules.update({
                ('+', str, t) : str,
                ('+', t, str) : str,
            })
        return rules

    @staticmethod
    def _booleanBinaryOperatorRules():
        rules = {}

        for op in ('<','<=','>','>='):
            rules.update({ 
                (op, int, int) : bool,
                (op, int, Money) : bool,
                (op, Money, int) : bool,
                (op, Money, Money) : bool,
                (op, str, str) : bool
            })

        for op in ('==','!='):
            rules.update({
                (op, int, int) : bool,
                (op, int, Money) : bool,
                (op, Money, int) : bool,
                (op, Money, Money) : bool,
                (op, str, str) : bool,
                (op, bool, bool) : bool
            })

        rules.update({
            ('&&', bool, bool) : bool,
            ('||', bool, bool) : bool    
        })

        return rules