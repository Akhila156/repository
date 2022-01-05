package com.mindtree.client;

import java.util.Scanner;
import com.mindtree.entity.*;
import com.mindtree.service.*;

public class ItemApp {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// asking user for number of items in bag
		System.out.println("Enter number of items you required in bag");
		System.out.println("Hi i am akhila");
		int numberOfItems = scan.nextInt();
		Item[] items = new Item[numberOfItems];
		boolean isContinue = true;
		do {
			int option = ItemAppService.menu();
			switch (option) {
			case 1:
				ItemAppService.addItems(items);
				break;
			case 2:
				ItemAppService.displayingItems(items);
				break;
			case 3:
				ItemAppService.sortingItemsByName(items);
				break;
			case 4:
				ItemAppService.searchingItem(items);
				break;
			case 5:
				ItemAppService.updatingItem(items);
				break;
			case 6:
				System.out.println("Bye!");
				isContinue = false;
				break;
			default:
				System.out.println("INVALID!!option");
			}
		} while (isContinue);
	}
}
