require "byebug"

class Preprocessor
  TAB_WIDTH = 2

  attr_reader :lines

  def self.process(path)
    new(path).process
  end

  def initialize(path)
    # We drop the newline characters from the read lines, because
    # we need to insert brackets at line ends.
    @lines = File.readlines(path).map { |line| line.chomp }
  end

  def process
    nesting_depth = 0
    processed_string = indents.each_with_index.with_object([]) do |(indent, index), processed_lines|
      if indent > nesting_depth
        processed_lines[index - 1] += " {"
        nesting_depth += 1
      end
      
      if indent < nesting_depth
        processed_lines << (" "  * TAB_WIDTH) * indent + "}"
        nesting_depth -= 1
      end  

      processed_lines << lines[index] 
    end.join("\n") + "\n"

    (0 ... nesting_depth).reverse_each do |number_of_indents|
      processed_string << (" " * TAB_WIDTH) * number_of_indents + "}\n"
    end

    processed_string
  end

  private

  # Returns an array with the number of indents on each line
  def indents
    lines.map do |line|
      line.chars.take_while { |char| char == " " }.size / TAB_WIDTH
    end
  end 
end
