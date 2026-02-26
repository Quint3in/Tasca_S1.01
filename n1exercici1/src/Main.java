public class Main {
    public static void main(String[] args) {
        PercussionInstrument drum = new PercussionInstrument("drum1");
        StringInstrument violin = new StringInstrument("violin1");
        WindInstrument flute = new WindInstrument("flute1");

        drum.setPrice(22.22);
        System.out.println(drum.getPrice());
        violin.setPrice(30);
        System.out.println(violin.getPrice());
        flute.setPrice(15);
        System.out.println(flute.getPrice());
        System.out.println(drum.getPrice());

        drum.play();
        violin.play();
        flute.play();
    }
}