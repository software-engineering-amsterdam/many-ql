require_relative "static_checker"

class FormFlattener < StaticChecker
  def visit_question(question)
    question
  end  

  def visit_if(conditional)
    conditional.statements.map { |statement| [statement.accept(self), if_statement.expression] }
  end

  def flatten
    self.visit(form)
  end
end
