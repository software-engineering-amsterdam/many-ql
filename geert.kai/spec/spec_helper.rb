#require "factory_girl"
#require_relative "support/factory_girl"
#require_relative "factories"

require_relative "../lib/ql"
require "byebug"

include QL::AST
include QL::Checkers
include QL

