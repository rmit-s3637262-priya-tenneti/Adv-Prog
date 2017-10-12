package utilities;

import assignment.Athlete;
import assignment.Official;
import assignment.Participant;

//Class created to load the required hard coded values to the Participant type arrays(athletes and officials)
public class Data {

	private static Participant[] athlete = new Athlete[32];
	private static Participant[] officialData = new Official[3];

	public static void loadAthlethes() {

		athlete[0] = new Athlete("R01", "Nevy", 28, "VIC", "Sprinter", 0);
		athlete[1] = new Athlete("R02", "Priya", 34, "QLD", "Sprinter", 0);
		athlete[2] = new Athlete("R03", "Maria", 24, "TAS", "Sprinter", 0);
		athlete[3] = new Athlete("R04", "Love", 25, "SA", "Sprinter", 0);
		athlete[4] = new Athlete("R05", "Anisha", 33, "NSW", "Sprinter", 0);
		athlete[5] = new Athlete("R06", "Peter", 29, "NT", "Sprinter", 0);
		athlete[6] = new Athlete("R07", "Chris", 32, "QLD", "Sprinter", 0);
		athlete[7] = new Athlete("R08", "Carol", 28, "VIC", "Sprinter", 0);
		athlete[8] = new Athlete("S01", "Bijju", 28, "TAS", "Swimmer", 0);
		athlete[9] = new Athlete("S02", "Sasha", 28, "ACT", "Swimmer", 0);
		athlete[10] = new Athlete("S03", "Thrini", 31, "NSW", "Swimmer", 0);
		athlete[11] = new Athlete("S04", "Abhi", 32, "VIC", "Swimmer", 0);
		athlete[12] = new Athlete("S05", "Ram", 29, "NSW", "Swimmer", 0);
		athlete[13] = new Athlete("S06", "Sita", 38, "TAS", "Swimmer", 0);
		athlete[14] = new Athlete("S07", "Emma", 25, "SA", "Swimmer", 0);
		athlete[15] = new Athlete("S08", "Amma", 25, "NSW", "Swimmer", 0);
		athlete[16] = new Athlete("C01", "Koti", 27, "VIC", "Cyclist", 0);
		athlete[17] = new Athlete("C02", "Bren", 31, "NSW", "Cyclist", 0);
		athlete[18] = new Athlete("C03", "Kegi", 29, "QLD", "Cyclist", 0);
		athlete[19] = new Athlete("C04", "Bala", 28, "NSW", "Cyclist", 0);
		athlete[20] = new Athlete("C05", "Brundha", 23, "VIC", "Cyclist", 0);
		athlete[21] = new Athlete("C06", "Sanket", 38, "NT", "Cyclist", 0);
		athlete[22] = new Athlete("C07", "Alisha", 30, "TAS", "Cyclist", 0);
		athlete[23] = new Athlete("C08", "Mayu", 24, "NSW", "Cyclist", 0);
		athlete[24] = new Athlete("SA01", "Rochelle", 37, "VIC", "SuperAthlete", 0);
		athlete[25] = new Athlete("SA02", "Pingu", 34, "ACT", "SuperAthlete", 0);
		athlete[26] = new Athlete("SA03", "Bangu", 29, "ACT", "SuperAthlete", 0);
		athlete[27] = new Athlete("SA04", "Monica", 27, "QLD", "SuperAthlete", 0);
		athlete[28] = new Athlete("SA05", "Kanna", 33, "SA", "SuperAthlete", 0);
		athlete[29] = new Athlete("SA06", "Joey", 37, "NT", "SuperAthlete", 0);
		athlete[30] = new Athlete("SA07", "Harvey", 34, "VIC", "SuperAthlete", 0);
		athlete[31] = new Athlete("SA08", "Donna", 30, "NSW", "SuperAthlete", 0);
	}

	public static void loadOfficials() {
		officialData[0] = new Official("O01", "Samuel", 42, "NSW");
		officialData[1] = new Official("O02", "Jack", 38, "VIC");
		officialData[2] = new Official("O03", "Jane", 45, "SA");
	}

	public Participant[] getAthlete() {
		return athlete;
	}
	
	public Participant[] getOfficials() {
		return officialData;
	}

}
