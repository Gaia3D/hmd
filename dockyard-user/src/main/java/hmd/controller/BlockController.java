package hmd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hmd.domain.Block;
import hmd.service.BlockService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class BlockController {

	@Autowired
	BlockService blockService;

	@GetMapping("/dock")
	public String User() {
		log.info(">>>>> /dock");
		return "index";
	}

	@ResponseBody
	@PostMapping("/block")
	public List<Block> getBlockList(Block block) {
		List<Block> list = blockService.getBlockList(block);
		return list;
	}
}
