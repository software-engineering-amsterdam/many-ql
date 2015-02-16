# Visitables:
# Form
# Statement
# VariableDefinition
# Expression

module Visitable
  def accept(visitor)
    visitor.visit(self)
  end
end

class Node
  def accept(visitor)
    raise NotImplementedError.new
  end
end

class NotImplementedError < Exception
end

class Visitor
   
end
