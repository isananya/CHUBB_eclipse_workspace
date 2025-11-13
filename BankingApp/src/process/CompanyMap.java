package process;
import java.util.*;

public class CompanyMap{
    public static void main(String[] args) {
        Map<String, List<String>> companyMap = new HashMap<>();

        companyMap.put("TCS", new ArrayList<>(Arrays.asList("Rohan", "Rohit")));
        companyMap.put("Infosys", new ArrayList<>(Arrays.asList("Priya", "Amit")));
        companyMap.put("Wipro", new ArrayList<>(Arrays.asList("Sneha", "Karan")));
        companyMap.put("HCL", new ArrayList<>(Arrays.asList("Vikram", "Meera")));
        companyMap.put("Accenture", new ArrayList<>(Arrays.asList("Nitin", "Riya")));

        if (!companyMap.containsKey("Cognizant")) {
            companyMap.put("Cognizant", new ArrayList<>(Arrays.asList("Ram", "Sonal")));
        }

        companyMap.forEach((company, employees) -> System.out.println(company + " : " + employees));
        
        if (companyMap.get("Cognizant").contains("Ram")) {
            System.out.println("Ram is working in Cognizant");
        } else {
            System.out.println("Ram not found in Cognizant");
        }
    }
}
