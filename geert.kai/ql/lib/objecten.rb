class Form < Statement
  def initialize(name:, statements:)
  end
end

class Conditional < Statement
  def initialize(expression:, statements:)
  end
end

class Question < Statement
  def initialize(title:, variable_name:, type:)
  end
end

class If
end

class IfElse
end

class Statement
end
