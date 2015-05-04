
public class IncompleteCVException extends Exception {
	IncompleteCVException()
    {
        super("Pflichtattribute nicht vollständig gesetzt");
    }
}
