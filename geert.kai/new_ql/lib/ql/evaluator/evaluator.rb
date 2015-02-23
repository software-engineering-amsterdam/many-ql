require_relative "../static_checker/visitor"

class Runner
  def initialize(form)
    @form = form
    @values = {}
  end 

  def next_question
    self.visit(@form)
  end

  def update(variable_name:, value:)
    @values[variable_name] = value
  end
end

class Evaluator < BaseVisitor
  def self.evaluate(expression:, values:)
    self.new(expression, values).evaluate
  end

  def initialize(expression, values)
    @expression = expression
    @values = values
  end

  def evaluate
    visit(@expression)
  end
  
  visitor_for BinaryExpression do |expression|
    expression.lhs.accept(self).send(expression.operator, expression.rhs.accept(self))
  end

  visitor_for Variable do |variable|
    @values[variable.name]
  end

  visitor_for Literal do |literal|
    literal.value
  end
end
