module AST
	class Stylesheet
		attr_reader :name, :children, :defaults

		def initialize(name, stylesheet_rules)
			@name = name
      # Kan die AST:: weg, omdat we in de module AST zelf zitten?
      # @children moet niet @pages zijn?
			@defaults, @children = stylesheet_rules.partition { |rule| rule.class == AST::Default }
		end

		def pages
			children
		end
	end

	class Page < Stylesheet
		def sections
			children
		end
	end

	class Section < Stylesheet
		def questions
			children
		end
	end
end
