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

      def visit_question(question)
        []
      end

      def visit_computed_question(computed_question)
        errors = []

        unless get_type(computed_question.expression) == computed_question.type
          errors << Error.new("Invalid type in #{computed_question}: #{get_type(computed_question.expression)} is not a boolean.")
        end

        errors += visit_expression(computed_question.expression)
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

      def visit_variable(variable)
        []
      end

      def visit_literal(literal)
        []
      end

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
