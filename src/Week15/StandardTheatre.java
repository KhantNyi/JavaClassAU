package Cineplex;

public class StandardTheatre extends Theatre {
    public StandardTheatre(String title) {
        super(title, 10, 20);

        // create seats for the front section 200 THB
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < columns; ++j) {
                seats[i][j] = new Seat(200);
            }
        }

        // create seats for the back section 300 THB
        for (int i = 5; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                seats[i][j] = new Seat(300);
            }
        }
    }

}
