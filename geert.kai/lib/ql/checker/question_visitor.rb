require_relative "../../util/base_visitor"
require_relative "../../util/array"


module QL
  module Checking
    class QuestionVisitor < BaseVisitor
      def questions
        (visit @base).flatten
      end

      def visit_form(form)
        map_accept(form.statements)
      end

      def visit_conditional(condition)
        map_accept(condition.statements)
      end

      def visit_question(question)
        question
      end
    end

    class DuplicateLabelChecker
      def initialize(base)
        @base = base
      end
      
      def errors
        labels = QuestionVisitor.new(@base).questions.map(&:description)
        labels.duplicates.map { |label| Exception.new("Duplicate label: #{label}.") }
      end
    end
  end
end
