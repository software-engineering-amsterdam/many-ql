require_relative "../../util/base_visitor"
require_relative "../ast/ast"

module QL
  module Checking
    class TypeChecker < BaseVisitor
      def run
        @types = {}
        @errors = []
        visit @base 
        @errors
      end

      def visit_form(form)
        map_accept(form.statements)
      end

      def visit_question(question)
        if @types[question.variable_name]
          @errors << Exception.new("Variable #{question.variable_name} already defined")
        else
          @types[question.variable_name] = question.type
        end
      end

      def visit_conditional(conditional)
        unless valid_conditional_type?(conditional.expression.accept(self))
          @errors << Exception.new("Expression in condition not a boolean: #{conditional}.")
        end

        map_accept(conditional.statements)
      end

      def valid_conditional_type?(type)
        type == QL::AST::BooleanType.new || type.nil?
      end

      def visit_binary_expression(expression)
        lhs_type = expression.lhs.accept(self)
        rhs_type = expression.rhs.accept(self)

        return nil if lhs_type.nil? || rhs_type.nil?

        check_expression_type(expression, lhs_type)
        check_expression_type(expression, rhs_type)

        expression.type
      end

      def check_expression_type(expression, type)
        unless expression.possible_argument_types.include?(type)
          @errors << Exception.new("#{type} doesn't match any of #{expression.possible_argument_types} in #{expression}.")
        end
      end

      def visit_variable(variable)
        @errors << Exception.new("Variable #{variable.name} not defined.") if @types[variable.name].nil?

        @types[variable.name]
      end

      def visit_literal(literal)
        literal.type
      end
    end
  end
end
