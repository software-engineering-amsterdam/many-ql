module QLS
  class StyleWriter < BaseVisitor
    def run
      @classes = []
      data = visit(@base)
      File.write('temp/stylesheets/style.css', data)
    end

    def visit_style_group(section)
      name = "#{section.class.to_s.snake_case}_#{section.object_id}"
      
      @classes.push(name)
      result = map_accept(section.rules)
      @classes.pop

      result*""
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