module QL
  module Checking
    class QuestionVisitor < BaseVisitor
      def questions
        visit @base
      end

      def visit_form(form)
        map_accept(form.statements).flatten
      end

      def visit_conditional(condition)
        map_accept(condition.statements).flatten
      end

      def visit_question(question)
        question
      end
    end
  end
end
