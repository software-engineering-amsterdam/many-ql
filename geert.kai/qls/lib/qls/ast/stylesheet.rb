module AST
	class Stylesheet
		attr_reader :name, :defaults

		def initialize(name, stylesheet_rules)
			@name = name
      # Kan die AST:: weg, omdat we in de module AST zelf zitten?
      # @children moet niet @pages zijn?
      # rule.instance_of? En moet dit niet 'netter'?
			@defaults, @children = stylesheet_rules.partition { |rule| rule.class == AST::Default }
		end

		def pages
			@children
		end
	end

	class Page < Stylesheet
		def sections
			@children
		end
	end

	class Section < Stylesheet
		def questions
			@children
		end
	end
end
