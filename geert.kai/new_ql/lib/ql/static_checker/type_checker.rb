require_relative "static_checker"
require_relative "../ast/ast"

class DuplicateReferenceError < StandardError
end

class TypeChecker < StaticChecker
  def after_initialize(base)
    @types = {}
  end

  def check
    visit(base)
  end

  def visit_question(question)
    unless @types[question.variable_name]
      @types[question.variable_name] = question.type
    else
      raise DuplicateReferenceError.new("Variable #{question.variable_name} already defined")
    end
  end

  def visit_conditional(conditional)
    unless conditional.expression.accept(self) == :boolean
      raise TypeError.new("Expression in condition not a boolean: #{conditional}.") 
    end

    condition.statements.map do |statement|
      statement.accept(self)
    end
  end

  def visit_binary_expression(expression)
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

  def visit_variable(variable)
    raise NameError.new("Variable #{variable.name} not defined.") unless @types[variable.name]
    @types[variable.name]
  end

  def visit_literal(literal)
    literal.type
  end
end
