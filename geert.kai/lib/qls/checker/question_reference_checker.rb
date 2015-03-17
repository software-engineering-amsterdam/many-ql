module QLS
  module Checking
    class QuestionReferenceChecker
      def self.run(qls, ql)
        @qls_question_names = QLS::Checking::QuestionVisitor.run(qls).map(&:name)
        @ql_question_names  =  QL::Checking::QuestionVisitor.run(ql ).map(&:variable_name)

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
