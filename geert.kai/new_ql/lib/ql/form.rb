class Statement
end

class Form
  def initialize(name:, statements:)
    @name = name
    @statements = statements

  end
end

class Question < Statement
  def initialize(description:, variable_name:, type:)

  end
end

class If
  def initialize(expression:, statements:)
  end
end

class IfElse
  def initialize(expression:, statements_true:, statements_false:)

  end
end
