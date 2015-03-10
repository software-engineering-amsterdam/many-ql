module QLS
  module Checking
    class QuestionReferenceChecker
      def initialize(qls, ql)
        @qls_question_names = QLS::Checking::QuestionVisitor.new(qls).questions.map(&:name)
        @ql_question_names  = QL::Checking::QuestionVisitor.new(ql).questions.map(&:variable_name)
      end

      def errors
        (@qls_question_names - @ql_question_names).map do |name|
          Exception.new("#{name} found in QLS, but not in QL.")
        end +
        (@ql_question_names - @qls_question_names).map do |name|
          Exception.new("#{name} found in QL, but not in QLS.")
        end
      end
    end
  end
end
