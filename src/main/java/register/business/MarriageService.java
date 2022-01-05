package register.business;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import register.dao.BirthCertificateRepository;
import register.dao.MarriageCertificateRepository;
import register.dao.PassportRepository;
import register.dao.PersonRepository;
import register.domain.BirthCertificate;
import register.domain.ChildRequest;
import register.domain.ChildResponse;
import register.domain.MarriageCertificate;
import register.domain.Passport;
import register.domain.Person;
import register.view.MarriageRequest;
import register.view.MarriageResponse;

@Service
public class MarriageService {

	@Autowired
	private PersonRepository personDao;
	@Autowired
	private PassportRepository passportDao;
	@Autowired
	private MarriageCertificateRepository marriageDao;
	@Autowired
	private BirthCertificateRepository birthDao;
	
	
	
	@Transactional
	public MarriageResponse findMarriageCertificate(MarriageRequest request) {
		MarriageResponse response = new MarriageResponse();
		Long husbandId=0L;
		Long wifeId=0L;
		
		//WIFE
		Optional<Passport> psw = passportDao.findByNumberAndSeriaAndIssueDate(request.getWifePassportNumber(), request.getWifePassportSeria(), request.getWifePassportIssueDate());
		if(psw.isPresent()) {
			Optional<Person> wife = personDao.findById(psw.get().getPerson().getPersonId());
			if(wife.isPresent()) {
				Person w = wife.get();
				wifeId = w.getPersonId();
				if(
					w.getFirstName().equals(request.getWifeGivenName())&&
					w.getLasName().equals(request.getWifeSurName())&&
					w.getPatronymic().equals(request.getWifePatronymic())&& 
					w.getDateOfBirth().equals(request.getWifeDateOfBirth())
					) {
					response.setExistingMother(true);
				}
			}
		}
		
		//FATHER
		Optional<Passport> psh = passportDao.findByNumberAndSeriaAndIssueDate(request.getHusbandPassportNumber(), request.getHusbandPassportSeria(), request.getHusbandPassportIssueDate());
		if(psh.isPresent()) {
			Optional<Person> husband = personDao.findById(psh.get().getPerson().getPersonId());
			if(husband.isPresent()) {
				Person h = husband.get();
				husbandId = h.getPersonId();
				if(
					h.getFirstName().equals(request.getHusbandGivenName())&&
					h.getLasName().equals(request.getHusbandSurName())&&
					h.getPatronymic().equals(request.getHusbandPatronymic())&& 
					h.getDateOfBirth().equals(request.getHusbandDateOfBirth())
					) {
					response.setExistingFather(true);
				}
			}
		}
		if(response.isExistingFather()&&response.isExistingMother()) {
			if(!request.getChilds().isEmpty()) {
				List<ChildResponse> list = new LinkedList<>();
				for(ChildRequest child: request.getChilds()) {
					Optional<Person> ch = personDao.findPerson(child.getFirstName(), child.getLastName(), child.getPatronymic(), child.getDateOfBirth());
					if(ch.isPresent()) {
						Optional<BirthCertificate> birth = birthDao.findBirthCertificate(child.getNumberCertificate(), child.getIssueDate(), husbandId, wifeId, ch.get().getPersonId());
						if(birth.isPresent()) {
							ChildResponse resp = new ChildResponse();
							resp.setName(child.getFirstName());
							resp.setCheckChild(true);
							list.add(resp);
						}
					}
				}
				response.setChilds(list);
				}
			Optional<MarriageCertificate> marriageCertificate = marriageDao.findMarriageCertifficate(
					request.getMarriageCertificateNumber(),
					request.getMarriageCertificateDate(),
					husbandId,
					wifeId
					
					
					);
			if(marriageCertificate.isPresent()) {
				MarriageCertificate mc = marriageCertificate.get();
				if(mc.getEndDate()==null) {
					response.setExistingMarriage(true);
				}
			}
		}

		
		
		return response;
	}
	
}
