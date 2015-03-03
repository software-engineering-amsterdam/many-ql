require_relative "../checker/base_visitor"

class Runner < BaseVisitor

  attr_reader :questions

  def after_initialize(base)    
    @questions = QuestionVisitor.new(@base).questions

    reset_visibilities
    @values = {}
  end

  def update_variable(variable_name, value)
    @values[variable_name] = value
    calculate_visibilities
  end

  def calculate_visibilities
    reset_visibilities
    visit @base
    @visibilities
  end

  def visible?(question)
    @visibilities[question]
  end


  def visit_form(form)
    map_accept(form.statements).flatten
  end

  def visit_conditional(condition)
    case Evaluator.new(condition.expression).evaluate(@values)
    when true
      map_accept(condition.statements_true)
    when false
      map_accept(condition.statements_false)
    when :undefined
      []
    end
  end

  def visit_question(question)
    @visibilities[question] = true
  end

  private

  def reset_visibilities
    @visibilities = @questions.map { |q| [q, false] }.to_h
  end
end

class Evaluator < BaseVisitor
  def evaluate(values)
    @values = values
    visit @base
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

class QuestionVisitor < BaseVisitor

  def questions
    visit @base
  end

  def visit_form(form)
    map_accept(form.statements).flatten
  end

  def visit_conditional(condition)
    map_accept(condition.statements).flatten
  end

  def visit_question(question)
    question
  end
end