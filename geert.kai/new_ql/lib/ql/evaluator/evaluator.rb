require_relative "../static_checker/visitor"

class Runner < BaseVisitor
  def initialize(base)
    @base = base
    @values = {}
  end 

  def update_variable(variable_name, value)
    @values[variable_name] = value
  end

  def visible_questions
    self.visit(@base)
  end

  def visit_form(form)
    accept_statements(form.statements).flatten
  end

  def visit_conditional(condition)
    case self.visit(condition.expression) 
    when true
      accept_statements(condition.statements_true)
    when false
      accept_statements(condition.statements_false)
    when :undefined
      []
    end
  end

  def accept_statements(statements)
    statements.map do |statement|
      statement.accept(self) 
    end
  end

  def visit_question(question)
    question
  end

  def visit_binary_expression(expression)
    lhs = expression.lhs.accept(self)
    rhs = expression.rhs.accept(self)

    if lhs == :undefined || rhs == :undefined
      :undefined
    else
      lhs.send(expression.operator, rhs)
    end
  end

  def visit_variable(variable)
    @values[variable.name] || :undefined
  end

  def visit_literal(literal)
    literal.value
  end

end
