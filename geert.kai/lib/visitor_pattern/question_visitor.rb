require_relative "base_visitor"


module QL
  module VisitorPattern
    class QuestionVisitor < BaseVisitor
      def visit_form(form)
        form.statements.flat_map do |statement|
          visit(statement)
        end
      end

      def visit_if_else(if_else_statement)
        if_else_statement.statements.flat_map do |statement|
          visit(statement)
        end
      end

      def visit_question(question)
        question
      end
    end
  end
end