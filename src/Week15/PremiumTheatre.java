package Cineplex;

public class PremiumTheatre extends Theatre{
    public PremiumTheatre(String title) {
        super(title, 5, 10);

        // create seats for the front 4 rows 500 THB
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < columns; ++j) {
                seats[i][j] = new Seat(500);
            }
        }

        // create seats for the last row 700 THB
        for (int i = 4; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                seats[i][j] = new Seat(700);
            }
        }
    }
}
