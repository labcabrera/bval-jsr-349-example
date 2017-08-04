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
		}

	}
}
