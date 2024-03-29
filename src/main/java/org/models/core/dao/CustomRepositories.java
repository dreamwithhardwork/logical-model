package org.models.core.dao;

import org.models.core.domain.Make;
import org.models.core.domain.Model;
import org.models.core.domain.ModelsFilter;

import java.util.List;

public interface CustomRepositories {
    List<Make> getAllMakes();
    List<Model> getAllModels();
    List<Model> getAllModels(ModelsFilter filter);
    Model getModelByName(String name);
}
