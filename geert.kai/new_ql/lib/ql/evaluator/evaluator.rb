require_relative "../static_checker/visitor"

class Runner < BaseVisitor
  def initialize(form)
    @form = form
    @values = {}
    @mode = :run # next, run, return
    @lookup_question
    
  end 

  def answered(value)
    if @lookup_question
      @values[@lookup_question.variable_name] = value
    end
    @mode = :lookup
  end

  def next_question
    self.visit(@form)
    @lookup_question
  end

  visitor_for Form do |form|
    form.statements.each do |statement|
      statement.accept(self)
      if @mode == :return
        return
      end
    end
  end

  visitor_for Question do |question|
    # byebug
    case @mode
    when :lookup
      @mode = :run if question == @lookup_question
    when :run
      @mode = :return      
      @lookup_question = question
      question
    end
  end

  visitor_for If do |if_statement|
    case @mode
    when :lookup
      if_statement.statements.each do |statement|
        statement.accept(self)
      end
    when :run
      if Evaluator.evaluate(expression: if_statement.expression, values: @values).class == TrueClass
        if_statement.statements.each do |statement|
          s = statement.accept(self)
          return if @mode == :return
        end
      end
    when :return
      nil
    end
  end
end

class Evaluator < BaseVisitor
  def self.evaluate(expression: , values: )
    self.new(expression: expression, values: values).evaluate
  end
  
  def initialize(expression: , values: )
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
