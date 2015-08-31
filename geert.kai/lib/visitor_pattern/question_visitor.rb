require_relative "base_visitor"


module QL
  module VisitorPattern
    class QuestionVisitor < BaseVisitor
      def visit_form(form)
        form.statements.map do |statement|
          visit_statement(statement)
        end.flatten
      end

      def visit_statement(statement)
        if statement.class == QL::AST::Question
          visit_question(statement)
        else
          visit_if_else(statement)
        end
      end

      def visit_if_else(if_else_statement)
        if_else_statement.statements.map do |statement|
          visit_statement(statement)
        end.flatten
      end

      def visit_question(question)
        question
      end
    end
  end
end
