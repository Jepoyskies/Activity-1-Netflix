import java.util.ArrayList;

class Film {
    private String name;
    private String category;
    private int length;
    private int score;

    public Film(String name, String category, int length) {
        this.name = name;
        this.category = category;
        this.length = length;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void showDetails() {
        System.out.println("Movie: " + name);
        System.out.println("Category: " + category);
        System.out.println("Length: " + length + " minutes");
        System.out.println("Rating: " + (score == 0 ? "No rating yet" : score + "/5"));
    }

    public void start() {
        System.out.println("Now showing: " + name + "... Enjoy watching!");
    }

    public void giveRating(int score) {
        if (score >= 1 && score <= 5) {
            this.score = score;
            System.out.println("You rated " + name + " a " + score + "/5");
        } else {
            System.out.println("Invalid rating. Please use a number between 1 and 5.");
        }
    }
}

public class MovieApp {
    private static ArrayList<Film> films = new ArrayList<>();

    public static void main(String[] args) {
        films.add(new Film("Interstellar", "Sci-Fi", 169));
        films.add(new Film("The Godfather", "Crime", 175));
        films.add(new Film("A Quiet Place", "Horror", 90));
        films.add(new Film("Superbad", "Comedy", 113));

        listFilms();
        getFilmDetails(2);
        watchFilm(3);
        reviewFilm(1, 5);
        reviewFilm(4, 3);
    }

    private static void listFilms() {
        System.out.println("\nMovies Available:");
        for (int i = 0; i < films.size(); i++) {
            System.out.println((i + 1) + ". " + films.get(i).getName());
        }
    }

    private static void getFilmDetails(int filmIndex) {
        if (isValid(filmIndex - 1)) {
            films.get(filmIndex - 1).showDetails();
        } else {
            System.out.println("Invalid choice. Try again.");
        }
    }

    private static void watchFilm(int filmIndex) {
        if (isValid(filmIndex - 1)) {
            films.get(filmIndex - 1).start();
        } else {
            System.out.println("Invalid choice. Try again.");
        }
    }

    private static void reviewFilm(int filmIndex, int score) {
        if (isValid(filmIndex - 1)) {
            films.get(filmIndex - 1).giveRating(score);
        } else {
            System.out.println("Invalid choice. Try again.");
        }
    }

    private static boolean isValid(int index) {
        return index >= 0 && index < films.size();
    }
}
