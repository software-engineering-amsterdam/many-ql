require_relative "../visitor_pattern/base_visitor"

module QL
  class UndefinedExpression
  end

  class ExpressionEvaluator < VisitorPattern::BaseVisitor
    def initialize(values)
      @values = values
    end

    # Dit werkt niet meer, want de magic is gone. Losse methods schrijven.
    def visit_binary_expression(expression) #nil or undefined?
      lhs = expression.lhs.accept(self)
      rhs = expression.rhs.accept(self)

      if lhs.is_a?(UndefinedExpression) || rhs.is_a?(UndefinedExpression)
        UndefinedExpression.new
      else
        lhs.send(expression.operator, rhs)
      end
    end
    #
    # def visit_and(expression)
    #   visit_binary_expression(expression)
    # end
    #
    # def visit_or(expression)
    #   visit_binary_expression(expression)
    # end
    #
    # def visit_equal(expression)
    #   visit_binary_expression(expression)
    # end
    #
    # def visit_inequal(expression)
    #   visit_binary_expression(expression)
    # end
    #
    # def visit_less_than(expression)
    #   visit_binary_expression(expression)
    # end
    #
    # def visit_less_than_or_equal_to(expression)
    #   visit_binary_expression(expression)
    # end
    #
    # def visit_greater_than(expression)
    #   visit_binary_expression(expression)
    # end
    #
    # def visit_greater_than_or_equal_to(expression)
    #   visit_binary_expression(expression)
    # end
    #
    # def visit_plus(expression)
    #   visit_binary_expression(expression)
    # end
    #
    # def visit_minus(expression)
    #   visit_binary_expression(expression)
    # end
    #
    # def visit_multiplication(expression)
    #   visit_binary_expression(expression)
    # end
    #
    # def visit_division(expression)
    #   visit_binary_expression(expression)
    # end

    def visit_variable(variable)
      @values.fetch(variable.name, UndefinedExpression.new)
    end

    def visit_literal(literal)
      literal.value
    end
    #
    # def visit_integer_literal(literal)
    #   literal.value
    # end
    #
    # def visit_boolean_literal(literal)
    #   literal.value
    # end
  end
end
