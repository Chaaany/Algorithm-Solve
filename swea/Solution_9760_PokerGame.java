package swea;

import java.io.*;
import java.util.*;

public class Solution_9760_PokerGame {
	static int T, nums[], shapes[];
	static String deque[];
	static String dequeNumDict = "A23456789TJQK";
	static String dequeShapeDict = "SDHC";

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			deque = br.readLine().split(" ");
			nums = new int[13];
			shapes = new int[4];
			for (int i = 0; i < deque.length; i++) {
				shapes[dequeShapeDict.indexOf(deque[i].charAt(0))]++;
				nums[dequeNumDict.indexOf(deque[i].charAt(1))]++;
			}

			if (CheckStraightFlush()) {
				sb.append("#").append(t).append(" Straight Flush\n");
				continue;
			} else if (CheckFourOfAKind()) {
				sb.append("#").append(t).append(" Four of a Kind\n");
				continue;
			} else if (CheckFullHouse()) {
				sb.append("#").append(t).append(" Full House\n");
				continue;
			} else if (CheckFlush()) {
				sb.append("#").append(t).append(" Flush\n");
				continue;
			} else if (CheckStraight()) {
				sb.append("#").append(t).append(" Straight\n");
				continue;
			} else if (CheckThreeOfAKind()) {
				sb.append("#").append(t).append(" Three of a kind\n");
				continue;
			} else if (CheckTwoPair()) {
				sb.append("#").append(t).append(" Two pair\n");
				continue;
			} else if (CheckOnePair()) {
				sb.append("#").append(t).append(" One pair\n");
				continue;
			} else {
				sb.append("#").append(t).append(" High card\n");
				continue;
			}
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}

	private static boolean CheckOnePair() {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 2)
				return true;
		}
		return false;
	}

	private static boolean CheckTwoPair() {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i] == 2 && nums[j] == 2)return true;
			}
		}
		return false;
	}

	private static boolean CheckThreeOfAKind() {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 3)
				return true;
		}
		return false;
	}

	private static boolean CheckStraight() {
		a: for (int i = 0; i <= 9; i++) {
			boolean checkNums = true;
			for (int j = i; j < i + 5; j++) {
				if (nums[j%13] != 1) continue a;
			}
			if (checkNums)
				return true;
		}
		return false;
	}

	private static boolean CheckFlush() {
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] == 5)
				return true;
		}
		return false;
	}

	private static boolean CheckFullHouse() { // 3장의 동일한 랭크(값)와 다른 랭크(값)의 동일한 2장으로 구성된다.
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if ((nums[i] == 2 && nums[j] == 3) || (nums[i] == 3 && nums[j] == 2))
					return true;
			}
		}
		return false;
	}

	private static boolean CheckFourOfAKind() { // 5장 중 4개의 랭크(값)가 모두 같다.

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 4)
				return true;
		}
		return false;
	}

	private static boolean CheckStraightFlush() {
		boolean checkShapes = false;
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[i] == 5) 
				checkShapes = true;
		}
		if (checkShapes) {
			a: for (int i = 0; i <= 9; i++) {
				boolean checkNums = true;
				for (int j = i; j < i + 5; j++) {
					if (nums[j%13] != 1) continue a;
				}
				if (checkNums)
					return true;
			}
		}
		return false;
	}
}
