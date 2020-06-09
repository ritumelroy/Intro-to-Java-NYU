import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class proj1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		Balanced bal=new Balanced("([<",")]>");
		StackInterface<Integer> stack;
		stack = new ArrayBoundedStack<Integer>();
		boolean check = true;
		String buffer = null;
		
		while(check){
		System.out.println("Enter the dataset to open(1 for dataset 1, 2 for dataset ..)");
		String user=sc.next(); 
		String filename = "src/data/hw1_set"+user+".txt";
		File theFile = new File(filename);
	    Scanner fileInput = new Scanner(theFile);
	    
		buffer = fileInput.next(); 
		int result=bal.test(buffer);
		
	
		if(!(result==0)){
			System.out.println(result);
			System.out.println("Unbalanced expression. Try another file.");
		}else{
			check=false;
		}
		}
		ArrayList res;
		res= makearray(buffer);
		checkarray(res);

	  
	}
	public static ArrayList makearray(String s){  
		ArrayList<String> list = new ArrayList<String>();
		
		StackInterface<Integer> stack;
		stack = new ArrayBoundedStack<Integer>();
		
		
		int last = (s.length()-1);
		stack.push(last);
		int other;
		other=s.length()-2;
		String letter;
		
		
			for(int i=other;i>=0;i--){
				letter=s.substring(i, i+1);
				
				if(!(letter.contains("("))){
					stack.push(i);
					other--;
					
				} else {
					stack.push(i);
					String empty="";
					while(!stack.isEmpty()){
						int x=stack.top();
						stack.pop();
						letter=s.substring(x,x+1);
						empty+=letter;
						other--;
					
					}
					
					list.add(empty);
				}
		
			}return(list);	
	}
	public static void checkarray(ArrayList a){
	ArrayList[][] matrix = new ArrayList[13][5];
//	ArrayList<String> names=new ArrayList<String>();
	String name;
	for(int q=0;q<a.size();q++){
		//ArrayList<String> rname=new ArrayList<String>(Arrays.asList(name));
		String s;
		s=(String) a.get(q);
		
		for(int i=0;i<s.length()-1;i++){
			String letter;
			letter = s.substring(i,i+1);
			
			//System.out.println(letter);
			if(letter.contains("<")){
				
				int last=s.indexOf("<");
				name= s.substring(1, last);
				int j=s.indexOf(">",i);//ok
				
				for(int k=j;k>i;k--){
					String letter2;
					letter2=s.substring(k, k+1);
					//System.out.println(letter2);
					
					ArrayList<Integer> tlist= new ArrayList<Integer>();
					int day=0;
					if(letter2.contains("[")){
						//System.out.println(k);
						int l=s.indexOf("]",k);
						//System.out.println(l+" "+l);
						String subs=s.substring(k+1,l);
						//System.out.println(subs);
						int itime=Integer.parseInt(subs);
						int ntime = (itime/100)-9;
						ArrayList<String> anlist= new ArrayList<String>();
						matrix[ntime][day]=anlist;
						anlist.add(name);
						if(letter2.contains("[")){
						//System.out.println(ntime);
						//tlist.add(ntime);
						//System.out.println(matrix);
						if((letter+1).contains("M")){
							day = 0;
						}
						if((letter+1).contains("T")){
							day = 1;
							
						}
						if((letter+1).contains("W")){
							 day = 2;
							
						}
						if((letter+1).contains("H")){
							day = 3;
					
								
							}
						if((letter+1).contains("F")){
							day = 4;
							
								
							}
					}
					
				}
					
			}
					
		}
			}
	}
	for(int i = 0; i < 13; i++)
	   {
	      for(int j = 0; j < 5; j++)
	      {
	         System.out.print( matrix[i][j]);
	      }
	      System.out.println();
	   }
	}
	public static void analyzeStructure(ArrayList[][] s){ //Couldn't finish it...
		for(int i = 0; i < 13; i++){
		      for(int j = 0; j < 5; j++){
		    	  ArrayList<String> list= new ArrayList<String>();
					s[i][j]=list;
					ArrayList<String> highest= new ArrayList<String>();
					s[i][j]=highest;
					if(list.size()>highest.size()){
						highest=list;
					}
		      }
		  }
		 // System.out.print("The first best time: "+highest);    
	}
}
