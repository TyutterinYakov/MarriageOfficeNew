package register.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import register.dao.BirthCertificateRepository;
import register.dao.MarriageCertificateRepository;
import register.dao.PassportRepository;
import register.dao.PersonRepository;
import register.view.MarriageResponse;

@Service
public class MarriageService {

	@Autowired
	private PersonRepository perosnDao;
	@Autowired
	private PassportRepository passportDao;
	@Autowired
	private MarriageCertificateRepository marriageDao;
	@Autowired
	private BirthCertificateRepository birthDao;
	
	
	
	@Transactional
	public MarriageResponse findMarriageCertificate(Object object) {
		
		return null;
	}
	
}
