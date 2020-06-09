package progproj2;
import java.util.Scanner;
public class Connect4 {
	 static final int X =1, O=2;
	 static final int NUM_COLUMNS = 4;
	 static final int NUM_IN_ROW=4;
	 static Scanner input = new Scanner(System.in);
	 static int firstplayer;
	 static int p1=0,p2=0;
	 static long cnt=0;
	 
	public static void main(String[] args) {

		for (int i=0; i<NUM_COLUMNS; i++) {
			int[ ][ ] list = new int[NUM_COLUMNS][NUM_COLUMNS];
			firstplayer = X;
			p1=0;p2=0;cnt=0;
			list[NUM_COLUMNS-1][NUM_COLUMNS-1]= X;
			System.out.println ("NetWins for column " +i+" : " + Play(list , X));
			System.out.println("Red wins:  "+p1 +" Blue Wins:"+p2);
			System.out.println ("Recursion calls: " + cnt);
			System.out.println();
		}
	}
		
	public static int Play(int[][] inlist, int clr) {
		cnt++;
		int res=checkBoard(inlist,clr);
		// 0 - board full, 1- X wins  2 = O wins   3-keep playing
		if (res < 3) { 
			if (res == 0) {return 0;
			} else {
			 if (res == firstplayer) {p1++; return 1;} else {p2++; return -1;}
			}
		}	      
		//  update the board for this move
		//  recursively call Play
		else {
			//res = 0;
			 
			// for each space that can be the next move
			// make a copy of board (next lines)	
				int[][] clonelist = new int[NUM_COLUMNS][NUM_COLUMNS];
					for (int row = 0; row<NUM_COLUMNS;row++  ){
					    for (int col = 0; col<NUM_COLUMNS;col++  ){
						clonelist[row][col] = inlist[row][col] ;
				    	}
					}
					boolean m = false;
					while(m == false) { 
						int row = 0; 
						int column = (int)(Math.random()*NUM_COLUMNS); 
						
						if(clonelist[0][column] == 0) { 
							for(int i = 0;i<NUM_IN_ROW;i++) {  
								if(clonelist[i][column] == 0) { 
									row = i; 
								}
							}
						}
						
						if(clonelist[row][column] == 0) { 
							clonelist[row][column] = clr; 
							m = true; 
						}
					}		
			
			return Play(clonelist,switchplayer(clr));	
		}				
	}
	
	
	
	
	public static int switchplayer(int clr){
		if(clr==X){
			clr=O;
		}else if(clr==O){
			clr=X;
		}
		return clr;
	}
	public static boolean isFull(int[][] inlist){
		boolean empty = true;
		for (int i = 0 ; i<NUM_COLUMNS ; i++ ) {
			for (int i2 = 0 ; i2<NUM_COLUMNS ; i2++ ) {
			if (inlist[i][i2] ==0   ) { empty = false; break;} 
		}
		}
		return empty;
	}
		
	public static int checkBoard(int[][] inlist ,int clr){
		int chkclr = 3-clr;
		for (int i = 0 ; i<NUM_COLUMNS; i++ ) {
			int colcnt = 0;
		    for (int j=0; j<NUM_COLUMNS; j++) {
		    	if (inlist[i][j] == chkclr) {
		    		colcnt++;
		    		if (colcnt == NUM_IN_ROW)  { return chkclr;}	 
		    	}  else {
		          colcnt =0;
		       }
		    }
	     }
		for (int i = 0 ; i<NUM_COLUMNS; i++ ) {
			int colcnt = 0;
		    for (int j=0; j<NUM_COLUMNS; j++) {
		    	if (inlist[j][i] == chkclr) {
		    		colcnt++;
		    		if (colcnt == NUM_IN_ROW)  { return chkclr;}	 
		    	}  else {
		          colcnt =0;
		       }
		    }
	     }
		int colcnt = 0;
		for (int i = 0 ; i<NUM_COLUMNS; i++ ) {
		    	if (inlist[i][i] == chkclr) {
		    		colcnt++;
		    		if (colcnt == NUM_IN_ROW)  {return chkclr;}	 
		    	}  else {
		          colcnt =0;
		       }
	     }
		colcnt = 0;
		for (int i = 0 ; i<NUM_COLUMNS; i++ ) {
		    	if (inlist[NUM_COLUMNS-1-i][i] == chkclr) {
		    		colcnt++;
		    		if (colcnt == NUM_IN_ROW)  { return chkclr;}	 
		    	}  else {
		          colcnt =0;
		       }
	     }
		if (isFull(inlist)) {  return 0; 
		} else {
			return 3;
		}
		 
		
	}
	public static void printlist(int[][] inlist) {
		for (int i =0; i<inlist.length; i++) {
			for (int j =0; j<inlist.length; j++) {
				System.out.print(inlist[i][j]+" ");
			}
			System.out.println();
		}
		 System.out.println();
	}
 
}
