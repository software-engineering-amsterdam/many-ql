module QL
  module GUI
    class WidgetVisitor < VisitorPattern::BaseVisitor
      def initialize(controller)
        @controller = controller
      end

      def visit_integer_type(type)
        widget = Java::JavafxSceneControl::TextField.new
        widget.text_property.add_change_listener do |observable, old_value, new_value|
          @controller.update_variable(observable.bean.id, new_value.to_i)
        end
        widget
      end

      def visit_string_type(type)
        widget = Java::JavafxSceneControl::TextField.new
        widget.text_property.add_change_listener do |observable, old_value, new_value|
          @controller.update_variable(observable.bean.id, new_value)
        end
        widget
      end

      def visit_boolean_type(type)
        widget = Java::JavafxSceneControl::CheckBox.new
        widget.selected_property.add_change_listener do |observable, old_value, new_value|
          @controller.update_variable(observable.bean.id, new_value)
        end
        widget
      end
    end
  end
end