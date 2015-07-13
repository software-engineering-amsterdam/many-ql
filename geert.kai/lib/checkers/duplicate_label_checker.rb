
require_relative "../visitor_pattern/question_visitor"
require_relative "errors"

module QL
  module Checkers
    class DuplicateLabelChecker
      # gedraagt zich als een visitor

      def visit(base)
        labels = base.accept(VisitorPattern::QuestionVisitor.new).map(&:description)

        duplicates(labels).map { |label| Error.new("Duplicate label: #{label}.") }
      end

      def duplicates(array)
        array.each_with_object({}) do |element, counts|
          counts[element] = counts.fetch(element, 0) + 1
        end.select { |element, count| count > 1}.keys
      end
    end
  end
end
