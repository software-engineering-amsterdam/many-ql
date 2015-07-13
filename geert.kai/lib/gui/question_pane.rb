
module QL
  module GUI
    class QuestionPane
      attr_accessor :label, :widget, :question

      def initialize(question, controller)
        @question = question

        @widget = question.type.accept(WidgetVisitor.new(controller))
        @widget.set_id(question.variable_name)

        @label = Java::JavafxSceneControl::Label.new(question.description)
        @label.set_id(question.variable_name)
      end

      def set_visible(visible)
        @widget.set_visible(visible)
        @label.set_visible(visible)
      end
    end
  end
end
