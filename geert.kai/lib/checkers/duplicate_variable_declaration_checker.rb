require_relative "errors"

module QL
  module Checkers
    class DuplicateVariableDeclarationChecker
      def visit(form)
        variable_names = form.accept(VisitorPattern::QuestionVisitor.new).map(&:variable_name)
        duplicates(variable_names).map { |name| Error.new("Duplicate variable declaration: #{name}.") }
      end

      def duplicates(array)
        array.each_with_object({}) do |element, counts|
          counts[element] = counts.fetch(element, 0) + 1
        end.select { |element, count| count > 1}.keys
      end
    end
  end
end
