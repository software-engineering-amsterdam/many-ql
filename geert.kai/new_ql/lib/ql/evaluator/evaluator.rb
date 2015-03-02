require_relative "../static_checker/visitor"

class Runner < BaseVisitor

  def after_initialize(base)
    @values = {}
  end

  def update_variable(variable_name, value)
    @values[variable_name] = value
  end

  def applicable_questions
    visit @base
  end

  def visit_form(form)
    map_accept(form.statements).flatten
  end

  def visit_conditional(condition)
    case condition.expression.accept(self)
    when true
      map_accept(condition.statements_true)
    when false
      map_accept(condition.statements_false)
    when :undefined
      []
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
