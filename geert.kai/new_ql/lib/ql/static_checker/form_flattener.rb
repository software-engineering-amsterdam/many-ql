require_relative "static_checker"

class FormFlattener < StaticChecker
  visitor_for Question do |question|
    question
  end  

  visitor_for If do |if_statement|
    if_statement.statements.map { |statement| [statement.accept(self), if_statement.expression] }
  end

  def flatten
    self.visit(form)
  end
end
