import QL.Runtime.form as ql_form
import QLS.Runtime.question as runtime_question
import QL.Tools.exceptions as exc


class Form(ql_form.Form):
    def __enrich_questions(self):
        """
        takes the basic ast questions and generate new enriched question objects
        with gui element, order and other useful stuff for runtime.
            self.__ast_questions = list of questions based on the ast only
            self.__q_conditions_dict = dict of the questions with their parent conditions
            self.questions = new enriched questions
        """
        order = 0
        for basic_question in self.__ast_questions:
            qid = basic_question.get_id()
            if qid not in self.__q_conditions_dict:
                raise exc.QException("Fatal Error: id does not exist in the dict!")
            enriched_question = runtime_question.Question(basic_question, order, self.__q_conditions_dict[qid])
            self.questions.append(enriched_question)
            order += 1