require_relative "../../util/base_visitor"

module QLS
  class Runner < QL::Runner
    def initialize(ql_ast, qls_ast)
      super(ql_ast)

      @renderers = RendererVisitor.new(qls_ast, @renderers).styled_renderers
      StyleVisitor.new(qls_ast, @renderers).styled_renderers
    end
  end

  class RendererVisitor < BaseVisitor
    attr_reader :classes
    def initialize(base, renderers)
      @base = base
      @question_hash = {}
      renderers.each do |renderer|
        @question_hash[renderer.question.variable_name] = renderer
      end

      @classes = []
    end

    def styled_renderers
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
    def initialize(base, renderers)
      @base = base
      @classes = []
    end

    def styled_renderers
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