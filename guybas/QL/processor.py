from pyparsing import *
class Processor:
    def conditions_proc(self, condition):
        # TODO: process the expression, and return true/false
        c_list = ParseResults(condition).asList()
        print(str(c_list))
        # c_str  = str.join(condition)
        # print(eval(c_str))
        return True