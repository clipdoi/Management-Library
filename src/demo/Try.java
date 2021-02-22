package demo;

import java.util.Random;
import java.util.Scanner;

public class Try {

	public static void main(String[] args) {

		try {
			String ch = "123xyz";
			int min = 0, max = 999;
			int t = 0;
			System.out.println(t);
			Random random = new Random();
			System.out.println(t + ch.charAt(random.nextInt(ch.length())));
			System.out.println(random.nextInt(max));
			Scanner scanner = new Scanner(System.in);
			System.out.println("Input:");
			String input = scanner.nextLine();
			String number = input.replaceFirst("(\\d{3})(\\d+)", "$1-$2");
			System.out.println(number);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
