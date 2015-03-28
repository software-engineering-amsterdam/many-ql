namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    partial class QuestionFormControl
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
            this.QuestionFlowLayout = new System.Windows.Forms.FlowLayoutPanel();
            this.SuspendLayout();
            // 
            // QuestionFlowLayout
            // 
            this.QuestionFlowLayout.AutoScroll = true;
            this.QuestionFlowLayout.Dock = System.Windows.Forms.DockStyle.Fill;
            this.QuestionFlowLayout.FlowDirection = System.Windows.Forms.FlowDirection.TopDown;
            this.QuestionFlowLayout.Location = new System.Drawing.Point(0, 0);
            this.QuestionFlowLayout.Name = "QuestionFlowLayout";
            this.QuestionFlowLayout.Size = new System.Drawing.Size(779, 416);
            this.QuestionFlowLayout.TabIndex = 0;
            this.QuestionFlowLayout.WrapContents = false;
            // 
            // QuestionFormControl
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.Controls.Add(this.QuestionFlowLayout);
            this.Name = "QuestionFormControl";
            this.Size = new System.Drawing.Size(779, 416);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.FlowLayoutPanel QuestionFlowLayout;
    }
}
