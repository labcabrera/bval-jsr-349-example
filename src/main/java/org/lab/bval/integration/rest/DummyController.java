package org.lab.bval.integration.rest;

import static org.lab.bval.integration.Constants.API_VERSION;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.lab.bval.integration.domain.DummyEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "Bean validation example controller")
@RequestMapping(API_VERSION + "/dummy")
public interface DummyController {

	@ApiOperation(value = "Find by id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<DummyEntity> findById(
			@ApiParam(name = "Entity identifier", required = true) @NotNull @PathVariable("id") String id);

	@ApiOperation(value = "Search")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	List<DummyEntity> find(
			@ApiParam(name = "Search expression") @RequestParam(value = "q", required = false) String searchExpression,
			@ApiParam(name = "Page") @RequestParam(value = "p", required = false) Integer page,
			@ApiParam(name = "Items per page") @RequestParam(value = "c", required = false) Integer count);

	@ApiOperation(value = "Insert")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	ResponseEntity<DummyEntity> insert(@RequestBody DummyEntity entity);

	@ApiOperation(value = "Update")
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	ResponseEntity<DummyEntity> update(@RequestBody DummyEntity entity);

	@ApiOperation(value = "Remove")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<DummyEntity> remove(
			@ApiParam(name = "Entity identifier", required = true) @NotNull @PathVariable("id") String id);

}
