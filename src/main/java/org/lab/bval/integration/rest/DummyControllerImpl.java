package org.lab.bval.integration.rest;

import java.util.List;

import org.lab.bval.integration.domain.DummyEntity;
import org.lab.bval.integration.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerImpl implements DummyController {

	@Autowired
	private DummyService service;

	@Override
	public ResponseEntity<DummyEntity> findById(String id) {
		DummyEntity entity = service.findById(id);
		return entity != null ? new ResponseEntity<DummyEntity>(entity, HttpStatus.OK)
				: new ResponseEntity<DummyEntity>(HttpStatus.NOT_FOUND);
	}

	@Override
	public List<DummyEntity> find(String searchExpression, Integer page, Integer count) {
		return service.find(searchExpression, page, count);
	}

	@Override
	public ResponseEntity<DummyEntity> insert(
			@Validated(DummyEntity.ValidationContext.Insert.class) DummyEntity entity) {
		DummyEntity result = service.insert(entity);
		return new ResponseEntity<DummyEntity>(result, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<DummyEntity> update(
			@Validated(DummyEntity.ValidationContext.Default.class) DummyEntity entity) {
		DummyEntity result = service.update(entity);
		return result != null ? new ResponseEntity<DummyEntity>(result, HttpStatus.OK)
				: new ResponseEntity<DummyEntity>(HttpStatus.NOT_FOUND);
	}

	@Override
	public ResponseEntity<DummyEntity> remove(String id) {
		DummyEntity result = service.remove(id);
		return result != null ? new ResponseEntity<DummyEntity>(result, HttpStatus.OK)
				: new ResponseEntity<DummyEntity>(HttpStatus.NOT_FOUND);
	}
}
