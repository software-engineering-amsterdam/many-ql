require_relative "static_checker"
require_relative "../ast/ast"
require "byebug"

class TypeChecker < StaticChecker
  def initialize(form)
    @form = form
    @types = {}
  end

  visitor_for Form do |form|
    form.accept(self)
  end

  visitor_for Question do |question|
    unless @types[question.variable_name]
      @types[question.variable_name] = question.type
    else
      raise "Variable #{question.variable_name} already defined"
    end
  end

  visitor_for Conditional do |condition|
    raise "Expression in condition not a boolean: {condition}." unless condition.expression.accept(self) == :boolean

    condition.statements.map do |statement|
      statement.accept(self)
    end
  end

  visitor_for BinaryExpression do |expression|
    if expression.accept(self).all { |type| expression.argument_type == type }
      expression.type
    else
      raise "Types don't match in binary expression."
    end
  end

  visitor_for Variable do |condition|
    raise "Variable not defined." unless @types[variable.name]
    @types[variable.name]
  end

  visitor_for Literal do |literal|
    literal.type
  end

  def check
    byebug
    visit form
  end
end
