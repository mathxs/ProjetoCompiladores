
public class UnaryOperand extends AbstractOperand{
    private float fValue;
    
    public UnaryOperand(float value){
        this.fValue = value;
    }

    @Override
    public float getValue() {
        return this.fValue;
    }

    @Override
    public String toXml() {
       return "<number> "+this.fValue+ "</number>";
    }
    
}
