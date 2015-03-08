import QL.AST.form as form
import QL.Runtime.statement as statement
import QL.Main.converters as converters


class RForm(form.Form):
    def __init__(self, name, introduction, statements):
        # Set the run time form properties as the ast properties
        temp_statements = (
            RForm.set_statement_ids(str(self),
                RForm.set_question_ordering(statements))
        )
        RForm.print_something(temp_statements)
        run_time_statements = RForm.replace_questions(temp_statements)

        super(RForm, self).__init__(name, introduction, run_time_statements)
        print(self._statements)

    @staticmethod
    def print_something(statements):
        for s in statements:
            if s.is_conditional():
                RForm.print_something(s.get_c_statements)
                RForm.print_something(s.get_e_statements)
            else:
                print(s.get_order())

    @staticmethod
    def replace_questions(statements):
        runtime_statements = []
        for s in statements:
            if not s.is_conditional():
                x = statement.RQuestion(s.get_id(), s.get_type(), s.get_label())
                runtime_statements.append(x)
            else:
                runtime_statements += RForm.replace_questions(s.get_c_statements())
                runtime_statements += RForm.replace_questions(s.get_e_statements())
        return runtime_statements

    # Set the ordering of questions for display
    @staticmethod
    def set_question_ordering(statements):
        c = 0
        for s in statements:
            c = s.set_order(c)
        return statements

    @staticmethod
    def set_statement_ids(string, statements):
        m = converters.Converters.get_md5(str(string))
        for s in statements:
            s.set_parent_id(m)
        return statements