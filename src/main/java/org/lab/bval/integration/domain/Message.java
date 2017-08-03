package org.lab.bval.integration.domain;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {

	private String code;
	private String message;
	private Map<String, String> details;

}
