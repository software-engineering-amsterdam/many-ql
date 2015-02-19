require_relative "visitor"

class StaticChecker < BaseVisitor
  def initialize(form)
    @form = form
    after_initialize(form)
  end

  def after_initialize(form)
  end

  private

  attr_reader :form
end
