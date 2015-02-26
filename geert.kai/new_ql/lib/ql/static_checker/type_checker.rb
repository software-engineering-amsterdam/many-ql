require_relative "static_checker"
require_relative "../ast/ast"

class TypeChecker < StaticChecker
  def after_initialize(base)
    @types = {}
  end

  def errors
    @errors = []
    visit @base 
    @errors
  end

  def visit_form(form)
    map_accept(form.statements)
  end

  def visit_question(question)
    if @types[question.variable_name]
      @errors << Exception.new("Variable #{question.variable_name} already defined")
    else
      @types[question.variable_name] = question.type
    end
  end

  def visit_conditional(conditional)
    unless [:boolean, :undefined].include?(conditional.expression.accept(self))
      @errors << Exception.new("Expression in condition not a boolean: #{conditional}.")
    end

    map_accept(conditional.statements)
  end

  def visit_binary_expression(expression) #ZOOI
    lhs_type = expression.lhs.accept(self)
    rhs_type = expression.rhs.accept(self)

    return :undefined if lhs_type == :undefined || rhs_type == :undefined

    unless expression.possible_argument_types.include?(lhs_type)
      @errors << Exception.new("#{lhs_type} doesn't match any of #{expression.possible_argument_types} in #{expression}.")
    end

    unless expression.possible_argument_types.include?(rhs_type)
      @errors << Exception.new("#{rhs_type} doesn't match any of #{expression.possible_argument_types} in #{expression}.")
    end

    #unless lhs_type == rhs_type
      #@errors << Exception.new("#{expression.lhs} doesn't match type of #{expression.rhs}")
    #end

    expression.type
  end

  def visit_variable(variable)
    if @types[variable.name]
      @types[variable.name]
    else
      @errors << Exception.new("Variable #{variable.name} not defined.")
      :undefined
    end
  end

  def visit_literal(literal)
    literal.type
  end
end
