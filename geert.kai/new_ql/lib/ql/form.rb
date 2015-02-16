class Form 
  attr_reader :name, :statements

  def initialize(name:, statements:)
    @name = name
    @statements = statements
  end
end

class Statement
  #def statements
    #raise "Statement.statements niet geimplementeerd"
  #end

  #def questions
    #statements.flat_map(&:questions)
  #end
end

class Question < Statement
  attr_reader :description, :variable_definition

  def initialize(description:, variable_definition:)
    @description = description
    @variable_definition = variable_definition
  end

  #def questions
    #self
  #end
end

class VariableDefinition
  attr_reader :name, :type

  def initialize(name:, type:)
    @name = name
    @type = type
  end
end

# expression to this superclass?
class ConditionalStatement < Statement
end

class If < ConditionalStatement
  attr_reader :expression, :statements

  def initialize(expression:, statements:)
    @expression = expression
    @statements = statements
  end
end

class IfElse < ConditionalStatement
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
