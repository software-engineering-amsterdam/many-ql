class Operator
  attr_reader :method, :arguments

  def initialize(method:, arguments:)
    @method = method
    @arguments = arguments
  end

  def calculate
    method.call(arguments)
  end

  def valid?
    arguments.all do |argument|
      argument.type == argument_type && argument.valid?
    end
  end
end

class BooleanOperator < Operator # || &&
  def type
    :boolean
  end

  def argument_type
    :boolean
  end
end

class CompareOperator < Operator # ==, !=, <, >
  def type
    :boolean
  end

  def argument_type
    :integer
  end
end

class ComputeOperator < Operator # * + - /
  def type
    :integer
  end

  def argument_type
    :integer
  end
end

class Statement
  def statements
    raise "Statement.statements niet geimplementeerd"
  end

  def questions
    statements.flat_map(&:questions)
  end
end


class Form < Statement
  attr_reader :name, :statements

  def initialize(name:, statements:)
    @name = name
    @statements = statements
  end
end

class Question < Statement
  attr_reader :description, :variable_name, :type

  def initialize(description:, variable_name:, type:)
    @description = description
    @variable_name = variable_name
    @type = type
  end

  def questions
    self
  end
end

class If < Statement
  attr_reader :expression, :statements

  def initialize(expression:, statements:)
    @expression = expression
    @statements = statements
  end
end

class IfElse < Statement
  attr_reader :expression, :statements_true, :statements_false

  def initialize(expression:, statements_true:, statements_false:)
    @expression = expression
    @statements_true = statements_true
    @statements_false = statements_false
  end

  def statements
    statements_true + statements_false
  end
end
