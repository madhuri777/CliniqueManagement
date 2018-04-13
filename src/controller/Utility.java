package controller;

import java.util.Scanner;



	public class Utility {
		static Scanner scanner=new Scanner(System.in);


		// INPUT STRING
		/**
		 * @return
		 */
		public String inputString() {
			try {
				return scanner.nextLine();
			} catch (Exception e) {
				System.out.println(e);
			}
			return "";
		}

		// INPUT Integer
		/**
		 * @return
		 */
		public int inputInteger() {
			try {
				return scanner.nextInt();
			} catch (Exception e) {
				System.out.println(e);
			}
			return 0;
		}

}
