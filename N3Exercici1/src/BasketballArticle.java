public class BasketballArticle extends Article{
    final double BASE_PRICE = 250;
    final int BASE_SCORE = 4;

    private String tournament;
    private String club;

    public BasketballArticle(String headline, int score, double price) {
        super(headline, score, price);
    }

    @Override
    double calculateArticlePrice() {
        double finalPrice = BASE_PRICE;

        if (tournament.equalsIgnoreCase("EuroLliga")) {finalPrice+=75;}
        if (text.contains("Barça") || text.contains("Madrid")) {finalPrice+=75;}

        return finalPrice;
    }

    @Override
    int calculateArticleScore() {
        int finalScore = BASE_SCORE;

        if (tournament.equalsIgnoreCase("EuroLliga")) {finalScore+=3;}
        if (tournament.equalsIgnoreCase("ACB")) {finalScore+=2;}
        if (text.contains("Barça") || text.contains("Madrid")) {finalScore+=1;}

        return finalScore;
    }
}
