package ido.arduino.service;

import java.util.List;

import ido.arduino.dto.Formation;
import ido.arduino.dto.MyTeamDto;
import ido.arduino.dto.ResultDto;
import ido.arduino.dto.TeamInfoDto;
import ido.arduino.dto.TeamInfoSimpleDto;
import ido.arduino.dto.TeamLeaderDTO;
import ido.arduino.dto.TeamLocationDTO;
import ido.arduino.dto.UserDTO;
import ido.arduino.dto.UserTeamConnDto;

public interface TeamInfoService {

	
	//----------------create team---------------------------
	int insert(TeamInfoDto info);
	int checkIfExists(String name);
	int update(TeamInfoDto info);
	int delete(int teamID);

	//----------------myteam---------------------------
	int insertmy(UserTeamConnDto uteam);
	int updatemy(UserDTO userID);
	List<MyTeamDto> selectAllmyteam(int id); // 나의 팀 목록
	
	//----------------findteam---------------------------
	List<TeamInfoSimpleDto> selectAll(); // 팀찾기에서 간단한 항목
	

	
	//----------------team info---------------------------
	TeamInfoDto getTeamInfo(int teamID);
	TeamLeaderDTO getTeamLeaderInfo(int teamID);
	List<UserDTO> getAllCrewInfo(int teamID);
	int getNextTeamId();
	int deleteCrew(int teamID, int userID);
	int getNumberOfCrews(int teamID);
	int getNextLeader(int userID, int teamID);
	int updateLeader(int userID, int teamID);
	
	
	//----------------search team------------------------
	List<TeamLocationDTO> searchTeamByName(String name);
	List<TeamLocationDTO> searchTeamByLocation(String gu);
	List<TeamLocationDTO> searchTeamByBoth(String name,String gu);


	
	//----------------formation---------------------------
	
	int insertformation(Formation form);
	int updateformation(Formation form);
	int deleteformation(int userID);
	List<Formation> selectformation(); 
	
	//----------------result game---------------------------
	List<ResultDto> resultscore(); 

}
