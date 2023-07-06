package com.moody.backend.model;

import com.moody.backend.model.Weather;
import org.springframework.data.repository.CrudRepository;

public interface JpaWeatherRepository extends CrudRepository<Weather, Long> {
}
