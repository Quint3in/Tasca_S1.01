public abstract class Article {

    protected String headline;
    protected String text;
    protected int score;
    protected double price;

    public Article(String headline, int score, double price) {
        this.headline = headline;
        this.score = score;
        this.price = price;
    }

    abstract double calculateArticlePrice();

    abstract int calculateArticleScore();
}
