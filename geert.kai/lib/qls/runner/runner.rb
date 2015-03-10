require_relative "../util/base_visitor"

module QLS
  class Runner < BaseVisitor

    def visit_stylesheet(stylesheet)
      map_accept(stylesheet.rules)
    end

    def visit_page(page)
      map_accept(page.rules)
    end

    def visit_section(section)
      map_accept(section.rules).flatten.each do |question|
        @defaults.each do |default|
          question.add_style(default) if default.type == question.type
        end
      end
    end

    def visit_question(question)
      question
    end

    def visit_default(default)
      @defaults << default
      []
    end
  end
end