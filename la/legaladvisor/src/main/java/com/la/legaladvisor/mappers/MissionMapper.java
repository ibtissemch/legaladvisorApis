package com.la.legaladvisor.mappers;

import com.la.legaladvisor.entities.Mission;
import com.la.legaladvisor.tdos.MissionDto;
import org.mapstruct.Mapper;

@Mapper
public interface MissionMapper {
    Mission toEntitiy(MissionDto missionsDto);
    MissionDto toDto(Mission missions);
}
