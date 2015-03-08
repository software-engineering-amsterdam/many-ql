import QL.Grammar.constants as constants
import QL.Runtime.gui
import QL.AST.Statements.question as q


class RQuestion(q.Question):
    def __init__(self, qid, qtype, label):
        super(RQuestion, self).__init__(qid, qtype, label)


    # set gui _element
    def set_element(self, gui):
        if self.get_type() is constants.GrammarConstants.BOOL:
            self._element = QL.Runtime.gui.QuestionnaireGUI.e_radio(self, gui)
        elif self.get_type() is constants.GrammarConstants.NUMBER:
            self._element = QL.Runtime.gui.QuestionnaireGUI.e_spin(self, gui)
        elif self.get_type() is constants.GrammarConstants.TEXT:
            self._element = QL.Runtime.gui.QuestionnaireGUI.e_entry(self, gui)
        else:
            raise QL.Runtime.gui.QException("Element _type does not exists")

    def get_element(self):
        return self._element