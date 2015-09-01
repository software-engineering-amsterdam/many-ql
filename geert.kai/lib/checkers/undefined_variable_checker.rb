require_relative "errors"

module QL
  module Checkers
    class UndefinedVariableChecker < VisitorPattern::BaseVisitor
      def visit_form(form)
        @variable_names = form.accept(VisitorPattern::QuestionVisitor.new).map(&:variable_name)

        form.statements.flat_map do |statement|
          visit_statement(statement)
        end
      end

      def visit_question(question)
        []
      end

      def visit_computed_question(computed_question)
        visit_expression(computed_question.expression)
      end

      def visit_if_else(if_else)
        errors = []

        errors += visit_expression(if_else.expression)

        errors += if_else.statements.flat_map do |statement|
          visit_statement(statement)
        end
      end

      def visit_binary_expression(expression)
        [ visit_expression(expression.lhs), visit_expression(expression.rhs) ].flatten
      end


      def visit_variable(variable)
        if @variable_names.include?(variable.name)
          []
        else
          [ Error.new("#{variable.name} is not defined.") ]
        end
      end

      def visit_literal(literal)
        []
      end
    end
  end
end
