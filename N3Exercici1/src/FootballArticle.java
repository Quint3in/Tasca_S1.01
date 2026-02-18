public class FootballArticle extends Article {
    final double BASE_PRICE = 300;
    final int BASE_SCORE = 5;



    private String tournament;
    private String club;
    private String player;

    public FootballArticle(String headline, int score, double price) {
        super(headline, score, price);
    }

    @Override
    double calculateArticlePrice() {
        double finalPrice = BASE_PRICE;

        if (tournament.equalsIgnoreCase("Lliga de Campions")) {finalPrice+=100;}
        if (text.contains("Barça") || text.contains("Madrid")) {finalPrice+=100;}
        if (text.contains("Ferran Torres") || text.contains("Benzema")) {finalPrice+=50;}

        return finalPrice;
    }
    @Override
    int calculateArticleScore() {
        int finalScore = BASE_SCORE;

        if (tournament.equalsIgnoreCase("Lliga de Campions")) {finalScore+=3;}
        if (tournament.equalsIgnoreCase("Lliga")) {finalScore+=2;}
        if (text.contains("Barça") || text.contains("Madrid")) {finalScore+=1;}
        if (text.contains("Ferran Torres") || text.contains("Benzema")) {finalScore+=1;}

        return finalScore;
    }
}
