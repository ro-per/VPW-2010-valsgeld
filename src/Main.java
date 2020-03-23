import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x, y, z, getal, n, m;
		HashSet<Character> lichter = new HashSet<Character>();
		HashSet<Character> zwaarder = new HashSet<Character>();
		HashSet<Character> inlezen_Links = new HashSet<Character>();
		HashSet<Character> inlezen_Rechts = new HashSet<Character>();
		// n AANTAL PAKKETTEN----------------------------------------
		n = Integer.parseInt(sc.nextLine());
		for (x = 0; x < n; x++) {
			// CLEAR+INVULLEN
			lichter.clear();
			zwaarder.clear();
			for (char c = 'a'; c <= 'z'; c++) {
				lichter.add(c);
				zwaarder.add(c);
			}
			// AANTAL WEGINGEN PER PAKKET----------------------------
			m = Integer.parseInt(sc.nextLine());
			for (y = 0; y < m; y++) {
				inlezen_Links.clear();
				inlezen_Rechts.clear();
				String[] s = (sc.nextLine()).split(" ");
				for (z = 0; z < s[0].length(); z++) {
					inlezen_Links.add(s[0].charAt(z));
					inlezen_Rechts.add(s[1].charAt(z));
				}
				// VOER OPERATIE UIT---------------------------------
				switch (s[2]) {
				case "evenwicht":
					lichter.removeAll(inlezen_Links);
					lichter.removeAll(inlezen_Rechts);
					zwaarder.removeAll(inlezen_Links);
					zwaarder.removeAll(inlezen_Rechts);
					break;
				case "omhoog":
					lichter.retainAll(inlezen_Rechts);
					zwaarder.retainAll(inlezen_Links);
					break;
				case "omlaag":
					lichter.retainAll(inlezen_Links);
					zwaarder.retainAll(inlezen_Rechts);
					break;
				}
			}
			// PRINT UITKOMST----------------------------------------
			getal = lichter.size() + zwaarder.size();
			switch (getal) {
			case 0: // inconsistent (spreekt elkaar tegen)
				System.out.println("Inconsistente gegevens.");
				break;
			case 1: // lichter of zwaarder
				if (lichter.size() == 1) {
					System.out.println("Het valse geldstuk " + lichter.toString().charAt(1) + " is lichter.");
				} else {
					System.out.println("Het valse geldstuk " + zwaarder.toString().charAt(1) + " is zwaarder.");
				}
				break;
			default: // te weinig (onbepaald)
				System.out.println("Te weinig gegevens.");

				break;
			}
		}
		System.out.println("");
		sc.close();
	}
}