package schools;
public class Branch {
	private int branchCode;
	private int CAP;
	private String address;
	private School school;
	private Municipality muni;
	public Branch(int regionalCode, Municipality m,String address, int zipCode, School school){this.address = address;this.school = school;branchCode = regionalCode;CAP = zipCode;this.muni = m;}
	public int getCAP() {return CAP;}
	public int getCode() {return branchCode;}
	public School getSchool(){return school;}
	public String getAddress() {return address;}
	public Municipality getMunicipality(){return muni;}

}
