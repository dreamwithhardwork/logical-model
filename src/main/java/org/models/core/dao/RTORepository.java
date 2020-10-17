package org.models.core.dao;

import org.models.core.location.RTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RTORepository extends MongoRepository<RTO,String> {

    List<RTO> findByState(String state);
    List<RTO> findByDistrict(String district);
    List<RTO> findByLocation(String location);
    List<RTO> findByOperating(Boolean operation);

    //operations
    List<RTO> findByStateAndOperating(String state, Boolean operation);
    List<RTO> findByDistrictAndOperating(String district, Boolean operation);
    List<RTO> findByLocationAndOperating(String location, Boolean operation);


}
