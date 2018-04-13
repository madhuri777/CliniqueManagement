package controller;

import java.util.Scanner;

public class CliniqueManager {
	static AddDetails details=new AddDetails();
	private static Scanner scanner=new Scanner(System.in); 
	
	public static void main(String[] args)throws Exception {
		System.out.println(":------------CliniqueManageMent------------:");
		System.out.println();
		System.out.println();
		boolean flag=true;
		while(flag) {
		System.out.println(":---1.AddDoctor---2.Search---3.TakeAppointment---4.Exit---:");
		System.out.println();
		System.out.println();
		int option=scanner.nextInt();
		switch(option) {
		case 1:
			details.addDoctor();
			break;
		case 2:
			details.search();
			break;
		case 3:
			details.takeAppointment();
			break;
		case 4:
			System.out.println("Closed");
			flag=false;
			break;
		}

	}
	}

}
