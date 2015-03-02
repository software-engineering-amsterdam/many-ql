module AST
	class Stylesheet
		attr_reader :name, :children, :defaults

		def initialize(name, stylesheet_rules)
			@name = name
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
	


	class Question
		attr_reader :name, :rules

		def initialize(name, rules)
			@name = name
			@rules = rules
		end
	end

	class Default < Question

	end



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

	class WidgitDeclaration < Declaration
	end

	class WidthDeclaration < Declaration
	end

end