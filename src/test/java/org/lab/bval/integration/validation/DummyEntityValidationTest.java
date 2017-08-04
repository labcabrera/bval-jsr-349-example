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
public class DummyEntityValidationTest {

	@Autowired
	private Validator validator;

	@Test
	public void test_ok_insert() {
		DummyEntity entity = DummyEntity.builder().name("name").someCode(2).build();
		Set<ConstraintViolation<DummyEntity>> validationResult = validator.validate(entity,
				DummyEntity.ValidationContext.Insert.class);
		Validate.isTrue(validationResult.isEmpty());
	}

	@Test
	public void test_ko_insert_id() {
		DummyEntity entity = DummyEntity.builder().name("name").someCode(2).id("id").build();
		Set<ConstraintViolation<DummyEntity>> validationResult = validator.validate(entity,
				DummyEntity.ValidationContext.Insert.class);
		Validate.isTrue(!validationResult.isEmpty());
	}

	@Test
	public void test_ko_insert_code() {
		DummyEntity entity = DummyEntity.builder().name("name").someCode(null).build();
		Set<ConstraintViolation<DummyEntity>> validationResult = validator.validate(entity,
				DummyEntity.ValidationContext.Insert.class);
		Validate.isTrue(!validationResult.isEmpty());
	}

	@Test
	public void test_ko_insert_all_nulls() {
		DummyEntity entity = DummyEntity.builder().build();
		Set<ConstraintViolation<DummyEntity>> validationResult = validator.validate(entity,
				DummyEntity.ValidationContext.Insert.class);
		Validate.isTrue(!validationResult.isEmpty());
	}

	@Test
	public void test_ok_update() {
		DummyEntity entity = DummyEntity.builder().id("id").name("name").someCode(2).build();
		Set<ConstraintViolation<DummyEntity>> validationResult = validator.validate(entity,
				DummyEntity.ValidationContext.Default.class);
		Validate.isTrue(validationResult.isEmpty());
	}

	@Test
	public void test_ko_update_missing_id() {
		DummyEntity entity = DummyEntity.builder().name("name").someCode(2).build();
		Set<ConstraintViolation<DummyEntity>> validationResult = validator.validate(entity,
				DummyEntity.ValidationContext.Default.class);
		Validate.isTrue(!validationResult.isEmpty());
	}

	@Test
	public void test_ko_update_missing_name() {
		DummyEntity entity = DummyEntity.builder().id("id").someCode(2).build();
		Set<ConstraintViolation<DummyEntity>> validationResult = validator.validate(entity,
				DummyEntity.ValidationContext.Default.class);
		Validate.isTrue(!validationResult.isEmpty());
	}

	@Test
	public void test_ko_update_missing_code() {
		DummyEntity entity = DummyEntity.builder().id("id").name("name").build();
		Set<ConstraintViolation<DummyEntity>> validationResult = validator.validate(entity,
				DummyEntity.ValidationContext.Default.class);
		Validate.isTrue(!validationResult.isEmpty());
	}

}
