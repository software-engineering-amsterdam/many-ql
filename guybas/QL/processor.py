from pyparsing import *
import collections


class Processor:
    def conditions_proc(self, condition):
        # process the expression, and return true/false
        result = eval(condition)
        if result:
            return True
        return False

    def rlist2string(self, a):
        res = ''
        if isinstance(a, list):
            for item in a:
                res += str(self.rlist2string(item)) + ' '
        else:
            res = str(a)
        return res