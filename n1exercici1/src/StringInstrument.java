public class StringInstrument extends Instrument{
    public StringInstrument(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Està sonant un instrument de corda");
    }
}
