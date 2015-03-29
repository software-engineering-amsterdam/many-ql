using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Input;
using Microsoft.Win32;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals;
using QL.Exceptions;
using QL.UI.Builder;
using QL.UI.Controls;
using QL.UI.ControlWrappers;

namespace QL.UI
{
    public partial class MainWindow : Window
    {
        private QLUIBuilder _qlBuilder = null;

        public MainWindow()
        {
            ApplicationCommands.Close.InputGestures.Add(new KeyGesture(Key.W, ModifierKeys.Control));
            InitializeComponent();
        }

        private void BuildQuestionnaire(string inputData)
        {
            _qlBuilder = new QLUIBuilder(inputData);
            ExceptionTable.ItemsSource = _qlBuilder.QLExceptions;
            _qlBuilder.RegisterGenericAndUIDataHandlers();
            bool buildResult = _qlBuilder.RunAllHandlers();
            Debug.WriteLineIf(!buildResult, "Cannot proceed to build the UI as the handlers have failed");

            WidgetsContainer.ItemsSource = _qlBuilder.ElementsToDisplay;
        }

        private void LoadQuestionnaireFile(string inputFilePath)
        {
            if (string.IsNullOrEmpty(inputFilePath) || !File.Exists(inputFilePath))
            {
                InputFileSourceText.Text = "File not loaded";
                return;
            }

            try
            {
                using (FileStream fileStream = File.Open(inputFilePath, FileMode.Open))
                {
                    StreamReader sr = new StreamReader(fileStream);
                    string inputQuestionnaire = sr.ReadToEnd();
                    InputFileSourceText.Text = inputQuestionnaire;
                    BuildQuestionnaire(inputQuestionnaire);
                }
            }
            catch (Exception ex)
            {
                InputFileSourceText.Text = string.Format("An error has occurred whilst reading the input file{0}{1}", Environment.NewLine, ex.Message);
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
                LoadQuestionnaireFile(inputFilePicker.FileName);
            }
        }

        private void MenuItemOpenExample_Click(object sender, RoutedEventArgs e)
        {
            MenuItem menuItem = sender as MenuItem;
            if (menuItem == null) return;
            LoadQuestionnaireFile(menuItem.Tag.ToString());
        }


        private void TestMenuItem_OnClick(object sender, RoutedEventArgs e)
        {
            BindTestData();
        }

        private void Command_Close(object sender, ExecutedRoutedEventArgs e)
        {
            Environment.Exit(0);
        }
        #endregion

        #region General event handlers
        private void MainWindow_OnLoaded(object sender, RoutedEventArgs e)
        {
            PopulateExampleFileMenu();
        }

        private void ButtonParse_Click(object sender, RoutedEventArgs e)
        {
            if (_qlBuilder == null) return;
            _qlBuilder = new QLUIBuilder(InputFileSourceText.Text);
            ExceptionTable.ItemsSource = _qlBuilder.QLExceptions;
            _qlBuilder.RunInit();
            _qlBuilder.RunASTBuilders();
        }

        private void ButtonTypeCheck_Click(object sender, RoutedEventArgs e)
        {
            if (_qlBuilder == null) return;
            _qlBuilder.RunTypeCheckers();
        }

        private void ButtonEvaluate_Click(object sender, RoutedEventArgs e)
        {
            if (_qlBuilder == null) return;
            _qlBuilder.RunEvaluators();
        }

        private void ButtonBuild_Click(object sender, RoutedEventArgs e)
        {
            if (_qlBuilder == null) return;
            _qlBuilder.RunRenderers();
        }

        private void ExceptionTableItem_MouseClick(object sender, MouseButtonEventArgs e)
        {
            ListViewItem item = sender as ListViewItem;
            if (item == null || !item.IsSelected) return;

            QLBaseException error = item.Content as QLBaseException;
            if (error == null) return;

            InputFileSourceText.TextArea.Caret.Line = error.SourceLocation.Line;
            InputFileSourceText.TextArea.Caret.Column = error.SourceLocation.Column.GetValueOrDefault(0);
            InputFileSourceText.ScrollTo(error.SourceLocation.Line, error.SourceLocation.Column.GetValueOrDefault(0));
            InputFileSourceText.Focus();
        }
        #endregion

        #region Dependency properties
        public static readonly DependencyProperty ShowIdentifiersProperty = DependencyProperty.Register("ShowIdentifiers", typeof(bool), typeof(MainWindow), new PropertyMetadata(true));

        public bool ShowIdentifiers
        {
            get { return (bool)GetValue(ShowIdentifiersProperty); }
            set { SetValue(ShowIdentifiersProperty, value); }
        }
        #endregion

        private void PopulateExampleFileMenu()
        {
            string path = Path.Combine(Environment.CurrentDirectory, "examples");
            if (!Directory.Exists(path))
            {
                return;
            }

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

            if (files.Length <= 0)
            {
                MenuItemExamples.Visibility = Visibility.Hidden;
            }
        }

        private void BindTestData()
        {
            WidgetFactory factory = new WidgetFactory();
            List<WidgetBase> renders = new List<WidgetBase>
                                        {
                                            factory.GetWidget(new QuestionUnit(new Identifier("Question1"), new Text(), "What is your name?")),
                                            factory.GetWidget(new QuestionUnit(new Identifier("Question2"), new Number(), "What is your age?")),
                                            factory.GetWidget(new QuestionUnit(new Identifier("Question3"), new Yesno(), "Are you studying?")),
                                        };

            WidgetsContainer.Items.Clear();
            WidgetsContainer.ItemsSource = renders;
        }
    }
}
