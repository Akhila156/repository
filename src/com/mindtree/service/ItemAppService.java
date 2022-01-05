package com.mindtree.service;
import java.util.Scanner;

import com.mindtree.entity.Item;
import com.mindtree.exception.ItemNotFoundException;

public class ItemAppService {
	static Scanner scan = new Scanner(System.in);

	public static int menu() {
		System.out.println("Enter the choice");
		System.out.println("1.Adding items to bag");
		System.out.println("2.Displaying items in bag");
		System.out.println("3.Sorting items in bag");
		System.out.println("4.Searching items in bag");
		System.out.println("5.Updating items in bag");
		System.out.println("6.Exit");

		int option = scan.nextInt();
		return option;
	}

	public static void addItems(Item[] items) {
		//System.out.println("Enter number of items to be added");
		//scan.nextLine();
		for (int i = 0; i < items.length; i++) {
			scan.nextLine();
			System.out.println("enter name of the item");
			String name = scan.nextLine();
			System.out.println("enter price of the item");
			double price = scan.nextDouble();
			System.out.println("enter weight of the item");
			double weight = scan.nextDouble();
			items[i] = new Item(name, price, weight);
			System.out.println("=========================");
		}

	}

	public static void sortingItemsByName(Item[] items) {
		if (items != null) {
			for (int i = 1; i < items.length; ++i) {
				Item k = items[i];
				int j = i - 1;
				while (j >= 0 && items[j].getName().compareTo(k.getName()) < 0) {
					items[j + 1] = items[j];
					j = j - 1;
				}
				items[j + 1] = k;
			}
			displayingItems(items);

		} else {
			System.out.println("Item List is Empty");
		}
	}

	public static void searchingItem(Item[] items) {
		boolean flag = false;
		if (items != null) {
			System.out.println("enter the item name:");
			scan.nextLine();
			String searchName = scan.nextLine();
			sortingItemsByName(items);
			int left = 0, right= items.length - 1;
			while (left <= right) {
				int mid = left + (right - 1) / 2;
				for (int i = 0; i < items.length; i++) {
					if (items[i].getName().compareTo(searchName) == 0) {
						flag = true;
						System.out.println("name found at index" + i);
						System.out.println("====================");
					}
					if (items[i].getName().compareTo(searchName) > 0) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}

				}
			}

			if (flag == false) {
				try {
					throw new ItemNotFoundException();
				} catch (ItemNotFoundException e) {
					System.out.println(e.getMessage());
				}
			}
		} else {
			System.out.println("Item List is Empty");
		}
	}

	public static void updatingItem(Item[] items) {
		boolean flag = false;
		if (items != null) {
			System.out.println("enter the item name:");
			scan.nextLine();
			String searchName = scan.nextLine();
			for (int i = 0; i < items.length; i++) {
				if (items[i].getName().equalsIgnoreCase(searchName)) {
					flag = true;
					System.out.println("Enter the new price");
					int newPrice = scan.nextInt();
					items[i].setPrice(newPrice);
				}
			}
			if (flag == false) {
				try {
					throw new ItemNotFoundException();
				} catch (ItemNotFoundException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		/*
		else {
			System.out.println("Item List is Empty");
		}*/
	}

	public static void displayingItems(Item[] items) {
		if (items!= null) {
			for (int i = 0; i < items.length; i++) {
				System.out.println("The name of the item is  :" + items[i].getName());
				System.out.println("The price of the item is :" + items[i].getPrice());
				System.out.println("The weight of the item is:" + items[i].getWeight());
				System.out.println("=====================================");
			}
		} else {
			System.out.println("Items list is empty!");
		}

	}
}
