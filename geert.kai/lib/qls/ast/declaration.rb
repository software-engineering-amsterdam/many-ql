module QLS
  module AST
    class PropertyDeclaration
      attr_reader :property, :value
      
      def initialize(property, value)
        @property = property
        @value = value
      end

      def accept(visitor)
        self.accept(visitor)
      end
    end

    class Widget
    end

    class Checkbox < Widget
      def widget(controller)
        widget = Java::JavafxSceneControl::CheckBox.new
        widget.selected_property.add_change_listener do |observable, old_value, new_value|
          controller.update_variable(observable.bean.id, new_value)
        end
        widget
      end
    end

    class Spinbox < Widget
      def widget(controller)
        widget = Java::JavafxSceneControl::SpinBox.new
        widget.selected_property.add_change_listener do |observable, old_value, new_value|
          controller.update_variable(observable.bean.id, new_value.to_i)
        end
        widget
      end
    end

    class Text < Widget
      def widget(controller)
        widget = Java::JavafxSceneControl::TextField.new
        widget.text_property.add_change_listener do |observable, old_value, new_value|
          controller.update_variable(observable.bean.id, new_value)
        end
        widget
      end
    end

    class NumberText < Widget
      def widget(controller)
        widget = Java::JavafxSceneControl::TextField.new
        widget.text_property.add_change_listener do |observable, old_value, new_value|
          controller.update_variable(observable.bean.id, new_value.to_i)
        end
        widget
      end
    end

    class YesNoRadio < Widget
      def widget(controller)
        widget = Java::JavafxSceneControl::CheckBox.new
        widget.selected_property.add_change_listener do |observable, old_value, new_value|
          controller.update_variable(observable.bean.id, new_value)
        end
        widget
      end
    end

    class YesNoDropdown < Widget
      def widget(controller)
        widget = Java::JavafxSceneControl::CheckBox.new
        widget.selected_property.add_change_listener do |observable, old_value, new_value|
          controller.update_variable(observable.bean.id, new_value)
        end
        widget
      end
    end
  end
end
