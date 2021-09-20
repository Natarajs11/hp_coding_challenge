package com.nataraj.hpcodingchallenge;


/**
 * This java example will demonstrate how to convert json array to object array
 * using jackson.
 * 
 * @author NATARAJ SHIVASHANKAR
 * 
 */

//importing required libraries
import java.util.*;
import java.util.stream.Collectors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HpCodingChallenge {
	
   
// calculate distance between the points using latitudes and longitudes  
static double haversine(double latitude1, double longitude1,double latitude2, double longitude2)
{
	
double dLat = Math.toRadians(latitude2 - latitude1);
double dLon = Math.toRadians(longitude2 - longitude1);

// convert to radians
latitude1 = Math.toRadians(latitude1);
latitude2 = Math.toRadians(latitude2);

// apply formulae
double a = Math.pow(Math.sin(dLat / 2), 2) +
   Math.pow(Math.sin(dLon / 2), 2) *
   Math.cos(latitude1) *
   Math.cos(latitude2);
double rad = 6371;
double c = 2 * Math.asin(Math.sqrt(a));
return rad * c;
}

//Main Method
public static void main(String[] args) {
        
    	//Json Data 
        String json = "[\r\n"
        		+ " {\"Name\": \"Tayna Durr\",\"Age\": 59,\"Latitude\": \"53.09402405506328\",\"Longitude\": \"-8.020019531250002\" },\r\n"
        		+ " {\"Name\": \"Sebastian Gerth\",\"Age\": 47,\"Latitude\": \"52.53627304145948\",\"Longitude\": \"-6.822509765625001\" },\r\n"
        		+ " {\"Name\": \"Sherise Hambly\",\"Age\": 38,\"Latitude\": \"53.39090261307827\",\"Longitude\": \"-7.063240487792548\" },\r\n"
        		+ " {\"Name\": \"Toni Appleby\",\"Age\": 45,\"Latitude\": \"53.89830497300189\",\"Longitude\": \"-8.116737588176672\" },\r\n"
        		+ " {\"Name\": \"Clark Ospina\",\"Age\": 29,\"Latitude\": \"54.06769454247903\",\"Longitude\": \"-8.66817747665899\" },\r\n"
        		+ " {\"Name\": \"Celinda Hamilton\",\"Age\": 39,\"Latitude\": \"53.542786433740105\",\"Longitude\": \"-9.585872216446724\" },\r\n"
        		+ " {\"Name\": \"Larhonda Clutter\",\"Age\": 60,\"Latitude\": \"52.75800064780398\",\"Longitude\": \"-9.124967235028667\" },\r\n"
        		+ " {\"Name\": \"Londa Feld\",\"Age\": 67,\"Latitude\": \"53.00633546237756\",\"Longitude\": \"-8.589988238739855\" },\r\n"
        		+ " {\"Name\": \"Jetta Twomey\",\"Age\": 75,\"Latitude\": \"52.96174013198847\",\"Longitude\": \"-7.289577755453199\" },\r\n"
        		+ " {\"Name\": \"Marianna Strader\",\"Age\": 70,\"Latitude\": \"52.27984782255751\",\"Longitude\": \"-9.205930070018244\" },\r\n"
        		+ " {\"Name\": \"Marylyn Welle\",\"Age\": 29,\"Latitude\": \"52.59207753424467\",\"Longitude\": \"-6.9358576110856855\" },\r\n"
        		+ " {\"Name\": \"Bobbi Byerley\",\"Age\": 71,\"Latitude\": \"54.30235644330621\",\"Longitude\": \"-8.292364324350263\" },\r\n"
        		+ " {\"Name\": \"Cora Jahns\",\"Age\": 59,\"Latitude\": \"53.94136499103616\",\"Longitude\": \"-7.136565237027894\" },\r\n"
        		+ " {\"Name\": \"Delila Hollaway\",\"Age\": 24,\"Latitude\": \"54.1526632034115\",\"Longitude\": \"-6.915094753229597\" },\r\n"
        		+ " {\"Name\": \"John Oehler\",\"Age\": 20,\"Latitude\": \"53.11863254296309\",\"Longitude\": \"-6.942778563704384\" },\r\n"
        		+ " {\"Name\": \"Brittney Eakle\",\"Age\": 20,\"Latitude\": \"52.63830130844275\",\"Longitude\": \"-6.603651885388238\" },\r\n"
        		+ " {\"Name\": \"Arthur Schepis\",\"Age\": 23,\"Latitude\": \"52.42779977379135\",\"Longitude\": \"-6.569047122294754\" },\r\n"
        		+ " {\"Name\": \"Eda Gorby\",\"Age\": 31,\"Latitude\": \"52.495270066269185\",\"Longitude\": \"-7.295747147257919\" },\r\n"
        		+ " {\"Name\": \"Kendal Boltz\",\"Age\": 69,\"Latitude\": \"52.30947784015802\",\"Longitude\": \"-8.091656698408055\" },\r\n"
        		+ " {\"Name\": \"Suk Mccright\",\"Age\": 61,\"Latitude\": \"52.44467704112486\",\"Longitude\": \"-8.077814793170662\" },\r\n"
        		+ " {\"Name\": \"Kirstie Mcneece\",\"Age\": 45,\"Latitude\": \"52.410916007245454\",\"Longitude\": \"-8.85988243844568\" },\r\n"
        		+ " {\"Name\": \"Bruna Ton\",\"Age\": 21,\"Latitude\": \"52.161129420392996\",\"Longitude\": \"-8.756068149165229\" },\r\n"
        		+ " {\"Name\": \"Mabelle Deakins\",\"Age\": 55,\"Latitude\": \"51.90566326251937\",\"Longitude\": \"-8.956775775107436\" },\r\n"
        		+ " {\"Name\": \"Henriette Fitts\",\"Age\": 63,\"Latitude\": \"51.743112417921374\",\"Longitude\": \"-8.936012917251347\" },\r\n"
        		+ " {\"Name\": \"Yu Northam\",\"Age\": 72,\"Latitude\": \"51.927007877958104\",\"Longitude\": \"-9.538135795077968\" },\r\n"
        		+ " {\"Name\": \"Page Bermea\",\"Age\": 48,\"Latitude\": \"52.21628813045871\",\"Longitude\": \"-9.095194827481372\" },\r\n"
        		+ " {\"Name\": \"Tiffani O'Reilly\",\"Age\": 59,\"Latitude\": \"52.28408186101206\",\"Longitude\": \"-9.648871036977118\" },\r\n"
        		+ " {\"Name\": \"Dung Chesser\",\"Age\": 24,\"Latitude\": \"53.33821430342904\",\"Longitude\": \"-7.6902414458859205\" },\r\n"
        		+ " {\"Name\": \"Margarito Bundren\",\"Age\": 51,\"Latitude\": \"53.93321663808781\",\"Longitude\": \"-7.136565236390174\" },\r\n"
        		+ " {\"Name\": \"Howard Encarnacion\",\"Age\": 47,\"Latitude\": \"54.05121158803821\",\"Longitude\": \"-8.576123381079112\" },\r\n"
        		+ " {\"Name\": \"Luci Force\",\"Age\": 46,\"Latitude\": \"53.659327411269004\",\"Longitude\": \"-8.458467186561265\" },\r\n"
        		+ " {\"Name\": \"Mavis Unzueta\",\"Age\": 55,\"Latitude\": \"53.08954691537851\",\"Longitude\": \"-8.472309091798659\" },\r\n"
        		+ " {\"Name\": \"Lindy Gerke\",\"Age\": 43,\"Latitude\": \"52.72221951273094\",\"Longitude\": \"-9.295902453423581\" },\r\n"
        		+ " {\"Name\": \"Kina Clarke\",\"Age\": 19,\"Latitude\": \"52.32640034531732\",\"Longitude\": \"-9.330507216517065\" },\r\n"
        		+ " {\"Name\": \"Irwin Juneau\",\"Age\": 59,\"Latitude\": \"52.05486256870476\",\"Longitude\": \"-9.344349121754458\" },\r\n"
        		+ " {\"Name\": \"Hiedi Pasternak\",\"Age\": 58,\"Latitude\": \"53.85164590770672\",\"Longitude\": \"-6.942778521614808\" },\r\n"
        		+ " {\"Name\": \"Winter Bergman\",\"Age\": 36,\"Latitude\": \"54.01869466415213\",\"Longitude\": \"-7.378798536592707\" },\r\n"
        		+ " {\"Name\": \"Rod Suter\",\"Age\": 51,\"Latitude\": \"54.10805506237944\",\"Longitude\": \"-7.724846167527548\" },\r\n"
        		+ " {\"Name\": \"Chris Hegwood\",\"Age\": 63,\"Latitude\": \"53.91283889073915\",\"Longitude\": \"-7.738688072764941\" },\r\n"
        		+ " {\"Name\": \"Cherlyn Heuser\",\"Age\": 73,\"Latitude\": \"54.74818594314777\",\"Longitude\": \"-8.126261419411966\" },\r\n"
        		+ " {\"Name\": \"Nilsa Marcus\",\"Age\": 59,\"Latitude\": \"54.96729206495634\",\"Longitude\": \"-7.856344242730539\" },\r\n"
        		+ " {\"Name\": \"Neoma Leong\",\"Age\": 56,\"Latitude\": \"54.88775482346\",\"Longitude\": \"-8.167787110571897\" },\r\n"
        		+ " {\"Name\": \"Ezequiel Hepfer\",\"Age\": 69,\"Latitude\": \"54.04308476487112\",\"Longitude\": \"-7.63487375893224\" },\r\n"
        		+ " {\"Name\": \"Lorri Currey\",\"Age\": 25,\"Latitude\": \"54.13644761914938\",\"Longitude\": \"-9.48968906074299\" },\r\n"
        		+ " {\"Name\": \"Christopher Deveau\",\"Age\": 30,\"Latitude\": \"53.80262702783318\",\"Longitude\": \"-9.392795724081234\" },\r\n"
        		+ " {\"Name\": \"Leon Luppino\",\"Age\": 63,\"Latitude\": \"53.904685014071774\",\"Longitude\": \"-7.2888261279974\" },\r\n"
        		+ " {\"Name\": \"Sima Haymon\",\"Age\": 22,\"Latitude\": \"53.96987157268892\",\"Longitude\": \"-7.6833204272631175\" },\r\n"
        		+ " {\"Name\": \"Björk Guðmundsdóttir\",\"Age\": 71,\"Latitude\": \"53.367131555977366\",\"Longitude\": \"-7.551822327507879\" },\r\n"
        		+ " {\"Name\": \"Talitha Laird\",\"Age\": 71,\"Latitude\": \"52.83525354194617\",\"Longitude\": \"-6.610572771365111\" },\r\n"
        		+ " {\"Name\": \"Rochel Hardrick\",\"Age\": 44,\"Latitude\": \"53.10201460568079\",\"Longitude\": \"-6.236841329955483\" },\r\n"
        		+ " {\"Name\": \"Pa Sheckler\",\"Age\": 67,\"Latitude\": \"53.60597741344063\",\"Longitude\": \"-6.271446093048965\" },\r\n"
        		+ " {\"Name\": \"Marguerita Brittian\",\"Age\": 38,\"Latitude\": \"53.67982871947617\",\"Longitude\": \"-6.382181334948116\" },\r\n"
        		+ " {\"Name\": \"Tobie Steffens\",\"Age\": 58,\"Latitude\": \"53.818973032130444\",\"Longitude\": \"-6.347576571854631\" },\r\n"
        		+ " {\"Name\": \"Jamaal Tutor\",\"Age\": 75,\"Latitude\": \"53.810800826759106\",\"Longitude\": \"-6.513679434703355\" },\r\n"
        		+ " {\"Name\": \"Marge Hatten\",\"Age\": 42,\"Latitude\": \"53.69212470034142\",\"Longitude\": \"-7.413403275133943\" },\r\n"
        		+ " {\"Name\": \"Cristine Kravetz\",\"Age\": 54,\"Latitude\": \"53.83122835258862\",\"Longitude\": \"-7.8701861479679325\" },\r\n"
        		+ " {\"Name\": \"Lindy Gerke\",\"Age\": 63,\"Latitude\": \"53.33589589194191\",\"Longitude\": \"-6.296082599573021\" },\r\n"
        		+ " {\"Name\": \"Pa Sheckler\",\"Age\": 27,\"Latitude\": \"51.73179954429017\",\"Longitude\": \"-8.872671965863201\" }, \r\n"
        		+ " {\"Name\": \"Emmaline Beverlin\",\"Age\": 55,\"Latitude\": \"53.52376867470518\",\"Longitude\": \"-7.586427090601362\" },\r\n"
        		+ " {\"Name\": \"Ermelinda Donlon\",\"Age\": 42,\"Latitude\": \"52.96467152455411\",\"Longitude\": \"-7.697162332500511\" },\r\n"
        		+ " {\"Name\": \"Rosalinda Eusebio\",\"Age\": 20,\"Latitude\": \"53.39190213695199\",\"Longitude\": \"-8.174708063190593\" },\r\n"
        		+ " {\"Name\": \"Arlen Turpin\",\"Age\": 62,\"Latitude\": \"53.10201460568079\",\"Longitude\": \"-8.326969020801922\" },\r\n"
        		+ " {\"Name\": \"Diana Strassburg\",\"Age\": 27,\"Latitude\": \"52.914620090650814\",\"Longitude\": \"-8.562281409837615\" },\r\n"
        		+ " {\"Name\": \"Eden Polston\",\"Age\": 71,\"Latitude\": \"52.29678168165427\",\"Longitude\": \"-9.226692861232511\" },\r\n"
        		+ " {\"Name\": \"Keva Lohse\",\"Age\": 45,\"Latitude\": \"52.339088032060765\",\"Longitude\": \"-7.974000437248384\" },\r\n"
        		+ " {\"Name\": \"Porter Wiemann\",\"Age\": 70,\"Latitude\": \"52.43623920881322\",\"Longitude\": \"-9.060589998383787\" },\r\n"
        		+ " {\"Name\": \"Tandy Creegan\",\"Age\": 68,\"Latitude\": \"52.34331644285846\",\"Longitude\": \"-9.192088098139026\" },\r\n"
        		+ " {\"Name\": \"Georgeann Kowalczyk\",\"Age\": 23,\"Latitude\": \"53.57722252951432\",\"Longitude\": \"-9.55197763431126\" },\r\n"
        		+ " {\"Name\": \"Janella Rabalais\",\"Age\": 31,\"Latitude\": \"53.69212470034142\",\"Longitude\": \"-9.475847155505596\" },\r\n"
        		+ " {\"Name\": \"Janel Laubscher\",\"Age\": 61,\"Latitude\": \"53.941364984621565\",\"Longitude\": \"-8.776830941017217\" },\r\n"
        		+ " {\"Name\": \"Margarite Macdougall\",\"Age\": 68,\"Latitude\": \"54.20531997935034\",\"Longitude\": \"-9.517372871217775\" },\r\n"
        		+ " {\"Name\": \"Carma Tirrell\",\"Age\": 58,\"Latitude\": \"54.12022569047719\",\"Longitude\": \"-8.756068083161125\" },\r\n"
        		+ " {\"Name\": \"Keith Merlin\",\"Age\": 71,\"Latitude\": \"53.99835867444377\",\"Longitude\": \"-7.503375659177001\" },\r\n"
        		+ " {\"Name\": \"Jacquelin Luster\",\"Age\": 35,\"Latitude\": \"53.089546943013005\",\"Longitude\": \"-7.697162332500511\" },\r\n"
        		+ " {\"Name\": \"Cecile Olea\",\"Age\": 22,\"Latitude\": \"53.135244045893096\",\"Longitude\": \"-7.392640417277852\" },\r\n"
        		+ " {\"Name\": \"Arnoldo Rucks\",\"Age\": 54,\"Latitude\": \"53.23477831692155\",\"Longitude\": \"-7.281905175378703\" },\r\n"
        		+ " {\"Name\": \"Xenia Noto\",\"Age\": 59,\"Latitude\": \"53.31754715782852\",\"Longitude\": \"-7.510296611795698\" },\r\n"
        		+ " {\"Name\": \"Christiane Aubuchon\",\"Age\": 70,\"Latitude\": \"53.72489643194486\",\"Longitude\": \"-7.537980422270485\" },\r\n"
        		+ " {\"Name\": \"Jason Mcvay\",\"Age\": 36,\"Latitude\": \"53.79445163520835\",\"Longitude\": \"-7.551822327507879\" },\r\n"
        		+ " {\"Name\": \"Priscilla Lampert\",\"Age\": 63,\"Latitude\": \"53.9291419086983\",\"Longitude\": \"-7.7248461429753\" },\r\n"
        		+ " {\"Name\": \"Ilse Luebke\",\"Age\": 40,\"Latitude\": \"53.98208271629691\",\"Longitude\": \"-7.704083285119208\" },\r\n"
        		+ " {\"Name\": \"Danica Rosati\",\"Age\": 34,\"Latitude\": \"53.91283890397367\",\"Longitude\": \"-7.0535137389617075\" }\r\n"
        		+ "\r\n]";
        //Reading the json data
        try {
            JSONArray jsonArray = new JSONArray(json);
            List<People> lst = new ArrayList<People>();
           
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);
                People data = new People();
                data.setName(jsonObj.getString("Name"));
                data.setAge(jsonObj.getInt("Age"));
                data.setLatitude(jsonObj.getDouble("Latitude"));
                data.setLongitude(jsonObj.getDouble("Longitude"));
                lst.add(data);
                
                
            }  //end of json for loop
       //   sorting the data according to age priority  
      for (People p: lst.stream().sorted().collect(Collectors.toList()) )
      {       
    	      // Printing all the peopled  from the json
              System.out.println("Name: " + p.getName() + " "+"Age: " + p.getAge() + " "+ "Latitude: " + " "+p.getLatitude()+" "+"Longitude: " + p.getLongitude());
                
            	  // from Galway Racecourse distance to individual people location distance in kms
                   double lat1 = 53.298810877564875;
                   double lon1 = -8.997003657335881;
                   double lat2 =  p.getLatitude();
                   double lon2 = p.getLongitude();
                 
              System.out.println("Galway Racecourse distance = "+" "+"Name = "+p.getName()+" "+"Age = "+p.getAge()  +" "+"Distance to Vaccine centre= " + haversine(lat1, lon1, lat2, lon2) + " K.M.");
               //  System.out.println(p.getLatitude());
                 
               
            //   System.out.println("---------- City hall Cork Data: ------------ ");
                  // City Hall Cork distance to individual people location distance in kms
                  double lat3 = 51.89742637092438;
                  double lon3 = -8.465763459121026;
                  
                 
             
          System.out.println("City Hall Cork distance = "+" "+"Name = "+p.getName()+" "+"Age = "+ p.getAge() +" "+"Distance to Vaccine centre= " + haversine(lat3, lon3, lat2, lon2) + " K.M.");
              
               // System.out.println("---------- Citywest Convention Centre: ------------ ");
                  // Citywest Convention Centre Dublin distance to individual people location distance in kms
                  double lat5 = 53.28603418885669;
                  double lon5= -6.4444477725802285;
                
                  
          System.out.println("Citywest Convention Centre Dublin = "+" "+"Name = "+p.getName()+" "+"Age = "+ p.getAge() +" "+"Distance to Vaccine centre= " + haversine(lat5, lon5, lat2, lon2) + " K.M.");
          System.out.println("\n");       
              
            }//end of for loop
            
        }//end of try block   
            
       
 catch (JSONException e) {
            e.printStackTrace();
   
        }
        
        

  } //end of main method
    
}//end of class
