require_relative "question_visitor"

module QL
  module Checking
    class DuplicateLabelChecker
      def visit(base)
        labels = base.accept(QuestionVisitor.new).map(&:description)
        
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