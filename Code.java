import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;


public class firstc {
	
	private static final String LowerCase = "abcdefghijklmnopqrstuvwxyz";
	private static final String UpCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String Numbers = "0123456789";
	private static final String Symbols = "!@#$%^&*()-_=+ ";
	
	public static String strongpassword(int length, boolean includeLowercase, boolean includeUppercase, boolean includeNumbers, boolean includeSymbols) {
		StringBuilder password = new StringBuilder();
		String charset = " ";
		if(includeLowercase) charset+=LowerCase;
		if(includeUppercase) charset+=UpCase;
		if(includeNumbers) charset+=Numbers;
		if(includeSymbols) charset+=Symbols;
		
		SecureRandom random = new SecureRandom();
		for(int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(charset.length());
            password.append(charset.charAt(randomIndex));
		}
		return password.toString();
	}

	public static void main(String[] args) {
		 int length = 12;
	        boolean includeLowercase = true;
	        boolean includeUppercase = true;
	        boolean includeNumbers = true;
	        boolean includeSymbols = true;
	        
	        String password = strongpassword(length, includeLowercase, includeUppercase, includeNumbers, includeSymbols);
	        String filename = "password.txt";
	        try {
	        	FileWriter writer = new FileWriter(filename);
	        	 writer.write("Generated Password: " + password);
	             writer.close();
	             System.out.println("Password saved to " + filename);
	        	
	        }catch (IOException e) {
	        	
	        	 System.out.println("An error occurred while saving the password to " + filename);
	             e.printStackTrace();
	        	
	        }
	
	}

}
