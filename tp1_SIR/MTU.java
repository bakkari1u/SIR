import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */

/**
 * @author afrass
 *
 */
public class MTU {

	/**
	 * @param args
	 */
	
	private static final String FILENAME = "/home/m2eserv/afrass/Desktop/tp1/Log-clients-themes.txt";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		BufferedReader br2 = null;
		FileReader fr = null;
		FileReader fr2 = null;

		try {

			//br = new BufferedReader(new FileReader(FILENAME));
			fr = new FileReader(FILENAME);
			fr2 = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			br2 = new BufferedReader(fr2);

			String sCurrentLine;
			String sCompareLine;
			int[][] mut = new int[9][5];
			int i =0;
			int j=0;
			int hit=1;
			
			String ordre;
			String usager;
			String theme;
			String ordre2;
			String usager2;
			String theme2;
			
			while ((sCurrentLine = br.readLine()) != null) {
				
				//System.out.println(sCurrentLine);
				String[] parts = sCurrentLine.split(";");
				ordre = parts[0];
				usager = parts[1];
				theme = parts[2]; 
				while((sCompareLine = br2.readLine()) != null && sCompareLine != sCurrentLine){
				
					String[] parts2 = sCompareLine.split(";");
					ordre2 = parts2[0];
					usager2 = parts2[1];
					theme2 = parts2[2]; 
					if(!ordre2.equals(ordre) && usager.equals(usager2) && theme.equals(theme2)){
						mut[i][j]=hit+1;
					}
					j++;
					hit=1;
				}
				i++;
			}
			for (int y = 0; y < mut.length; ++y) {
		        for (int x = 0; x < mut[y].length; ++x) {
		            System.out.print(mut[y][x]);
		        }
		        System.out.println();
		    }

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

				if (br2 != null)
					br2.close();

				if (fr2 != null)
					fr2.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		
		  
	}
	}
}

