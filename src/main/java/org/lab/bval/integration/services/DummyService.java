package org.lab.bval.integration.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.lab.bval.integration.domain.DummyEntity;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

	private List<DummyEntity> mockEntities;

	public DummyEntity findById(String id) {
		return findById(id, mockEntities);
	}

	public List<DummyEntity> find(String searchExpression, Integer page, Integer count) {
		return mockEntities;
	}

	public DummyEntity insert(DummyEntity entity) {
		entity.setId(UUID.randomUUID().toString());
		entity.setCreated(Calendar.getInstance().getTime());
		mockEntities.add(entity);
		return entity;
	}

	public DummyEntity update(DummyEntity entity) {
		DummyEntity current = findById(entity.getId(), mockEntities);
		if (current == null) {
			return null;
		}
		current.setDescription(entity.getDescription());
		current.setName(entity.getName());
		current.setSomeCode(entity.getSomeCode());
		current.setUpdated(Calendar.getInstance().getTime());
		return current;
	}

	public DummyEntity remove(String id) {
		DummyEntity entity = findById(id, mockEntities);
		if (entity != null) {
			mockEntities.remove(entity);
		}
		return entity;
	}

	@PostConstruct
	public void postConstruct() {
		mockEntities = new ArrayList<DummyEntity>();
		insert(DummyEntity.builder().name("Alice").description("Alice example").someCode(3).build());
		insert(DummyEntity.builder().name("Bob").description("Bob example").someCode(6).build());
		insert(DummyEntity.builder().name("Carol").description("Carol example").someCode(7).build());
	}

	private DummyEntity findById(String id, List<DummyEntity> mockEntities) {
		for (DummyEntity i : mockEntities) {
			if (i.getId().equals(id)) {
				return i;
			}
		}
		return null;
	}
}
