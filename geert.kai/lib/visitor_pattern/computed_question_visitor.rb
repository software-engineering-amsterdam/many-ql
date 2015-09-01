require_relative "base_visitor"


module QL
  module VisitorPattern
    class ComputedQuestionVisitor < BaseVisitor
      def visit_form(form)
        form.statements.map do |statement|
          visit_statement(statement)
        end.flatten
      end

      def visit_question(question)
        question
      end

      def visit_computed_question(computed_question)
        computed_question
      end

      def visit_if_else(if_else_statement)
        if_else_statement.statements.map do |statement|
          visit_statement(statement)
        end.flatten
      end
    end
  end
end
