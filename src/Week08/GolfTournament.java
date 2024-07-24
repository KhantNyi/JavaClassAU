// Khant Nyi Thu
// 6632108
// 541

package week08;

import java.io.*;
import java.util.*;

public class GolfTournament {
    private List<Golfer> golfers;

    public GolfTournament() {
        golfers = new ArrayList<>();
        loadGolfers();
    }

    private void loadGolfers() {
        File file = new File("golfers.csv");
        if (!file.exists()) {
            return;
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0].trim());
                String firstName = tokens[1].trim();
                String lastName = tokens[2].trim();
                Golfer golfer = new Golfer(id, firstName, lastName);
                for (int i = 0; i < 4; i++) {
                    golfer.setScore(i + 1, Integer.parseInt(tokens[i + 3].trim()));
                }
                golfers.add(golfer);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveGolfers() {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter("golfers.csv"));
            for (Golfer golfer : golfers) {
                pw.print(golfer.getId() + "," + golfer.getFirstName() + "," + golfer.getLastName());
                for (int i = 0; i < 4; i++) {
                    pw.print("," + golfer.getScore(i + 1));
                }
                pw.println();
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Golfer findGolferById(int id) {
        for (Golfer golfer : golfers) {
            if (golfer.getId() == id) {
                return golfer;
            }
        }
        return null;
    }

    public void addGolfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Golfer ID: ");
        int id = scanner.nextInt();
        if (findGolferById(id) != null) {
            System.out.println("Golfer ID already exists.");
            return;
        }
        scanner.nextLine();  // Consume newline
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        Golfer golfer = new Golfer(id, firstName, lastName);
        golfers.add(golfer);
        saveGolfers();
    }

    public void updateGolferScore() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Golfer ID: ");
        int id = scanner.nextInt();
        Golfer golfer = findGolferById(id);
        if (golfer == null) {
            System.out.println("Golfer ID does not exist.");
            return;
        }
        System.out.print("Enter Round (1-4): ");
        int round = scanner.nextInt();
        if (round < 1 || round > 4) {
            System.out.println("Invalid round number.");
            return;
        }
        System.out.print("Enter Score: ");
        int score = scanner.nextInt();
        golfer.setScore(round, score);
        saveGolfers();
    }

    public void displayGolferList() {
        golfers.sort(Comparator.comparing(Golfer::getLastName).thenComparing(Golfer::getFirstName));
        for (Golfer golfer : golfers) {
            System.out.println(golfer);
        }
    }

    public void showLeaderBoard() {
        golfers.sort(Comparator.comparingInt(Golfer::getTotalScore));
        for (int i = 0; i < Math.min(10, golfers.size()); i++) {
            System.out.println(golfers.get(i));
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add a new golfer");
            System.out.println("2. Update a golfer's score");
            System.out.println("3. Display golfer list (sorted by last name)");
            System.out.println("4. Show the leader board");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addGolfer();
                    break;
                case 2:
                    updateGolferScore();
                    break;
                case 3:
                    displayGolferList();
                    break;
                case 4:
                    showLeaderBoard();
                    break;
                case 5:
                    saveGolfers();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        GolfTournament tournament = new GolfTournament();
        tournament.run();
    }
}
