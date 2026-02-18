public class MotorcylingArticle extends Article{
    final double BASE_PRICE = 100;
    final int BASE_SCORE = 3;

    private String team;

    public MotorcylingArticle(String headline, int score, double price) {
        super(headline, score, price);
    }

    @Override
    double calculateArticlePrice() {
        double finalPrice = BASE_PRICE;

        if (team.equalsIgnoreCase("Honda") ||
            team.equalsIgnoreCase("Yamaha")) {
            finalPrice+=50;
        }
        return finalPrice;
    }

    @Override
    int calculateArticleScore() {
        int finalScore = BASE_SCORE;

        if (team.equalsIgnoreCase("Honda") ||
                team.equalsIgnoreCase("Yamaha")) {
            finalScore+=3;
        }
        return finalScore;
    }
}
