using System;
using System.IO;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Input;
using Microsoft.Win32;
using QL.Exceptions;
using QL.Model;
using QL.UI.Controls;

namespace QL.UI
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private string _inputFilePath = null;
        private AstHandler _astHandler = null;

        public static readonly DependencyProperty ShowIdentifiersProperty = DependencyProperty.Register("ShowIdentifiers", typeof(bool), typeof(MainWindow), new PropertyMetadata(true));

        public bool ShowIdentifiers
        {
            get { return (bool)GetValue(ShowIdentifiersProperty); }
            set { SetValue(ShowIdentifiersProperty, value); }
        }

        public MainWindow()
        {
            ApplicationCommands.Close.InputGestures.Add(new KeyGesture(Key.W, ModifierKeys.Control));
            InitializeComponent();
        }

        private void LoadFile()
        {
            if (string.IsNullOrEmpty(_inputFilePath) || !File.Exists(_inputFilePath))
            {
                InputFileSourceText.Text = "File not loaded";
                return;
            }

            using (FileStream fileStream = File.Open(_inputFilePath, FileMode.Open))
            {
                StreamReader sr = new StreamReader(fileStream);
                string inputFileContents = sr.ReadToEnd();
                BuildQuestionnaire(inputFileContents);
            }
        }

        private void BuildQuestionnaire(string inputFileContents)
        {
            InputFileSourceText.Text = inputFileContents;
            _astHandler = new AstHandler(inputFileContents);
            ExceptionTable.ItemsSource = _astHandler.ASTHandlerExceptions;

            if (_astHandler.BuildAST())
            {
                if (_astHandler.CheckType())
                {
                    _astHandler.Evaluate();
                }
            }
        }

        #region Menu event handlers
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

        private void MenuItemOpenExample_Click(object sender, RoutedEventArgs e)
        {
            MenuItem menuItem = sender as MenuItem;
            if (menuItem == null) return;

            _inputFilePath = menuItem.Tag.ToString();
            LoadFile();
        }

        private void Command_Close(object sender, ExecutedRoutedEventArgs e)
        {
            Environment.Exit(0);
        }
        #endregion

        #region General event handlers
        private void MainWindow_OnLoaded(object sender, RoutedEventArgs e)
        {
            string path = Path.Combine(Environment.CurrentDirectory, "examples");
            if (!Directory.Exists(path)) return;

            string[] files = Directory.GetFiles(path, "*.ql", SearchOption.AllDirectories);

            foreach (string file in files)
            {
                MenuItem menuItem = new MenuItem
                                    {
                                        Header = Path.GetFileNameWithoutExtension(file),
                                        Tag = file
                                    };
                menuItem.Click += MenuItemOpenExample_Click;
                MenuItemExamples.Items.Add(menuItem);
            }
            
            if(files.Length <= 0) MenuItemExamples.Visibility = Visibility.Hidden;
        }

        private void ButtonParse_Click(object sender, RoutedEventArgs e)
        {
            if (_astHandler == null) return;
            _astHandler = new AstHandler(InputFileSourceText.Text);
            ExceptionTable.ItemsSource = _astHandler.ASTHandlerExceptions;
            _astHandler.BuildAST();
        }

        private void ButtonTypeCheck_Click(object sender, RoutedEventArgs e)
        {
            if (_astHandler == null) return;
            _astHandler.CheckType();
        }

        private void ButtonEvaluate_Click(object sender, RoutedEventArgs e)
        {
            if (_astHandler == null) return;
            _astHandler.Evaluate();
        }

        private void ExceptionTableItem_MouseClick(object sender, MouseButtonEventArgs e)
        {
            ListViewItem item = sender as ListViewItem;
            if (item == null || !item.IsSelected) return;

            QLException error = item.Content as QLException;
            if (error == null) return;

            InputFileSourceText.TextArea.Caret.Line = error.SourceLocation.Line;
            InputFileSourceText.TextArea.Caret.Column = error.SourceLocation.Column.GetValueOrDefault(0);
            InputFileSourceText.ScrollTo(error.SourceLocation.Line, error.SourceLocation.Column.GetValueOrDefault(0));
            InputFileSourceText.Focus();
        }
        #endregion
    }
}
