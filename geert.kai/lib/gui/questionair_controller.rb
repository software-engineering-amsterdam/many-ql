require_relative "question_pane"

module QL
  module GUI
    class QuestionairController
      attr_reader :question_panes, :scene

      def initialize(ql)
        @ql = ql
        @user_input = {}

        @question_panes = ql.accept(QL::VisitorPattern::QuestionVisitor.new).map do |question|
          QuestionPane.new(question, self)
        end
      end

      def update_variable(variable_name, value)
        @user_input[variable_name] = value
        
        reload
      end

      def visible_questions
        @ql.accept(VisibilityVisitor.new(@user_input))
      end

      # niet mooi
      def scene=(scene)
        @scene = scene
        reload
      end

      def reload
        current_questions = visible_questions

        @question_panes.each do |pane|
          pane.set_visible(current_questions.include?(pane.question))
        end
      end
    end
  end
end