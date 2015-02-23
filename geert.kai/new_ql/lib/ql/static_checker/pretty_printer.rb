require_relative "visitor"
require_relative "../ast/form"

class PrettyPrinter < BaseVisitor
  def visit_form(form)
    "form\n  " + form.accept(self).join
  end

  def visit_question(question)
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
