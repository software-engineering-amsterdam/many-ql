require_relative "../visitor_pattern/base_visitor"
require_relative "types_visitor"
require_relative "errors"

module QL
  module Checkers
    class TypeChecker < VisitorPattern::BaseVisitor
      def visit_form(form)
        @types = form.accept(TypesVisitor.new).to_h

        form.statements.flat_map do |statement|
          visit_statement(statement)
        end
      end

      def visit_statement(statement)
        if statement.class == QL::AST::Question
          []
        else
          visit_if_else(statement)
        end
      end

      def visit_if_else(if_else)
        errors = []

        unless get_type(if_else.expression) == AST::BooleanType.new
          errors << Error.new("Invalid type in #{if_else}: #{get_type(if_else.expression)} is not a boolean.")
        end

        errors += visit_expression(if_else.expression)

        errors += if_else.statements.flat_map do |statement|
          visit_statement(statement)
        end
      end

      def visit_expression(expression)
        if expression.class == QL::AST::BinaryExpression
          visit_binary_expression(expression)
        else
          []
        end
      end


      def visit_binary_expression(expression)
        lhs_type = get_type(expression.lhs)
        rhs_type = get_type(expression.rhs)

        errors = []

        unless expression.possible_argument_types.include?(lhs_type)
          errors << Error.new("#{lhs_type} is not a valid argument type for #{expression}, doesn't match any of #{expression.possible_argument_types}.")
        end

        unless expression.possible_argument_types.include?(rhs_type)
          errors << Error.new("#{rhs_type} is not a valid argument type for #{expression}, doesn't match any of #{expression.possible_argument_types}.")
        end

        unless lhs_type == rhs_type
          errors << Error.new("#{lhs_type} doesn't match #{rhs_type} in #{expression}.")
        end

        errors
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
      #
      # def visit_variable(variable)
      #   []
      # end
      #
      # def visit_integer_literal(literal)
      #   []
      # end
      #
      # def visit_boolean_literal(literal)
      #   []
      # end
      #
      # def visit_string_literal(literal)
      #   []
      # end

      def get_type(expression)
        if expression.is_a?(AST::Variable)
          @types[expression.name]
        else
          expression.type
        end
      end
    end
  end
end
