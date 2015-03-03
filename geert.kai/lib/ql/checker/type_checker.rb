require_relative "../../util/base_visitor"
require_relative "../ast/ast"

module QL
  module Checking
    class TypeChecker < BaseVisitor
      def after_initialize(base)
        @types = {}
      end

      def errors
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
        type == BooleanType.new || type == UndefinedType.new
      end

      def visit_binary_expression(expression)
        lhs_type = expression.lhs.accept(self)
        rhs_type = expression.rhs.accept(self)

        return UndefinedType.new if lhs_type == UndefinedType.new || rhs_type == UndefinedType.new


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
        if @types[variable.name]
          @types[variable.name]
        else
          @errors << Exception.new("Variable #{variable.name} not defined.")
          UndefinedType.new
        end
      end

      def visit_literal(literal)
        literal.type
      end
    end
  end
end
