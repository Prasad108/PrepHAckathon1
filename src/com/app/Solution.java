package com.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {


public class Connections {

	int a,b,d;

	public Connections(int a, int b, int d) {
		super();
		this.a = a;
		this.b = b;
		this.d = d;
	}
	
	 @Override
	    public boolean equals(Object obj) {
	        if (obj == null) {
	            return false;
	        }

	        if (!(obj instanceof Connections)) {
	            return false;
	        }

	        final Connections con = (Connections) obj;
	        if ((this.a == con.a) && (this.b == con.b) && (this.d == con.d)) {
	            return true;
	        }else
	        {
	        	return false;
	        }
	    }
	 
	 public boolean isNextPipe(Connections con) {
		 if(this.b==con.a) {
			 return true;			 
		 }
		 return false;
		 
	 }
	 
	 public boolean isPrevPipe(Connections con) {
		 if(this.a==con.b) {
			 return true;
			 
		 }
		 return false;
		 
	 }
	
	 public Connections ConnectPrevPipe(Connections con) {
		 this.a=con.a;
		 this.d= this.d <= con.d ? this.d : con.d;
		 return this;
	 }
	 
	 public Connections ConnectNextPipe(Connections con) {
		 this.b=con.b;
		 this.d= this.d <= con.d ? this.d : con.d;
		 return this;
		 
	 }

	@Override
	public String toString() {
		return "  " + a + " " + b + " " + d + " ";
	}
	
	
	
}
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the number of houses");		
		int n = sc.nextInt();
		
		System.out.println("enter the number of pipes");
		int p = sc.nextInt();
		
		 ArrayList<Connections> connections = new ArrayList<Connections>();
		
		int a,b,c;
		Solution s=new Solution();
		
		for(int row = 0; row< p; row++) {
          
                System.out.println("enter the connection");
                a = sc.nextInt();
                b = sc.nextInt();
                c = sc.nextInt();
                Connections con=s.new Connections(a, b, c);
                connections.add(con);
  
            System.out.println();
        }
		
		for(Connections con:new ArrayList<Connections>(connections))
		{
			for(Connections test:new ArrayList<Connections>(connections)) {
				
				if(con.equals(test)) {
					continue;
				}else if(con.isNextPipe(test)) {
					connections.add(con.ConnectNextPipe(test));
					connections.remove(con);
					connections.remove(test);
					
				}else if(con.isPrevPipe(test)) {
					connections.add(con.ConnectPrevPipe(test));
					connections.remove(con);
					connections.remove(test);
					
				}
				
			}
		}
		
		System.out.println(connections.size());
		System.out.println(connections);
		

	}
	
	


}
