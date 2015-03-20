namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    partial class CalendarControl
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.QuestionLabel = new System.Windows.Forms.Label();
            this.AnswerDatePicker = new System.Windows.Forms.DateTimePicker();
            this.SuspendLayout();
            // 
            // QuestionLabel
            // 
            this.QuestionLabel.AutoSize = true;
            this.QuestionLabel.Location = new System.Drawing.Point(4, 0);
            this.QuestionLabel.Name = "QuestionLabel";
            this.QuestionLabel.Size = new System.Drawing.Size(55, 13);
            this.QuestionLabel.TabIndex = 0;
            this.QuestionLabel.Text = "Question?";
            // 
            // AnswerDatePicker
            // 
            this.AnswerDatePicker.CustomFormat = "dd-MM-yyyy";
            this.AnswerDatePicker.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.AnswerDatePicker.Location = new System.Drawing.Point(7, 16);
            this.AnswerDatePicker.Name = "AnswerDatePicker";
            this.AnswerDatePicker.Size = new System.Drawing.Size(97, 20);
            this.AnswerDatePicker.TabIndex = 1;
            this.AnswerDatePicker.ValueChanged += new System.EventHandler(this.AnswerDatePicker_ValueChanged);
            // 
            // CalendarControl
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.Controls.Add(this.AnswerDatePicker);
            this.Controls.Add(this.QuestionLabel);
            this.Name = "CalendarControl";
            this.Size = new System.Drawing.Size(523, 50);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label QuestionLabel;
        private System.Windows.Forms.DateTimePicker AnswerDatePicker;
    }
}
