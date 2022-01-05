package register.view;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import register.domain.ChildResponse;


public class MarriageResponse implements Serializable {
	private boolean existingMother;
	private boolean existingFather;
	private boolean existingMarriage;
	private List<ChildResponse> childs;
	public boolean isExistingMarriage() {
		return existingMarriage;
	}
	public void setExistingMarriage(boolean existingMarriage) {
		this.existingMarriage = existingMarriage;
	}
	public boolean isExistingMother() {
		return existingMother;
	}
	public void setExistingMother(boolean existingMother) {
		this.existingMother = existingMother;
	}
	public boolean isExistingFather() {
		return existingFather;
	}
	public void setExistingFather(boolean existingFather) {
		this.existingFather = existingFather;
	}
	public List<ChildResponse> getChilds() {
		return childs;
	}
	public void setChilds(List<ChildResponse> childs) {
		this.childs = childs;
	}


	
	

}
