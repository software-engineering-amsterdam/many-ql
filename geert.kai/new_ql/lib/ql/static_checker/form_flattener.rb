require_relative "static_checker"

class FormFlattener < StaticChecker
  def visit_question(question)
    question
  end

  def flatten
    self.visit(form)
  end
end
