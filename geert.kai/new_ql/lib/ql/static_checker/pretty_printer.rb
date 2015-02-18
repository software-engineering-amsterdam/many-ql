require_relative "visitor"
require_relative "../ast/form"

class PrettyPrinter < BaseVisitor
  visitor_for Form do |form|
    "form\n  " + form.accept(self).join
  end

  visitor_for Question do |question|
    "question\n"
  end

  def self.show(tree)
    new(tree).show
  end

  def initialize(tree)
    @tree = tree
  end

  def show
    visit @tree
  end
end
