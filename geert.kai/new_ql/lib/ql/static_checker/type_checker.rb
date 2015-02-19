require_relative "static_checker"
require_relative "../ast/ast"
require "byebug"

class DuplicateReferenceError < StandardError
end

class TypeChecker < StaticChecker
  def after_initialize(form)
    @types = {}
  end

  visitor_for Question do |question|
    unless @types[question.variable_name]
      @types[question.variable_name] = question.type
    else
      raise DuplicateReferenceError.new("Variable #{question.variable_name} already defined")
    end
  end

  visitor_for Conditional do |condition|
    unless condition.expression.accept(self) == :boolean
      raise TypeError.new("Expression in condition not a boolean: #{condition}.") 
    end

    condition.statements.map do |statement|
      statement.accept(self)
    end
  end

  visitor_for BinaryExpression do |expression|
    [expression.lhs, expression.rhs].each do |expr|
      unless expression.possible_argument_types.include?(expr.accept(self))
        raise TypeError.new "#{expr.type} doesn't match any of #{expression.possible_argument_types} in #{expression}."
      end
    end

    unless expression.lhs.type == expression.rhs.type
      raise TypeError.new "#{expression.lhs} doesn't match type of #{expression.rhs}"
    end

    expression.type
  end

  visitor_for Variable do |variable|
    raise NameError.new("Variable #{variable.name} not defined.") unless @types[variable.name]
    @types[variable.name]
  end

  visitor_for Literal do |literal|
    literal.type
  end

  def check
    visit form
  end
end
