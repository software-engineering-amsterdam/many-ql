require_relative '../../util/base_visitor'

module QLS
  module Checker
    class QuestionVisitor < BaseVisitor
      def questions
        visit(@base).flatten
      end

      def visit_style_group(style_group)
        map_accept(style_group.rules)
      end

      def visit_question(question)
        question
      end

      def visit_default(default)
        []
      end
    end

    class DuplicateQuestionChecker
      def initialize(base)
        @base = base
      end

      def errors
        duplicates = QuestionVisitor.new(@base).questions.map(&:name).duplicates
        duplicates.map { |name| Exception.new("Question #{name} is defined more than once.") }
      end
    end
  end
end
