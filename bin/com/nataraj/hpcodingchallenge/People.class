package com.nataraj.hpcodingchallenge;

public class People implements Comparable<People>{
	private String name;
	private int age;
	public double latitude;
	public double longitude;
	
	
public People(String name, int age, double latitude, double longitude)
{
		super();
		this.name = name;
        this.age = age;
		this.latitude = latitude;
		this.longitude = longitude;
}


public People() 
{
		// TODO Auto-generated constructor stub
}


public String getName() 
{
		return name;
}


public void setName(String name) 
{
		this.name = name;
}


public int getAge()
{
	  return age;
}


public void setAge(int age)
{
		this.age = age;
}


public double getLatitude() 
{
	return (int)latitude;
    
}


public void setLatitude(double latitude) 
{
		this.latitude = latitude;
}


public double getLongitude() 
{
		return (int)longitude;
}


public void setLongitude(double longitude) 
{
		this.longitude = longitude;
}

@Override
public String toString()
{
		return "People [name=" + name + ", age=" + age + ", latitude=" + latitude + ", longitude=" + longitude + "]";
}


@Override
public int compareTo(People o) 
{
	
    return o.getAge()-this.getAge();

}


}



 
