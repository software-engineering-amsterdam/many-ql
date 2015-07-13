require_relative "errors"

module QL
  module Checkers
    class UndefinedVariableChecker < VisitorPattern::BaseVisitor
      def visit_form(form)
        @variable_names = form.accept(VisitorPattern::QuestionVisitor.new).map(&:variable_name)

        form.statements.flat_map do |statement|
          visit(statement)
        end
      end

      def visit_question(question)
        []
      end

      def visit_if_else(if_else)
        errors = []

        errors += visit(if_else.expression)

        errors += if_else.statements.flat_map do |statement|
          visit(statement)
        end
      end

      def visit_binary_expression(expression)
        [ visit(expression.lhs), visit(expression.rhs) ].flatten
      end

      def visit_variable(variable)
        if @variable_names.include?(variable.name)
          []
        else
          [ Error.new("#{variable.name} is not defined.") ]
        end
      end

      def visit_and(expression)
        visit_binary_expression(expression)
      end

      def visit_or(expression)
        visit_binary_expression(expression)
      end

      def visit_equal(expression)
        visit_binary_expression(expression)
      end

      def visit_inequal(expression)
        visit_binary_expression(expression)
      end

      def visit_less_than(expression)
        visit_binary_expression(expression)
      end

      def visit_less_than_or_equal_to(expression)
        visit_binary_expression(expression)
      end

      def visit_greater_than(expression)
        visit_binary_expression(expression)
      end

      def visit_greater_than_or_equal_to(expression)
        visit_binary_expression(expression)
      end

      def visit_plus(expression)
        visit_binary_expression(expression)
      end

      def visit_minus(expression)
        visit_binary_expression(expression)
      end

      def visit_multiplication(expression)
        visit_binary_expression(expression)
      end

      def visit_division(expression)
        visit_binary_expression(expression)
      end

      def visit_integer_literal(literal)
        []
      end

      def visit_boolean_literal(literal)
        []
      end

      def visit_string_literal(literal)
        []
      end
    end
  end
end
