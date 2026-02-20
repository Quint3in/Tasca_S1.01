import utils.InputUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static utils.InputUtils.enterToContinue;
import static utils.InputUtils.readValidNumber;
import static utils.InputUtils.readValidString;

public class Main {
    static void main(String[] args) {
        Map<String, Writer> writers = new HashMap<>();
        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            showMainMenu();
            int option = readValidNumber(input);
            running = handleMainOption(option, writers, input);
        }
    }

    private static void showMainMenu() {
        System.out.println("""
                --MENU--
                1.Introduir redactor
                2.Eliminar redactor
                3.Introduir noticia a un redactor
                4.Eliminar noticia (cal demanar el redactor i el titular de la noticia)
                5.Mostrar totes les noticies d'un redactor
                6.Calcular puntuacio d'una noticia
                7.Calcular preu d'una noticia
                8.Sortir""");
    }

    private static boolean handleMainOption(int option, Map<String, Writer> writers, Scanner input) {
        switch (option) {
            case 1:
                addWriter(writers, input);
                return true;
            case 2:
                removeWriter(writers, input);
                return true;
            case 3:
                addArticleToWriter(writers, input);
                return true;
            case 4:
                removeArticle(writers,input);
                return true;
            case 5:
                showArticlesPerWriter(writers,input);
                return true;
            case 6:
                calculateScorePerArticle(writers,input);
                return true;
            case 7:
                calculatePricePerArticle(writers,input);
                return true;
            case 8:
                return false;
            default:
                System.out.println("Numero no valid");
                enterToContinue(input);
                return true;
        }
    }

    private static void addWriter(Map<String, Writer> writers, Scanner input) {
        System.out.println("DNI del redactor:");
        String writerDNI = readValidString(input);

        System.out.println("Nom del redactor:");
        String writerName = readValidString(input);

        writers.put(writerDNI, new Writer(writerDNI, writerName));
    }

    private static void removeWriter(Map<String, Writer> writers, Scanner input) {
        System.out.println("DNI del redactor:");
        writers.remove(readValidString(input));
    }
    private static Writer askWriter(Map<String, Writer> writers, Scanner input) {
        System.out.println("DNI del redactor:");
        Writer writer = writers.get(readValidString(input));
        if (writer == null) {
            System.out.println("Redactor inexistent");
            return null;
        }
        return writer;
    }
    private static void addArticleToWriter(Map<String, Writer> writers, Scanner input) {
        Writer writer = askWriter(writers,input);

        System.out.println("Titular:");
        String headline = readValidString(input);

        System.out.println("Text:");
        String text = readValidString(input);

        int articleType = askArticleType(input);
        if (articleType < 1 || articleType > 5) {
            System.out.println("Tipus de noticia no valid");
            return;
        }

        Article newArticle = createArticle(articleType, headline, text, input);
        if (newArticle == null) {
            return;
        }

        if (writer != null) {
            writer.addArticle(newArticle);
        }
        System.out.println("Noticia amb el titular '" + headline + "' afegida");
    }

    private static int askArticleType(Scanner input) {
        System.out.println("""
                Que tipus de noticia vols introduir:
                1.Futbol
                2.Basquet
                3.Tenis
                4.F1
                5.Motociclisme""");
        return readValidNumber(input);
    }

    private static Article createArticle(int articleType, String headline, String text, Scanner input) {
        return switch (articleType) {
            case 1 -> createFootballArticle(headline, text, input);
            case 2 -> createBasketballArticle(headline, text, input);
            case 3 -> createTennisArticle(headline, text, input);
            case 4 -> createF1Article(headline, text, input);
            case 5 -> createMotorcyclingArticle(headline, text, input);
            default -> null;
        };
    }

    private static Article createFootballArticle(String headline, String text, Scanner input) {
        FootballArticle article = new FootballArticle(headline);
        article.setText(text);

        System.out.println("Competicio:");
        article.setTournament(readValidString(input));

        System.out.println("Club:");
        article.setClub(readValidString(input));

        System.out.println("Jugador:");
        article.setPlayer(readValidString(input));

        return article;
    }

    private static Article createBasketballArticle(String headline, String text, Scanner input) {
        BasketballArticle article = new BasketballArticle(headline);
        article.setText(text);

        System.out.println("Competicio:");
        article.setTournament(readValidString(input));

        System.out.println("Club:");
        article.setClub(readValidString(input));

        return article;
    }

    private static Article createTennisArticle(String headline, String text, Scanner input) {
        TennisArticle article = new TennisArticle(headline);
        article.setText(text);

        System.out.println("Competicio:");
        article.setTournament(readValidString(input));

        boolean morePlayers = true;
        while (morePlayers) {
            System.out.println("Escriu el nom de jugadors o 'suficient' si has acabat:");
            String player = readValidString(input);

            if (player.equalsIgnoreCase("suficient")) {
                morePlayers = false;
            } else {
                article.addPlayer(player);
            }
        }

        return article;
    }

    private static Article createF1Article(String headline, String text, Scanner input) {
        F1Article article = new F1Article(headline);
        article.setText(text);

        System.out.println("Escuderia:");
        article.setConstructorTeam(readValidString(input));

        return article;
    }

    private static Article createMotorcyclingArticle(String headline, String text, Scanner input) {
        MotorcyclingArticle article = new MotorcyclingArticle(headline);
        article.setText(text);

        System.out.println("Escuderia:");
        article.setTeam(readValidString(input));

        return article;
    }
    private static void removeArticle(Map<String, Writer> writers, Scanner input) {
        Writer writer = askWriter(writers,input);
        System.out.println("Titular de la noticia:");
        if (writer != null) {
            writer.removeArticle(readValidString(input));
        }
    }
    private static void showArticlesPerWriter (Map<String, Writer> writers, Scanner input) {
        Writer writer = askWriter(writers,input);
        if (writer != null) {
            writer.showHeadlines();
        }
    }
    private static void calculateScorePerArticle (Map<String, Writer> writers, Scanner input) {
        Writer writer = askWriter(writers,input);
        System.out.println("Titular de la noticia:");
        Article article;
        if (writer != null) {
            article = writer.getArticle(InputUtils.readValidString(input));

            int score = article.calculateArticleScore();
            System.out.println("La puntuació d'aquesta noticia es " + score);
            article.setScore(score);
        }
    }
    private static void calculatePricePerArticle (Map<String, Writer> writers, Scanner input) {
        Writer writer = askWriter(writers,input);
        System.out.println("Titular de la noticia:");
        Article article;
        if (writer != null) {
            article = writer.getArticle(InputUtils.readValidString(input));


            double price = article.calculateArticlePrice();
            System.out.println("El preu d'aquesta noticia es " + price);
            article.setPrice(price);
        }
    }
}
