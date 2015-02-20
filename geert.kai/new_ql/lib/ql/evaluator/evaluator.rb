require_relative "../static_checker/visitor"

class Runner < BaseVisitor
  def initialize(form)
    @form = form
    @values = {}
  end 

  def next_question
    "Pietje"
  end

  def update(variable_name:, value:)
    @values[variable_name] = value
  end

  visitor_for Form do |form|
    form.accept(self)
  end

  visitor_for Question do |question|
    if looked_for_question.nil?
      question 
    elsif question == looked_for_question
      looked_for_question = nil
    else
  end

end

class Evaluator < BaseVisitor
  def self.evaluate(expression, values)
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
