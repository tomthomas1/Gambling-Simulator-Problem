package com.bridgelabz;

import java.util.Scanner;

public class Gambling {
	public static int stakePerDay, stake = 0, totalStake = 0;
	public static int betPrice = 1;
	public static int minStake = 50;
	public static int maxStake = 150;
	public static int win = 0, monthlyWins = 0, maxWin = 0;
	public static int loose = 0, monthlyLoose = 0, maxLoss = 0;
	public static int profit = 0, maxWinDay, maxLossDay;
	public static int count=1;

	public static void play() {
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

	// for calculating the net profit or loss that the gambler has
	public static void calculateStake() {
		stake = stakePerDay - 100;
		totalStake += stake;
		System.out.println(" \n The net profit or loss is : " + totalStake);

	}

	// to calculate the maximum win for a day in a month
	public static boolean calculateMaxWin() {
		if (totalStake > maxWin) {
			maxWin = totalStake;
			return true;
		}
		return false;
	}

	// to calculate the maximum win for a day in a month
	public static boolean calculateMaxLoss() {
		if (totalStake < maxLoss) {
			maxLoss = totalStake;
			return true;

		}
		return false;

	}

	public static void gamble30Days() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the amount of Stake:");
		int num = scanner.nextInt();
		for (int days = 1; days <= 30; days++) { // loop for 30 days
			stakePerDay = num; // Accepting input for Stake Per day
			play();
			calculateStake();
			System.out.println("The player has stake of " + stakePerDay + " on day " + days);

			if (calculateMaxWin()) {
				maxWinDay = days;
			}
			if (calculateMaxLoss()) {
				maxLossDay = days;
			}
			

			int balanceDay = stakePerDay - num; // as the stake per day is $100 so the profit or loss is stakePrice - num
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
		System.out.println("Maximum Amount Won: " + maxWin);
		System.out.println("Maximum Amount Won On Day " + maxWinDay);
		System.out.println("Maximum Amount Loss: " + maxLoss);
		System.out.println("Maximum Amount Loss On Day " + maxLossDay);
	}
	
	//if the profit is +ve the player will play or quit the game
	public static void playNextMonth() {
		//if the profit is +ve the player will continue
		while(profit > 0) {	
			System.out.println("The player has continued to play after " + count + " month as the player is in profit of $ " +profit);
			gamble30Days();
			count++;
		} 
		//if the profit is -ve the player will quit the game
			if(profit <= 0){
			System.out.println(" \n The player has stoped playing after " + count +" month as the player is in loss of $" + profit);
			count++;
		}
	}

	public static void main(String[] args) {
		gamble30Days();
		playNextMonth();
	}
}
