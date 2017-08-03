package org.lab.bval.integration.domain;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "Example entity bean")
public class DummyEntity {

	@Null(message = "Id must be empty in a insert operation", groups = ValidationContext.Insert.class)
	@NotNull(message = "Id is required", groups = ValidationContext.Default.class)
	@ApiModelProperty(value = "Identifier")
	private String id;

	@NotNull(message = "Name is required", groups = { ValidationContext.Insert.class, ValidationContext.Default.class })
	@ApiModelProperty(value = "Name", required = true)
	private String name;

	@ApiModelProperty(value = "Description")
	private String description;

	// TODO min/max constraints dont work
	@NotNull(message = "Code is required", groups = { ValidationContext.Insert.class, ValidationContext.Default.class })
	@Min(value = 0, message = "Code must be greater than or equals to 0")
	@Max(value = 10, message = "Code must be less than or equals to 10")
	@ApiModelProperty(value = "Some code", required = true)
	private Integer someCode;

	@ApiModelProperty(value = "Bean creation date")
	private Date created;

	@ApiModelProperty(value = "Bean updated date")
	private Date updated;

	public static class ValidationContext {

		public static interface Insert {
		}

		public static interface Default {
		}

	}

}
