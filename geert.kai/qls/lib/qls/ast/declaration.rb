
module QLS
  module AST
    class PropertyDeclaration
      attr_reader :property, :value
      
      def initialize(property, value)
        @property = property
        @value = value
      end
    end

    class Widget
    end

    class Checkbox < Widget
    end

    class Spinbox < Widget
    end

    class Text < Widget
    end

    class YesNoRadio < Widget
    end

    class YesNoDropdown < Widget
    end
  end
end
