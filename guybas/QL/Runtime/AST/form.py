import QL.AST.form as form
import QL.Runtime.AST.question as question
import QL.Main.converters as converters
import QL.AST.Statements.else_statement as e


class RForm(form.Form):
    def __init__(self, name, introduction, statements):
        # Set the run time form properties as the ast properties
        m = converters.Converters.get_md5(str(self))
        run_time_statements = RForm.replace_questions(statements, None, m)
        temp_statements = RForm.set_question_ordering(run_time_statements)

        super(RForm, self).__init__(name, introduction, temp_statements)


    @staticmethod
    def replace_questions(statements, condition, pid):
        runtime_statements = []
        for s in statements:
            if not s.is_conditional():
                x = question.RQuestion(s.get_id(), s.get_type(), s.get_label())
                x.set_parent_condition(condition)
                x.set_parent_id(pid)
                if condition:
                    print(s.get_id())
                    print(condition.pretty_print())
                    print(pid)
                runtime_statements.append(x)
            else:
                d = s.get_condition()
                m = converters.Converters.get_md5(str(s))
                if isinstance(s, e.IfElseBlock):

                    runtime_statements += RForm.replace_questions(s.get_statements(), d, m)
                    if d:
                        c = d.add_not()
                        runtime_statements += RForm.replace_questions(s.get_e_statements(), c, m)
                else:
                    runtime_statements += RForm.replace_questions(s.get_statements(), s.get_condition(), m)
        return runtime_statements

    # Set the ordering of questions for display
    @staticmethod
    def set_question_ordering(statements):
        c = 0
        for s in statements:
            if s.is_conditional():
                c = RForm.set_question_ordering(s.get_statements())
            else:
                c = s.set_order(c)
        return statements