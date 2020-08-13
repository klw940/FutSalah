package ido.arduino.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ido.arduino.dto.MatchDto;
import ido.arduino.dto.TeamInfoDto;
import ido.arduino.service.MatchGameService;
import ido.arduino.service.TeamInfoService;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
public class MatchGameController {
	private static final Logger logger = LoggerFactory.getLogger(MatchGameController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	

	@Autowired
	MatchGameService mService;
	
	@Autowired
	TeamInfoService tService;

	

	// ----------------Matching game waiting ---------------------------
	
	
	@ApiOperation(value = "모든 조건에 맞는 결과를 반환한다", response = List.class)
	@GetMapping("/match")
	public ResponseEntity<List<MatchDto>> alloption() throws Exception {
		logger.debug("alloption - 호출");
		System.out.println("alloption호추추루룰...........................................................");

		return new ResponseEntity<List<MatchDto>>(mService.alloption(), HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "일부 조건에 맞는 결과를 반환한다", response = List.class)
	@GetMapping("/match2")
	public ResponseEntity<List<MatchDto>> simpleoption() throws Exception {
		logger.debug("simpleoption - 호출");
		System.out.println("simpleoption 호추추루룰...........................................................");

		return new ResponseEntity<List<MatchDto>>(mService.simpleoption(), HttpStatus.OK);
	}

	
	@ApiOperation(value = "매칭 조건을 등록한다  ", response = List.class)
	@PostMapping("/match")
	public ResponseEntity<Map<String, Object>> insertmatch(@RequestBody MatchDto match) {
		ResponseEntity<Map<String, Object>> entity = null;

		try {

			TeamInfoDto team = tService.getTeamInfo(match.getHomeTeamID());
			int result = mService.insertmatch(match);
			entity = handleSuccess(match.getClass() + "가 등록되었습니다.");
		} catch (RuntimeException e) {
			entity = handleException(e);
		}

		return entity;
	}

	// ----------------예외처리---------------------------

	private ResponseEntity<Map<String, Object>> handleSuccess(Object data) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", true);
		resultMap.put("data", data);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}

	private ResponseEntity<Map<String, Object>> handleException(Exception e) {
		logger.error("예외 발생", e);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", false);
		resultMap.put("data", e.getMessage());
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
