namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    partial class CheckBoxControl
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
            this.YesCheckBox = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // QuestionLabel
            // 
            this.QuestionLabel.AutoSize = true;
            this.QuestionLabel.Location = new System.Drawing.Point(4, 4);
            this.QuestionLabel.Name = "QuestionLabel";
            this.QuestionLabel.Size = new System.Drawing.Size(55, 13);
            this.QuestionLabel.TabIndex = 0;
            this.QuestionLabel.Text = "Question?";
            // 
            // YesCheckBox
            // 
            this.YesCheckBox.AutoSize = true;
            this.YesCheckBox.Location = new System.Drawing.Point(7, 20);
            this.YesCheckBox.Name = "YesCheckBox";
            this.YesCheckBox.Size = new System.Drawing.Size(44, 17);
            this.YesCheckBox.TabIndex = 1;
            this.YesCheckBox.Text = "Yes";
            this.YesCheckBox.UseVisualStyleBackColor = true;
            this.YesCheckBox.CheckedChanged += new System.EventHandler(this.YesCheckBox_CheckedChanged);
            // 
            // CheckBoxControl
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.Controls.Add(this.YesCheckBox);
            this.Controls.Add(this.QuestionLabel);
            this.Name = "CheckBoxControl";
            this.Size = new System.Drawing.Size(523, 50);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label QuestionLabel;
        private System.Windows.Forms.CheckBox YesCheckBox;
    }
}
