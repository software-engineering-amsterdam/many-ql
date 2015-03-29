
import os

def formFilePath(filename):
  currentDir = os.path.dirname(os.path.abspath(__file__))
  return os.path.join(currentDir, "forms", filename)
