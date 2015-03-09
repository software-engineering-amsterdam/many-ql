import os


class Config:
    real_path = os.path.dirname(os.path.realpath(__file__))
    input_path = real_path + "/example.ql"
    output_path = real_path + "/answers.xml"