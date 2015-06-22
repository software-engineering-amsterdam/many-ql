require_relative "../util/base_visitor"

module QL
  module Checking
    class Warning
      attr_reader :message

      def initialize(message)
        @message = message
      end
    end

    class Error
      attr_reader :message

      def initialize(message)
        @message = message
      end
    end

    class NoError
    end

    class TypeChecker < BaseVisitor
      def initialize
        @types = {}
      end

      def visit_form(form)
        form.statements.flat_map do |statement|
          visit(statement)
        end
      end

      def visit_question(question)
        if @types[question.variable_name]
          Error.new("Variable #{question.variable_name} already defined")
        else
          @types[question.variable_name] = question.type

          # No errors in this question. #flat_map will remove this empty array.
          []
        end
      end

      # def visit_conditional(conditional)
      #   errors = []
      #   unless valid_conditional_type?(conditional.expression.accept(self))
      #     errors << Error.new("Expression in condition not a boolean: #{conditional}.")
      #   end

      #   conditional.statements.flat_map do |statement|
      #     visit(statement)
      #   end + errors
      # end

      def visit_if_else(if_else)
        visit_if(if_else)
      end

      def visit_if(if_statement)
        type_or_error = if_statement.expression.accept(self)

        if type_or_error.is_a?(Error)
          # Propagate error upwards
          return type_or_error
        else
          if type_or_error == BooleanType.new
            return if_statement.statements.flat_map do |statement|
              statement.accept(self)
            end
          else
            return Error.new("Invalid type in #{if_statement}: #{type_or_error} is not a boolean.")
          end
        end
      end

      def valid_conditional_type?(type)
        type == QL::AST::BooleanType.new || type == QL::AST::UndefinedType.new
      end

      def visit_binary_expression(expression)
        lhs = expression.lhs.accept(self)
        return lhs if lhs.is_a?(Error)

        rhs = expression.rhs.accept(self)
        return rhs if rhs.is_a?(Error)

        lhs_compare = check_expression_type(expression, lhs)
        return lhs_compare if lhs_compare.is_a?(Error)

        rhs_compare = check_expression_type(expression, rhs)
        return rhs_compare if rhs_compare.is_a?(Error)

        expression.type
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


      def check_expression_type(expression, type)
        unless expression.possible_argument_types.include?(type)
          Error.new("#{type} doesn't match any of #{expression.possible_argument_types} in #{expression}.")
        end
      end

      def visit_variable(variable)
        if @types[variable.name].nil?
          Error.new("Variable #{variable.name} not defined.")
        else
          @types[variable.name]
        end
      end

      def visit_integer_literal(literal)
        literal.type
      end

      def visit_boolean_literal(literal)
        literal.type
      end

      def visit_string_literal(literal)
        literal.type
      end
    end
  end
end


