namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int idadeGio = 19;
            int idadeBio = 20;
            int idadeMio = 21;
            string idadeMed = ($"A média é: {idadeBio + idadeMio + idadeGio / 3}");

            MessageBox.Show(idadeMed);

        }

        private void button2_Click(object sender, EventArgs e)
        {
            double saldo = 100.0;
            double valorSaque = 10.0;
            if (saldo >= valorSaque)
            {
                saldo = saldo - valorSaque;
                MessageBox.Show("Saque realizado com sucesso!");
            }
            else
            {
                MessageBox.Show("O saque falhou.");
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            double pi = 3.14;
            int piQuebrado = (int)pi;
            MessageBox.Show("piQuebrado =" + piQuebrado);
        }
    }
}