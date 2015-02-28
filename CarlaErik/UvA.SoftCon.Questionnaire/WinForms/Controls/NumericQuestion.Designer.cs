namespace UvA.SoftCon.Questionnaire.WinForms.Controls
{
    partial class NumericQuestion
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
            this.AnswerUpDown = new System.Windows.Forms.NumericUpDown();
            ((System.ComponentModel.ISupportInitialize)(this.AnswerUpDown)).BeginInit();
            this.SuspendLayout();
            // 
            // AnswerUpDown
            // 
            this.AnswerUpDown.Location = new System.Drawing.Point(7, 21);
            this.AnswerUpDown.Name = "AnswerUpDown";
            this.AnswerUpDown.Size = new System.Drawing.Size(274, 20);
            this.AnswerUpDown.TabIndex = 1;
            this.AnswerUpDown.ValueChanged += new System.EventHandler(this.AnswerUpDown_ValueChanged);
            // 
            // NumericQuestion
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.Controls.Add(this.AnswerUpDown);
            this.Name = "NumericQuestion";
            this.Size = new System.Drawing.Size(523, 56);
            this.Controls.SetChildIndex(this.AnswerUpDown, 0);
            ((System.ComponentModel.ISupportInitialize)(this.AnswerUpDown)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.NumericUpDown AnswerUpDown;
    }
}
