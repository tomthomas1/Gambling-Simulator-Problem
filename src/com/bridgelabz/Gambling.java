package com.bridgelabz;

import java.util.Scanner;

public class Gambling {
	public static void main(String[] args) {
		System.out.println("-------Welcome to the Gambling Simulator----------");
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the amount of Stake: ");
		int StakePerDay = sc.nextInt();
		System.out.println("Enter the bet price for the game : ");
		int BetPrice = sc.nextInt();

		System.out.println("The total stake per days is $" + StakePerDay);
		System.out.println("Bet price per game is $" + BetPrice);
	}

}
