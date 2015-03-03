module QLS
  module AST
    class StyleGroup
      attr_reader :name, :rules

      def initialize(name, rules)
        @name = name
        @rules = rules
      end
    end

    def accept(visitor)
      rules.map do |rule|
        rule.accept(visitor)
      end
    end


    class Stylesheet < StyleGroup
    end

    class Page < StyleGroup
    end

    class Section < StyleGroup
    end
  end
end
