package org.lab.bval.integration.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.lang3.Validate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.bval.integration.config.SpringRootConfig;
import org.lab.bval.integration.domain.DummyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringRootConfig.class)
public class PatternEntityValidationTest {

	@Autowired
	private Validator validator;

	@Test
	public void test_ok() {
		DummyEntity entity = DummyEntity.builder().name("name").someCode(2).email("user@host.org").build();
		Set<ConstraintViolation<DummyEntity>> validationResult = validator.validate(entity,
				DummyEntity.ValidationContext.Insert.class);
		Validate.isTrue(validationResult.isEmpty());
	}

	@Test
	public void test_ko_empty() {
		DummyEntity entity = DummyEntity.builder().name("name").someCode(2).email("").build();
		Set<ConstraintViolation<DummyEntity>> validationResult = validator.validate(entity,
				DummyEntity.ValidationContext.Insert.class);
		Validate.isTrue(!validationResult.isEmpty());
	}

	@Test
	public void test_ko_pattern() {
		DummyEntity entity = DummyEntity.builder().name("name").someCode(2).email("not-a-valid-email").build();
		Set<ConstraintViolation<DummyEntity>> validationResult = validator.validate(entity,
				DummyEntity.ValidationContext.Insert.class);
		Validate.isTrue(!validationResult.isEmpty());
	}

}
