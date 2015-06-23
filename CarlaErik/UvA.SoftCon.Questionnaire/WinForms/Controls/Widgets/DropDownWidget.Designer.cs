namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    partial class DropDownWidget
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
            this.YesNoDropDownBox = new System.Windows.Forms.ComboBox();
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
            // YesNoDropDownBox
            // 
            this.YesNoDropDownBox.FormattingEnabled = true;
            this.YesNoDropDownBox.Items.AddRange(new object[] {
            "Yes",
            "No"});
            this.YesNoDropDownBox.Location = new System.Drawing.Point(7, 21);
            this.YesNoDropDownBox.Name = "YesNoDropDownBox";
            this.YesNoDropDownBox.Size = new System.Drawing.Size(121, 21);
            this.YesNoDropDownBox.TabIndex = 1;
            this.YesNoDropDownBox.SelectedValueChanged += new System.EventHandler(this.YesNoDropDownBox_SelectedValueChanged);
            // 
            // DropDownWidget
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.Controls.Add(this.YesNoDropDownBox);
            this.Controls.Add(this.QuestionLabel);
            this.Name = "DropDownWidget";
            this.Size = new System.Drawing.Size(640, 50);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label QuestionLabel;
        private System.Windows.Forms.ComboBox YesNoDropDownBox;
    }
}
