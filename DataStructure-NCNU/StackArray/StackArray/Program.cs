using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace StackArray
{
	class Program
	{
		struct Personal
		{
			public string name;
			public int score;
		};
		static int max_size = 10;
		static int top = 0; 
		static Personal[] MyStack = new Personal[max_size];  

		public static bool IsEmpty()
		{
			if (top == 0)
			    return true;
			else
			    return false;
		}
		public static string pop()
		{
			if (!IsEmpty())
			{
			    top--;
			    return ("\t\t"+MyStack[top].name+"\t\t"+MyStack[top].score); 
			}
			else
			{
			    Console.WriteLine("Stack is empty, can not perform pop operation ....\n");
			    return null;
			}
		}
		public static bool IsFull()
		{
			if (top == max_size)
			    return true;
			else
			    return false;
		}

		public static void push(string n, int s)
		{
			if (!IsFull())
			{
				MyStack[top].name = n; 
				MyStack[top].score = s;
				top++;
			}
			else
				Console.WriteLine("Stack is full, can not push element to the stack ....\n");              
		}

		static void Main(string[] args)
		{
			Random crandom = new Random();

			for (int i = 0; i < 30; i++)
			{
				Console.WriteLine ("\n\n***********第{0}次測試********\n", i+1);
				int ranIndex = crandom.Next(0, 9);
				int ranScore = crandom.Next (1, 100);
				string[] allname = new string[] { "王惠裕", "呂崇珮", "支淑惠", "陳旺燦", "楊台芝", "呂慧萍", "黃姿啟", "王俊緯", "廖郁婷", "張怡慧" };
				if(ranIndex % 2 == 0)
				{
					push(allname[ranIndex], ranScore);
					Console.WriteLine (" n={0}, 是偶數，執行 push 動作 ##########", ranIndex);
					Console.WriteLine("以下資料 push 到 stack ......\n第{0}次\t\t{1}\t\t{2}\n\n", i+1, allname[ranIndex], ranScore);
				}
				else
				{
					Console.WriteLine (" n={0}, 是奇數，執行 pop 動作 @@@@@@@", ranIndex);
					if (!IsEmpty ())
					{
						Console.WriteLine("以下資料 pop 出 stack ......\n第{0}次\t\t{1}", i+1, pop());
					}
				}
				Console.WriteLine ("\n-------印出 stack 所有的內容 ----");
				if (IsEmpty())
					Console.WriteLine ("\n-------目前stack 無內容 ----\n");
				else
				Console.WriteLine ("目前有幾項:{0}", top);

				for (int j = top-1; j >= 0; j--) 
				{
					if (!IsEmpty ())
						Console.WriteLine ("{0}\t\t{1}\t\t{2}", j+1, MyStack [j].name, MyStack [j].score);
				}
			}
		}
	}
}
