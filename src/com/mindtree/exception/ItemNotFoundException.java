package com.mindtree.exception;

public class ItemNotFoundException extends Exception {
		
		String message = "Item NOt Found!!!";

		@Override
		public String getMessage() {
			return message;
		}

	}
