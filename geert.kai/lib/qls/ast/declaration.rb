module QLS
  module AST
    class PropertyDeclaration
      attr_reader :value
      
      def initialize(value)
        @value = value
      end

      def to_css
        "\n\t#{property}: #{value}"
      end
    end

    class FontSizeProperty < PropertyDeclaration
      def to_css
        "\n\t-fx-font-size: #{value.to_s}px;"
      end
    end

    class FontColorProperty < PropertyDeclaration
      def to_css
        "\n\t-fx-color: #{value.to_s};"
      end
    end

    class FontProperty < PropertyDeclaration
      def to_css
        "\n\t-fx-font-family: \"#{value.to_s}\";"
      end
    end

    class Widget
      def to_css
        ""
      end
    end

    class Checkbox < Widget
      def widget(controller)
        widget = Java::JavafxSceneControl::CheckBox.new
        widget.selected_property.add_change_listener do |observable, old_value, new_value|
          controller.update_variable(observable.bean.id, new_value)
        end
        
        widget
      end

      def name
        "checkbox"
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

      def name
        "spinbox"
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

      def name
        "text"
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

      def name
        "number_text"
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

      def name
        "yes_no_radio"
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

      def name
        "yes_no_dropdown"
      end
    end
  end
end
