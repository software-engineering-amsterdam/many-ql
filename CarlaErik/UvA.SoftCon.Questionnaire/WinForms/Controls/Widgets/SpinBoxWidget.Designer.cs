namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    partial class SpinBoxWidget
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
            this.AnswerUpDown = new System.Windows.Forms.NumericUpDown();
            ((System.ComponentModel.ISupportInitialize)(this.AnswerUpDown)).BeginInit();
            this.SuspendLayout();
            // 
            // QuestionLabel
            // 
            this.QuestionLabel.AutoSize = true;
            this.QuestionLabel.Location = new System.Drawing.Point(4, 4);
            this.QuestionLabel.Name = "QuestionLabel";
            this.QuestionLabel.Size = new System.Drawing.Size(55, 13);
            this.QuestionLabel.TabIndex = 2;
            this.QuestionLabel.Text = "Question?";
            // 
            // AnswerUpDown
            // 
            this.AnswerUpDown.Location = new System.Drawing.Point(7, 20);
            this.AnswerUpDown.Maximum = new decimal(new int[] {
            1000000,
            0,
            0,
            0});
            this.AnswerUpDown.Minimum = new decimal(new int[] {
            1000000,
            0,
            0,
            -2147483648});
            this.AnswerUpDown.Name = "AnswerUpDown";
            this.AnswerUpDown.Size = new System.Drawing.Size(105, 20);
            this.AnswerUpDown.TabIndex = 1;
            this.AnswerUpDown.ValueChanged += new System.EventHandler(this.AnswerUpDown_ValueChanged);
            // 
            // SpinBoxWidget
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.Controls.Add(this.QuestionLabel);
            this.Controls.Add(this.AnswerUpDown);
            this.Name = "SpinBoxWidget";
            this.Size = new System.Drawing.Size(640, 50);
            ((System.ComponentModel.ISupportInitialize)(this.AnswerUpDown)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.NumericUpDown AnswerUpDown;
        private System.Windows.Forms.Label QuestionLabel;
    }
}
