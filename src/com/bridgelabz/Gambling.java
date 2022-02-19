package com.bridgelabz;

import java.util.Scanner;

public class Gambling {
	int stakePerDay;
	int betPrice = 1;
	int minStake = 50;
	int maxStake = 150;
	int win = 0;
	int loose = 0;
	int profit = 0;

	public void play() {
		while (stakePerDay > minStake && stakePerDay < maxStake) // Win or Lost 50% of stake
		{
			int play = (int) (Math.random() * 2); // 0 = Win, 1 = Loose
			switch (play) {
			case 0: // Win
				stakePerDay += betPrice;
				// System.out.println("The player wins $1");
				break;

			case 1: // Loose
				stakePerDay -= betPrice;
				// System.out.println("The player looses $1");
				break;
			}
		}
	}

	public void gamble20Days() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the amount of Stake:");
		int num = scanner.nextInt();
		for (int days = 1; days <= 30; days++) { // loop for 20 days
			stakePerDay = num; // Accepting input for Stake Per day
			play();
			System.out.println(" \n The player has stake of " + stakePerDay + " on day " + days);
			int balanceDay = stakePerDay - 100; // as the stake per day is $100 so the profit or loss is stakePrice -
												// 100
			profit += balanceDay;
			if (stakePerDay > minStake) {
				win++; // if player wins then the win days increments
			} else {
				loose++;
			}
			System.out.println("The total profit or loss of the day is " + balanceDay);
		}
		System.out.println(" \n In total 30 days, the player has won " + win + " days and loose " + loose + " days");
		System.out.println("The total gain amount for 30 Days is $" + profit); // printing the total profit
		scanner.close();
	}

	public static void main(String[] args) {
		Gambling gamble = new Gambling();
		gamble.gamble20Days();
	}
}
