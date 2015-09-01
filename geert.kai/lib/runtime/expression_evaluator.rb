require_relative "../visitor_pattern/base_visitor"

module QL
  class UndefinedExpression
    def to_s
      "-"
    end
  end

  class ExpressionEvaluator < VisitorPattern::BaseVisitor
    def initialize(values)
      @values = values
    end

    def visit_binary_expression(expression) #nil or undefined?
      lhs = expression.lhs.accept(self)
      rhs = expression.rhs.accept(self)

      if lhs.is_a?(UndefinedExpression) || rhs.is_a?(UndefinedExpression)
        UndefinedExpression.new
      else
        lhs.send(expression.operator, rhs)
      end
    end

    def visit_variable(variable)
      @values.fetch(variable.name, UndefinedExpression.new)
    end

    def visit_literal(literal)
      literal.value
    end
  end
end
