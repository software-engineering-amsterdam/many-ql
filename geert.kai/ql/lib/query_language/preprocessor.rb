# The preprocessor converts whitespace sensitive input to a normalized form with brackets.
# Example of a one query form:
#
# form
#   "What's your name?"
#     name: string
#
# Becomes:
#
# form {
#   "What's your name?" {
#     name: string
#   }
# }
# 
# The only function needed is Preprocessor.process(path)
#
# TODO:
#   - Give valuable error response when indentation is not correct
#     (other syntax errors can only be handled after parsing?)
#   - Empty form doesn't yet work.

require "byebug"

class Preprocessor
  INDENT_WIDTH = 2

  attr_reader :lines

  def self.process(path)
    new(path).process
  end

  def initialize(path)
    # We drop the newline characters from each line, because
    # we need to insert brackets at line ends.
    @lines = File.readlines(path).map { |line| line.chomp }
  end

  def process
    nesting_depth = 0
    processed_string = indents.each_with_index.with_object([]) do |(indent, index), processed_lines|
      # Remove empty lines from the processed string.
      # Does this make it harder to map back to line numbers when we find a syntax error?
      next if lines[index].strip.empty?

      if indent > nesting_depth
        processed_lines[index - 1] += " {"
        nesting_depth += 1
      end
      
      if indent < nesting_depth
        processed_lines << (" "  * INDENT_WIDTH) * indent + "}"
        nesting_depth -= 1
      end  

      processed_lines << lines[index] 
    end.join("\n") + "\n"

    # Add additional brackets at the end of the file for the remaining nesting depth.
    # (For example, if a file ends with a nesting depth of two, we need two lines, each with 
    # a bracket at the correct indentation level.)
    (0 ... nesting_depth).reverse_each do |number_of_indents|
      processed_string << (" " * INDENT_WIDTH) * number_of_indents + "}\n"
    end

    processed_string
  end
  
  private

  # Returns an array with the number of indents on each line
  def indents
    lines.map do |line|
      line.chars.take_while { |char| char == " " }.size / INDENT_WIDTH
    end
  end 
end
