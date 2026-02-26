public class WindInstrument extends Instrument{
    public WindInstrument(String name) {
        super(name);
    }

    @Override
    public void play() {
        System.out.println("Està sonant un instrument de vent");
    }
}
