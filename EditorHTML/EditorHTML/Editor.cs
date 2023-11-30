using EditorHtml;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace EditorHTML
{
    public static class Editor
    {
        public static void Show()
        {
            Console.Clear();
            //Console.BackgroundColor = ConsoleColor.White;
            //Console.ForegroundColor = ConsoleColor.Black;
            Console.Clear();
            Console.WriteLine("MODO EDITOR");
            Console.WriteLine("-----------");
            Start();
        }

        public static void Start()
        {
            var file = new StringBuilder();
            do
            {
                file.Append(Console.ReadLine());
                file.Append(Environment.NewLine);
            } while (Console.ReadKey().Key != ConsoleKey.Escape);
            Console.WriteLine("-----------");
            Console.WriteLine(" Deseja salvar o arquivo?");
            Save(file.ToString());
        }

        public static void Save(string file)
        {
            Console.Clear();
            Console.WriteLine("Qual caminho deseja salvar o arquivo?");
            Viewer.Show(file.ToString());
            var path = Console.ReadLine();

            using (var text = new StreamWriter(path))
            {
                text.Write(file);
            }
            Console.WriteLine($"O arquivo foi salvo no caminho: {path}");
            Console.ReadLine();
            Menu.Show();
        }

    }
}
