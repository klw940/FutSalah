package ido.arduino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ido.arduino.dto.LocationDto;
import ido.arduino.dto.MyTeamDto;
import ido.arduino.dto.TeamInfoDto;
import ido.arduino.dto.TeamInfoSimpleDto;
import ido.arduino.repo.TeamInfoRepo;


@Service
public class TeamInfoServiceImpl implements TeamInfoService {

	
	@Autowired
	TeamInfoRepo tRepo;
	
	@Override
	public int insert(TeamInfoDto info) {
		// TODO Auto-generated method stub
		return tRepo.insert(info);
	}

	@Override
	public int update(TeamInfoDto info) {
		// TODO Auto-generated method stub
		return tRepo.update(info);
	}
	@Override
	public int delete(String teamID) {
		// TODO Auto-generated method stub
		return tRepo.delete(teamID);
	}

	@Override
	public List<TeamInfoSimpleDto> selectAll() {
		// TODO Auto-generated method stub
		return tRepo.selectAll();
	}

	@Override
	public List<MyTeamDto> selectAllmyteam() {
		// TODO Auto-generated method stub
		return tRepo.selectAllmyteam();
	}

	@Override
	public List<LocationDto> selectSido() throws Exception {
		// TODO Auto-generated method stub
		return tRepo.selectSido();
	}

	

}
