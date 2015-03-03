module QLS
  module AST
    class Declaration
      attr_reader :value
      
      def initialize(value)
        @value = value
      end
    end

    class ColorDeclaration < Declaration
    end

    class FontDeclaration < Declaration
    end

    class FontSizeDeclaration < Declaration
    end

    class WidgetDeclaration < Declaration
    end

    class WidthDeclaration < Declaration
    end
  end
end