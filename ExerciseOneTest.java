import java.util.Scanner;

public class ExerciseOneTest {

	public static void main(String[] args) {
		Scanner read=new Scanner(System.in);
		int row=0;
		int column=0;
		int choice=4;
		ChoiceOne choices= new ChoiceOne(row,column);
		loop:while(choice!=5)
		{
			switch(choice)
			{
				case 1:
						System.out.print("Enter you want to search: ");
						String searchStr=read.next();
						choices.search(searchStr);
						break;
				case 2:
						int rowedit=0,columnedit=0;
						rowedit=getRow(0,row-1);
						columnedit=getColumn(0,column-1);
						String insert=" ";
						while(insert.length()!=3||insert.contains("\t")||insert.contains(" ")){
							System.out.println("Enter character: (No Space,No Tab,3 characters) :");
							insert=read.nextLine();
						}
						choices.edit(rowedit,columnedit,insert);
						break;
				case 3:
						choices.print();
						break;
				case 4:
						row=getRow(1,9);
						column=getColumn(1,9);
						choices.reset(row,column);
						break;
				case 5:
						break loop;
				default:
						break;
			}
			choice=getChoice();
		}
		read.close();
	}

	public static int getChoice(){
		int choice;
		Scanner read=new Scanner(System.in);
		while(true)
		{
			System.out.print("Choose from the following: (1.Search, 2.Edit, 3.Print, 4.Reset, 5.Exit) ");
			try{
				choice=Integer.parseInt(read.next());
				if(choice>0&&choice<6)
				{
					break;
				}
				System.out.println("Not Valid: Reenter choice");
			}
			catch(NumberFormatException ignore){
				System.out.println("Invalid: not a number");
			}
		}
		return choice;
	}

	public static int getRow(int min,int max){
		Scanner read=new Scanner(System.in);
		int row;
		while(true)
		{
			System.out.print("Enter row: select ("+min+"-"+max+") ");
			try{
				row=Integer.parseInt(read.next());
				if(row>=min&&row<=max)
				{
					break;
				}
				System.out.println("Invalid row: number not in range");
			}
			catch(NumberFormatException ignore){
				System.out.println("Invalid: not a number");
			}
		}
		return row;
	}

	public static int getColumn(int min, int max){
		int column;
		Scanner read=new Scanner(System.in);
		while(true)
		{
			System.out.print("Enter column: select ("+min+"-"+max+") ");
			try{
				column=Integer.parseInt(read.next());
				if(column>=min&&column<=max)
				{
					break;
				}
				System.out.println("Invalid column: number not in range");
			}
			catch(NumberFormatException ignore){
				System.out.println("Invalid: not a number");
			}
		}
		return column;
	}

}
