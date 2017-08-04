package org.lab.bval.integration;

public interface Constants {

	public String API_VERSION = "1.0";

	public static interface I18n {

		public interface Messages {
			public String ID_MUST_BE_EMPTY = "validation.id.empty";
			public String ID_MANDATORY = "validation.id.required";
			public String NAME_MANDATORY = "validation.name.required";
			public String CODE_MANDATORY = "validation.code.required";
			public String CODE_MIN_VALUE = "validation.code.min";
			public String CODE_MAX_VALUE = "validation.code.max";
			public String EMAIL_INVALID = "validation.email.pattern.invalid";
		}
	}

	public static interface RegEx {
		public String EMAIL_RFC_2822 = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	}
}
