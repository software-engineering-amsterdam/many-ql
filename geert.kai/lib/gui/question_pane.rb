
module QL
  module GUI
    class QuestionPane
      attr_accessor :label, :widget, :question

      def initialize(question, controller)
        @controller = controller
        @question = question

        @label = Java::JavafxSceneControl::Label.new(question.description)

        if question.kind_of? QL::AST::ComputedQuestion
          @widget = Java::JavafxSceneControl::Label.new("")
        else
          @widget = visit_type(question.type)
          @widget.set_id(question.variable_name)
          @label.set_id(question.variable_name)
        end
      end

      def visit_type(type)
        if type.kind_of?(QL::AST::StringType)
          widget = Java::JavafxSceneControl::TextField.new
          widget.text_property.add_change_listener do |observable, old_value, new_value|
            @controller.update_variable(observable.bean.id, new_value)
          end
          widget
        elsif type.kind_of?(QL::AST::IntegerType)
          widget = Java::JavafxSceneControl::TextField.new
          widget.text_property.add_change_listener do |observable, old_value, new_value|
            @controller.update_variable(observable.bean.id, new_value.to_i)
          end
          widget
        elsif type.kind_of?(QL::AST::BooleanType)
          widget = Java::JavafxSceneControl::CheckBox.new
          widget.selected_property.add_change_listener do |observable, old_value, new_value|
            @controller.update_variable(observable.bean.id, new_value)
          end
          widget
        end
      end

      def set_visible(visible)
        @widget.set_visible(visible)
        @label.set_visible(visible)
      end

      def recalculate(values)
        @widget.set_text(question.expression.accept(ExpressionEvaluator.new(values)).to_s)
      end
    end
  end
end
