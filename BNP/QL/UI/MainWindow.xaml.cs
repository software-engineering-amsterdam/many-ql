using System;
using System.IO;
using System.Windows;
using System.Windows.Input;
using Microsoft.Win32;
using QL.UI.Controls;

namespace QL.UI
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private string _inputFilePath = null;

        public MainWindow()
        {
            InitializeComponent();
        }

        private void LoadFile()
        {
            if (string.IsNullOrEmpty(_inputFilePath) || !File.Exists(_inputFilePath))
            {
                InputFileSourceText.Text = "File not loaded";
                return;
            }

            var fs = File.Open(_inputFilePath, FileMode.Open);
            StreamReader sr = new StreamReader(fs);
            InputFileSourceText.Text = sr.ReadToEnd();

            QuestionsPanel.Children.Add(new UnitControl());
            QuestionsPanel.Children.Add(new UnitControl());
            QuestionsPanel.Children.Add(new UnitControl());
        }

        private void Command_Close(object sender, ExecutedRoutedEventArgs e)
        {
            Environment.Exit(0);
        }

        private void Command_Open(object sender, ExecutedRoutedEventArgs e)
        {
            OpenFileDialog inputFilePicker = new OpenFileDialog
                                             {
                                                 Multiselect = false,
                                                 AddExtension = true,
                                                 CheckFileExists = true,
                                                 Filter = "QL Files|*.ql|All files|*.*",
                                                 InitialDirectory = Environment.CurrentDirectory
                                             };

            if (inputFilePicker.ShowDialog().GetValueOrDefault())
            {
                _inputFilePath = inputFilePicker.FileName;
                LoadFile();
            }
        }
    }
}
