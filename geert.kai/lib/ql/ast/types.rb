module QL
  module AST
    class Type
      def ==(other_type)
        self.class == other_type.class
      end
    end

    class IntegerType < Type
      def pane(question, questionair_controller)
        input = Java::JavafxSceneControl::TextField.new
        input.set_id(question.variable_name)
        input.text_property.add_change_listener do |observable, old, new_value|
          questionair_controller.update_variable(observable.bean.id, new_value.to_i)
        end
        input
      end
    end

    class StringType < Type
      def pane(question, questionair_controller, widget = nil)
        input = widget || Java::JavafxSceneControl::TextField.new
        input.set_id(question.variable_name)
        input.text_property.add_change_listener do |observable, old, new_value|
          questionair_controller.update_variable(observable.bean.id, new_value)
        end
        input
      end
    end

    class BooleanType < Type
      def pane(question, questionair_controller)
        input = Java::JavafxSceneControl::CheckBox.new
        input.set_id(question.variable_name)
        input.selected_property.add_change_listener do |observable, old, new_value|
          questionair_controller.update_variable(observable.bean.id, new_value)
        end
        input
      end
    end

    class UndefinedType < Type
    end
  end
end