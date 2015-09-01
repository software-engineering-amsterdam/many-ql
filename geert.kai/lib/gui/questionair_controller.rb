require_relative "question_pane"

module QL
  module GUI
    class QuestionairController
      attr_reader :question_panes, :scene

      def initialize(ql)
        @ql = ql
        @user_input = {}

        @question_panes = ql.accept(QL::VisitorPattern::ComputedQuestionVisitor.new).map do |question|
          QuestionPane.new(question, self)
        end

        @computed_question_panes = @question_panes.select { |pane| pane.question.kind_of? QL::AST::ComputedQuestion }
      end

      def update_variable(variable_name, value)
        @user_input[variable_name] = value

        reload
      end

      def scene=(scene)
        @scene = scene

        reload
      end

      def reload
        visible_questions = @ql.accept(VisibilityVisitor.new(@user_input))
        puts @user_input
        puts visible_questions.map(&:description)

        @question_panes.each do |pane|
          pane.set_visible(visible_questions.include?(pane.question))
        end

        @computed_question_panes.each do |pane|
          pane.recalculate(@user_input)
        end
      end
    end
  end
end
