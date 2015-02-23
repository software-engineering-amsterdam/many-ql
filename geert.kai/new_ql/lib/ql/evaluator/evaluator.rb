require_relative "../static_checker/visitor"

class Runner < BaseVisitor
  def initialize(form)
    @form = form
    @values = {}
    @mode = :lookup # next, run, return
    @lookup_question
  end 

  def set_current_question(value)
    if @lookup_question
      @values[@lookup_question.variable_name] = value
    end
  end

  def next_question
    @form.visit(self)
  end

  visitor_for Form do |form|
    form.accept(self)
  end

  visitor_for Question do |question|
    case @mode
    when :lookup
      @mode = :run if question == @lookup_question
    when :run
      @mode = :return      
      question
    end
  end

  visitor_for If do |if_statement|
    case @mode
    when :lookup
      if_statement.visit(self)
    when :run
      if Evaluator.evaluate(if_statement.expression, @values).class == TrueClass
        if_statement.statements.visit(self)
      end
    when :return
      nil
    end
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
