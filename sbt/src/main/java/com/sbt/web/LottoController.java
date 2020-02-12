package com.sbt.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbt.web.dto.Lotto;

@Controller
public class LottoController {
	
	Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@RequestMapping(value="/lotto/main")
	public String main(Model model) throws Exception {
		
       List<Integer> lottoNum = new ArrayList<Integer>();
		
		// List 안에 로또번호 추가 
		for (int i = 1; i <= 45; i++) {
			lottoNum.add(i); 
		} 
		
		// set안의 수를 무작위로 섞는다
		Collections.shuffle(lottoNum);
		// 정렬 
		Collections.sort(lottoNum); 
		
		model.addAttribute("lottoNum", lottoNum);
		
		return "/lotto/lottoMain";
	}
	
	@RequestMapping(value="/lotto/createLotto" , method = RequestMethod.POST)
	public  @ResponseBody Lotto createLotto(Lotto lotto) throws Exception {
		
		List<Integer> exceptNum = new ArrayList<Integer>();

		if(lotto.getLottoNumbers().length > 0) {
			
			int[] number = lotto.getLottoNumbers();
			for (int i : number) {
				exceptNum.add(i);
			}
		}
		
		// List 1~45 번호 add
		List<Integer> lottoNum = new ArrayList<Integer>();
		for (int i = 1; i <= 45; i++) {
			lottoNum.add(i);
		}
		
		// 로또번호에서 제외번호 빼기
		for(int j=0; j<exceptNum.size(); j++) {
			Integer exptNum = exceptNum.get(j);
			for(int ii=0; ii<lottoNum.size(); ii++) {
				if(exptNum==lottoNum.get(ii)) {
					lottoNum.remove(ii);
				}
			}
		}
		
		// 로또 번호 섞기
		Collections.shuffle(lottoNum);
		logger.info("1번섞기 : " + lottoNum);
		Collections.shuffle(lottoNum);
		logger.info("2번섞기 : " + lottoNum);
		Collections.shuffle(lottoNum);
		logger.info("3번섞기 : " + lottoNum);
		
		// 번호뽑기
		int[] lottoNums = new int[6];
		for (int i = 0; i < 6; i++) {
			lottoNums[i] = lottoNum.get(i); 
		} 
		
		// 정렬 
		Arrays.sort(lottoNums);
		
		lotto.setLottoNumbers(lottoNums);
		
		return lotto;
	}
}
