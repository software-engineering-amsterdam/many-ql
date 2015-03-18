namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    partial class SectionControl
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

        #region Component Designer generated code

        /// <summary> 
        /// Required method for Designer support - do not modify 
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.SectionBox = new System.Windows.Forms.GroupBox();
            this.QuestionContainer = new System.Windows.Forms.FlowLayoutPanel();
            this.SectionBox.SuspendLayout();
            this.SuspendLayout();
            // 
            // SectionBox
            // 
            this.SectionBox.Controls.Add(this.QuestionContainer);
            this.SectionBox.Dock = System.Windows.Forms.DockStyle.Fill;
            this.SectionBox.Location = new System.Drawing.Point(0, 0);
            this.SectionBox.Name = "SectionBox";
            this.SectionBox.Size = new System.Drawing.Size(610, 390);
            this.SectionBox.TabIndex = 0;
            this.SectionBox.TabStop = false;
            this.SectionBox.Text = "section title";
            // 
            // QuestionContainer
            // 
            this.QuestionContainer.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.QuestionContainer.Dock = System.Windows.Forms.DockStyle.Fill;
            this.QuestionContainer.FlowDirection = System.Windows.Forms.FlowDirection.TopDown;
            this.QuestionContainer.Location = new System.Drawing.Point(3, 16);
            this.QuestionContainer.Name = "QuestionContainer";
            this.QuestionContainer.Size = new System.Drawing.Size(604, 371);
            this.QuestionContainer.TabIndex = 0;
            // 
            // SectionControl
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.SectionBox);
            this.Name = "SectionControl";
            this.Size = new System.Drawing.Size(610, 390);
            this.SectionBox.ResumeLayout(false);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox SectionBox;
        private System.Windows.Forms.FlowLayoutPanel QuestionContainer;
    }
}
