package Cineplex;

abstract public class Theatre {
    private String movieTitle;
    protected int rows;
    protected int columns;
    protected Seat[][] seats;


    public Theatre() {
        this.movieTitle = "Unknown";
        this.rows = 0;
        this.columns = 0;
        this.seats = new Seat[0][0];
    }

    public Theatre(String title, int rows, int columns) {
        this.movieTitle = title;
        this.rows = rows;
        this.columns = columns;
        this.seats = new Seat[rows][columns];
    }

    // TODO Add getters and setters
    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public boolean book(int row, int column) {
        return seats[row][column].book();
    }

    /**
     *
     * @return the sales amount in THB
     */
    public int getRevenue() {
        int revenue = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (!seats[i][j].isAvailable()) {
                    revenue += seats[i][j].getPrice();
                }
            }
        }
        return revenue;
    }

    /**
     *
     * @return the number of tickets sold in this theatre
     */
    public int getNumberOfTicketsSold() {
        int ticketsSold = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (!seats[i][j].isAvailable()) {
                    ticketsSold++;
                }
            }
        }
        return ticketsSold;
    }
}
