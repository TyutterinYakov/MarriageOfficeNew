package register.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import register.business.MarriageService;
import register.view.MarriageRequest;
import register.view.MarriageResponse;




@Controller
public class MarriageController {
//	private static final Logger logger = LoggerFactory.getLogger(MarriageController.class);
	


	@Autowired
	private MarriageService marriageService;
	
	
	

	
	@PostMapping(path="/checkMarriage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public MarriageResponse findMarriageCertificate(@RequestBody MarriageRequest request) {
//		logger.info("findMarriageCertificate called");
		return marriageService.findMarriageCertificate(request);
	}
	
}
