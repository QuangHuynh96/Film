package com.example.a09cinema_backenddevelop.service;

import com.example.a09cinema_backenddevelop.model.dto.TimeDto;
import com.example.a09cinema_backenddevelop.model.entity.Time;

import java.util.List;

public interface TimeService {
    List<TimeDto> findAllTimeShowBySeatDetail(String date_show, String film_id);
}
