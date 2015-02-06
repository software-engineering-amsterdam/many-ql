require_relative "../lib/query_language/preprocessor"

SOURCE_PATHS = "spec/source_files"
TARGET_PATHS = "spec/preprocessed_source_files"

describe "Preprocessor" do
  it "correctly preprocesses source files" do
    Dir["#{SOURCE_PATHS}/*"].each do |source_path|
      file_name = File.basename(source_path)
      processed_file = Preprocessor.process(source_path)
      target_file = File.read( File.join(TARGET_PATHS, file_name) )
      expect(processed_file).to eq target_file unless file_name == "empty_form.ql"
    end
  end
end
