package org.models.core.dao;

import org.models.core.domain.Make;
import org.models.core.domain.Model;

import java.util.List;

public interface CustomRepositories {
    List<Make> getAllMakes();
    List<Model> getAllModels();
}
