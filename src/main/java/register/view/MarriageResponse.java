package register.view;

import java.io.Serializable;
import java.time.LocalDate;


public class MarriageResponse implements Serializable {
	private boolean existingMother;
	private boolean existingFather;
	private boolean existingMarriage;
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


	
	

}
