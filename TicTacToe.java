import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

	  
	 static ArrayList<Integer> playerPos= new ArrayList<Integer>();
	 static ArrayList<Integer> player0Pos= new ArrayList<Integer>();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] gameBoard= { {' ','|',' ','|',' '},
		{'-','+','-','+','-'} ,
		{' ','|',' ','|',' '} ,
		{'-','+','-','+','-'} ,
		{' ','|',' ','|',' '} };
		
		printgameboard(gameBoard);
		
		
		while(true) {
		     
		    
			Scanner scan =new Scanner(System.in);

			System.out.println("Enter your placement (1 - 9) player 1:");
			int pos=scan.nextInt();
			while(playerPos.contains(pos) || player0Pos.contains(pos)) {
				System.out.println("postion taken! Enter a correct Postion");
				pos=scan.nextInt();
			}
		//	System.out.println(pos);
			placepiece(gameBoard,pos,"player");
			printgameboard(gameBoard);
			
			String result=checkWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
			
			System.out.println("Enter your placement (1 - 9) player 2:");
			int pos0=scan.nextInt();
			while(playerPos.contains(pos0) || player0Pos.contains(pos0)) {
				System.out.println("postion taken! Enter a correct Postion");
				pos0=scan.nextInt();
			}
		//	System.out.println(pos0);
			
		
			Random rand= new Random();
			int poscpu=rand.nextInt(9)+1;
			//placepiece(gameBoard,poscpu,"cpu");
			
			placepiece(gameBoard,pos0,"player0");
			
			printgameboard(gameBoard);
			
			 result=checkWinner();
			if(result.length()>0) {
				System.out.println(result);
				break;
			}
			
			
		}
		

		
	}



public static void printgameboard(char[][] gameBoard) {
	for(char[] row:gameBoard) {
		for(char c : row) {
			System.out.print(c);
		}
            System.out.println();
	}
}

   public static void placepiece(char[][] gameBoard,int pos,String user) {
	   
	   char symbol = ' ';
	   if(user.equals("player")) {
		   symbol='X';
		   playerPos.add(pos);
	   }else if(user.equals("player0")) {
		   symbol='0';
		   player0Pos.add(pos);
	   }else if(user.equals("cpu")) {
		   symbol='0';
	   }
	   switch(pos) {
		case 1:
			gameBoard[0][0]=symbol;
			break;
		case 2:
			gameBoard[0][2]=symbol;
			break;
		case 3:
			gameBoard[0][4]=symbol;
			break;
		case 4:
			gameBoard[2][0]=symbol;
			break;
		case 5:
			gameBoard[2][2]=symbol;
			break;
		case 6:
			gameBoard[2][4]=symbol;
			break;
		case 7:
			gameBoard[4][0]=symbol;
			break;
		case 8:
			gameBoard[4][2]=symbol;
			break;
		case 9:
			gameBoard[4][4]=symbol;
			break;
			default:
				break;
		
		}
	//printgameboard(gameBoard);
	   
   }
        public static String checkWinner() {
        	  
        List topRow = Arrays.asList(1,2,3);
        List midRow = Arrays.asList(4,5,6);
        List botRow = Arrays.asList(7,8,9);
        List leftCol= Arrays.asList(1,4,7);
        List midCol = Arrays.asList(2,5,8);
        List rightCol = Arrays.asList(3,6,9);
        List cross1 = Arrays.asList(1,5,9);
        List cross2 = Arrays.asList(7,5,3);
        
        List<List> winning  =new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);
           
        
        for(List l : winning) {
        	if(playerPos.containsAll(l)) {
        		
        		return"congratulations you won Player 1 ";
        		
        
        	}else if(player0Pos.containsAll(l)) {
        		
        		return"congratulations you won Player 2 ";	
        	}
        	
         }
        if(playerPos.size()+player0Pos.size()==9) {
    		return"Tie Match!";
    	}

        return"";
                
        }

