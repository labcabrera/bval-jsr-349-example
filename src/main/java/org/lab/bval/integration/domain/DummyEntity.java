package org.lab.bval.integration.domain;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import org.apache.bval.constraints.NotEmpty;
import org.lab.bval.integration.Constants.I18n.Messages;

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

	@Null(message = Messages.ID_MUST_BE_EMPTY, groups = ValidationContext.Insert.class)
	@NotNull(message = Messages.ID_MANDATORY, groups = ValidationContext.Default.class)
	@ApiModelProperty(value = "Identifier")
	private String id;

	@NotEmpty(message = Messages.NAME_MANDATORY, groups = { ValidationContext.Insert.class,
			ValidationContext.Default.class })
	@NotNull(message = Messages.NAME_MANDATORY, groups = { ValidationContext.Insert.class,
			ValidationContext.Default.class })
	@ApiModelProperty(value = "Name", required = true)
	private String name;

	@ApiModelProperty(value = "Description")
	private String description;

	@NotNull(message = Messages.CODE_MANDATORY, groups = { ValidationContext.Insert.class,
			ValidationContext.Default.class })
	@Min(value = 0, message = Messages.CODE_MIN_VALUE, groups = { ValidationContext.Insert.class,
			ValidationContext.Default.class })
	@Max(value = 10, message = Messages.CODE_MAX_VALUE, groups = { ValidationContext.Insert.class,
			ValidationContext.Default.class })
	@ApiModelProperty(value = "Some code", required = true)
	private Integer someCode;

	@ApiModelProperty(value = "Bean creation date")
	private Date created;

	@ApiModelProperty(value = "Bean updated date")
	private Date updated;

	/**
	 * Validation scopes for this entity.
	 */
	public static class ValidationContext {

		public static interface Insert {
		}

		public static interface Default {
		}

	}

}
