package org.models.core.dao;

import org.models.core.location.RTO;

import java.util.List;
import java.util.Map;

public interface RTOFilterRepository {
    List<RTO> getRTOByFilter(Map<String,String> filter);
}
