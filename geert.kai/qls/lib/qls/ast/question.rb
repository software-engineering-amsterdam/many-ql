module AST
	class Question
		attr_reader :name, :rules

		def initialize(name, rules)
			@name = name
			@rules = rules
		end
	end

	class Default < Question

	end
end