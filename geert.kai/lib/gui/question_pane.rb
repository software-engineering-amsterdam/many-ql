
module QL
  module GUI
    class QuestionPane #QuestionPane kunnen we uit het programma schrijven alles gaat via css
      attr_accessor :label, :widget, :question

      def initialize(question, controller)
        @question = question

        @widget = question.type.accept(WidgetVisitor.new(controller))
        @widget.set_id(question.variable_name)

        @label = Java::JavafxSceneControl::Label.new(question.description)
        @label.set_id(question.variable_name)
      end

      def set_visible(boolean)
        @widget.set_visible(boolean)
        @label.set_visible(boolean)
      end
    end
  end
end
