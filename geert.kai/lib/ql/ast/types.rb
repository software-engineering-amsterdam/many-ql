require_relative "../../qls/ast/declaration"

module QL
  module AST
    class Type
      def ==(other_type)
        self.class == other_type.class
      end
    end

    class IntegerType < Type
      def widget(controller)
        QLS::AST::NumberText.new.widget(controller)
      end

      def name
        "integer"
      end
    end

    class StringType < Type
      def widget(controller)
        QLS::AST::Text.new.widget(controller)
      end

      def name
        "string"
      end
    end

    class BooleanType < Type
      def widget(controller)
        QLS::AST::YesNoRadio.new.widget(controller)
      end
      
      def name
        "boolean"
      end
    end
  end
end