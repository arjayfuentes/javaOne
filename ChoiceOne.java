import java.util.Random;

public class ChoiceOne {
		private int row;
		private int column;
		private String [] [] array;

		ChoiceOne(int row, int column){
			this.row=row;
			this.column=column;
		}

		public void search(String search){
			int sum=0;
			for(int i=0;i<row;i++){
				for(int j=0;j<column;j++){
					if(array[i][j].contains(search)){
						sum+=checkOccurence(search,i,j);
					}
				}
			}
			if(sum==0){
				System.out.println("Character "+ search+" not found");
			}
			else{
				System.out.println("Character "+ search+" found "+sum+" time/s");
			}
		}

		public void edit(int rowedit, int columnedit, String insert){
			array[rowedit][columnedit]=insert;
		}

		public void print(){
			for(String []  rowprint : array) {
				for( String value : rowprint){
					System.out.print(value+"\t");  
				}
				System.out.println();
			}
		}

		public void reset(int newRow, int newColumn){
			array=new String [newRow][newColumn];
			for(int countRow=0;countRow<newRow;countRow++){
				for(int countCol=0;countCol<newColumn;countCol++){
					array[countRow][countCol]=getAscii();
				}
			}
			row=newRow;
			column=newColumn;
		}

		private String getAscii(){
			Random ran= new Random();
			String ascii="";
			for(int count=0;count<3;count++){
				int numChar=ran.nextInt(89)+33;
				ascii+=(char)(numChar);
			}
			return ascii;
		}

		public int checkOccurence(String search, int i, int j){
    	int sum=0;
      switch(search.length()){
			case 1:
					for(int k=0;k<3;k++){
						if(array[i][j].charAt(k)==search.charAt(0)){
							System.out.println("Found in this coordinate ["+i+"]["+j+"] character "+(k+1));
							sum+=1;
						}
					}
					break;
			case 2:
					if((array[i][j].charAt(0)==array[i][j].charAt(1))&&(array[i][j].charAt(1)==array[i][j].charAt(2))){
						sum=sum+2;
						System.out.println("Found in this coordinate ["+i+"]["+j+"] 2 times");
					}
					else {
						System.out.println("Found in this coordinate ["+i+"]["+j+"]");
						sum+=1;
					}
					break;
			default:
					System.out.println("Found in this coordinate ["+i+"]["+j+"]");
					sum+=1;
			}
      return sum;
    }

}
