package edu.ucalgary.ensf409;

abstract class Furniture {
	
	//Common fields amongst the furniture
	private String id;
	private String type;
	private int price;
	private Manufacturer manuInfo;
	
	//Constructor
	public Furniture() {										
	}

	//Getters
	public String getID() {
		return this.id;
	}
	
	public String getType() {
		return this.type;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public Manufacturer getManuInfo() {
		return this.manuInfo;
	}
	
	//Setters
	public void setID(String id) {
		this.id = id;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setManuInfo(Manufacturer manuInfo) {
		this.manuInfo = manuInfo;
	}

} 

class Manufacturer {
	
	private String manuID;
	private String name;
	private String phone;
	private String province;
	
	//Constructor
	public Manufacturer() {
	}
	
	//Getters
	public String getManuID() {
		return this.manuID;
	}
		
	public String getName() {
		return this.name;
	}
		
	public String getPhone() {
		return this.phone;
	}
		
	public String getProvince() {
		return this.province;
	}
		
	//Setters
	public void setManuID(String manuID) {
		this.manuID = manuID;
	}
		
	public void setName(String name) {
		this.name = name;
	}
		
	public void setPhone(String phone) {
		this.phone = phone;
	}
		
	public void setProvince(String province) {
		this.province = province;
	}
	
}

class Chair extends Furniture {
	
	private String legs;
	private String arms;
	private String seat;
	private String cushion;
	
	//Constructor
	public Chair() {
	}
	
	//Getters
	public String getLegs() {
		return this.legs;
	}
		
	public String getArms() {
		return this.arms;
	}
		
	public String getSeat() {
		return this.seat;
	}
		
	public String getCushion() {
		return this.cushion;
	}
		
	//Setters
	public void setLegs(String legs) {
		this.legs = legs;
	}
		
	public void setArms(String arms) {
		this.arms = arms;
	}
		
	public void setSeat(String seat) {
		this.seat = seat;
	}
		
	public void setCushion(String cushion) {
		this.cushion = cushion;
	}
}

class Desk extends Furniture {
	
	private String legs;
	private String top;
	private String drawer;
	
	//Constructor
	public Desk() {
	}
	
	//Getters
	public String getLegs() {
		return this.legs;
	}
	
	public String getTop() {
		return this.top;
	}
		
	public String getDrawer() {
		return this.drawer;
	}
		
	//Setters
	public void setLegs(String legs) {
		this.legs = legs;
	}
	
	public void setTop(String top) {
		this.top = top;
	}
		
	public void setDrawer(String drawer) {
		this.drawer = drawer;
	}
		
}

class Filing extends Furniture {
	
	private String rails;
	private String drawers;
	private String cabinet;
	
	//Constructor
	public Filing() {
	}
	
	//Getters
	public String getRails() {
		return this.rails;
	}
	
	public String getDrawers() {
		return this.drawers;
	}
	
	public String getCabinet() {
		return this.cabinet;
	}
			
	//Setters
	public void setRails(String rails) {
		this.rails = rails;
	}
	
	public void setDrawers(String drawers) {
		this.drawers = drawers;
	}
	
	public void setCabinet(String cabinet) {
		this.cabinet = cabinet;
	}
	
}

class Lamp extends Furniture {
	
	private String base;
	private String bulb;
	
	//Constructor
	public Lamp() {
	}
	
	//Getters
	public String getBase() {
		return this.base;
	}
	
	public String getBulb() {
		return this.bulb;
	}
			
	//Setters
	public void setBase(String base) {
		this.base = base;
	}
	
	public void setBulb(String bulb) {
		this.bulb = bulb;
	}
		
}

class OrderFrom {
	
}

class Client {
	
}



public class MyProject {

}
