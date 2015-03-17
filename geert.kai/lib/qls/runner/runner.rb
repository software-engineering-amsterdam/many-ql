require_relative "../../util/base_visitor"

module QLS
  class Runner < QL::Runner
    def initialize(ql_base, qls_base)
      super(ql_base)

      @renderers = RendererVisitor.run(qls_base, @renderers)
      StyleVisitor.run(qls_base)
    end
  end

  class RendererVisitor < BaseVisitor
    attr_reader :classes

    def run(renderers)
      @classes = []
      
      @question_hash = renderers.map { |renderer| [renderer.question.variable_name,  renderer] }.to_h
      visit(@base).flatten
    end

    def visit_style_group(section)
      name = "#{section.class.to_s.snake_case}_#{section.object_id}"
      
      @classes.push(name)
      map = map_accept(section.rules)
      @classes.pop

      map
    end

    def visit_question(question)
      renderer = @question_hash[question.name]
      renderer.classes = @classes.clone
      renderer
    end

    def visit_default(default)
      []
    end
  end

  class StyleVisitor < BaseVisitor
    def run
      @classes = []
      data = visit(@base)
      File.write('temp/stylesheets/style.css', data)
    end

    def visit_style_group(section)
      name = "#{section.class.to_s.snake_case}_#{section.object_id}"
      
      @classes.push(name)
      result = map_accept(section.rules)*""
      @classes.pop

      result
    end

    def visit_question(question)
      ""
    end

    def visit_default(default)
      ".#{@classes.last}.#{default.type.name} {" +
      default.declarations.map(&:to_css)*"" + "\n}\n"
    end
  end
end